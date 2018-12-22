package ui;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import data.databases.ItemDatabase;
import data.dataobjects.Armour;
import data.dataobjects.Weapon;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import logic.GoalResults;
import logic.Lamp;
import logic.Player;
import data.dataobjects.Achievement;
import logic.Reward;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Planner extends Application {

    private Group root = new Group();

    private static final String CURRENT_VERSION = "v0.7.3b";

    public static void main(String args[]) {
        launch(args);
    }

    private void displayTasks(Player p) {
        TableView taskView = new TableView();
        root.getChildren().add(taskView);
        taskView.setPrefWidth(500);
        taskView.setPrefHeight(700);
        taskView.setEditable(true);
        TableColumn<Entry<String, Double>, String> taskCol = new TableColumn<>("Achievement");
        taskCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<String, Double>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<String, Double>, String> a) {
                return new SimpleStringProperty(a.getValue().getKey());
            }
        });
        TableColumn<Entry<String, Double>, Double> timeCol = new TableColumn<>("Effective Time Cost");
        timeCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<String, Double>, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue<Double> call(TableColumn.CellDataFeatures<Entry<String, Double>, Double> a) {
                return new SimpleDoubleProperty(a.getValue().getValue()).asObject();
            }
        });
        ObservableList<Entry<String, Double>> tasksWithTimes = FXCollections.observableArrayList(new ArrayList(p.calcAllAchievements().entrySet()));
        tasksWithTimes.sort(Comparator.comparing(Entry::getValue));
        taskView.setItems(tasksWithTimes);
        taskView.getColumns().addAll(taskCol, timeCol);
        taskView.setRowFactory(tv -> {
            TableRow<Entry<String, Double>> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                    Entry<String, Double> clickedRow = row.getItem();
                    handleRow(clickedRow, p);
                }
                if (event.getButton() == MouseButton.SECONDARY) {
                    taskView.getSelectionModel().clearSelection();
                }

            });
            return row;
        });
        Button completeTask = new Button();
        completeTask.setText("Complete Achievement/Recalc");
        completeTask.setOnAction(event -> {
            if (taskView.getSelectionModel().getSelectedItem() != null) {
                p.completeTask(((Entry<String, Double>) (taskView.getSelectionModel().getSelectedItem())).getKey());
                displayTasks(p);
                displayPlayer(p);
            }
            else {
                displayTasks(p);
                displayPlayer(p);
            }
        });
        completeTask.setLayoutY(740);
        root.getChildren().add(completeTask);
    }

    private void handleRow(Entry<String, Double> row, Player player) {
        GoalResults timeForRequirements = Achievement.getAchievementByName(row.getKey()).getTimeForRequirements(player);
        List<Reward> lampRewards = new ArrayList<>();
        for (Lamp lamp : Achievement.getAchievementByName(row.getKey()).getLamps()) {
            lampRewards.add(lamp.getBestReward(player));
        }
        Alert taskInformation = new Alert(AlertType.INFORMATION);
        taskInformation.setResizable(true);
        taskInformation.setTitle("Completion Path Information");
        taskInformation.setHeaderText(row.getKey());
        taskInformation.setContentText(String.format("It will take approximately %f hours to complete this task. To complete this task, you must fulfill the following requirements: %s\n\n" +
                "This involves performing the following actions for the given amounts of time: %s\n\n" +
                "Lamps should be used on the following skills: %s",
            timeForRequirements.getTotalTime(), timeForRequirements.getListofAllRequirements().stream().filter(r -> (!r.meetsRequirement(player) ||
                ItemDatabase.getItemDatabase().getItems().get(r.getQualifier()) != null)).collect(Collectors.toList()),
            timeForRequirements.getSortedActionsWithTimes().toString(), lampRewards.toString()));
        taskInformation.show();
        displayPlayer(player);
    }

    private void displayPlayer(Player p) {
        TableView skillView = new TableView();
        skillView.setPrefWidth(300);
        skillView.setPrefHeight(630);
        skillView.setEditable(true);
        TableView bankView = new TableView();
        bankView.setPrefWidth(300);
        bankView.setPrefHeight(630);
        bankView.setEditable(true);
        TableView weaponView = new TableView();
        weaponView.setPrefWidth(300);
        weaponView.setPrefHeight(630);
        weaponView.setEditable(true);
        TableView armourView = new TableView();
        armourView.setPrefWidth(300);
        armourView.setPrefHeight(630);
        armourView.setEditable(true);
        TableView qualityView = new TableView();
        qualityView.setPrefWidth(300);
        qualityView.setPrefHeight(630);
        qualityView.setEditable(true);
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setLayoutX(700);
        Tab skillTab = new Tab();
        skillTab.setText("Skills");
        skillTab.setContent(skillView);
        tabPane.getTabs().add(skillTab);
        Tab bankTab = new Tab();
        bankTab.setText("Bank");
        bankTab.setContent(bankView);
        tabPane.getTabs().add(bankTab);
        Tab weaponTab = new Tab();
        weaponTab.setText("Weapons");
        weaponTab.setContent(weaponView);
        tabPane.getTabs().add(weaponTab);
        Tab armourTab = new Tab();
        armourTab.setText("Armour");
        armourTab.setContent(armourView);
        tabPane.getTabs().add(armourTab);
        Tab qualityTab = new Tab();
        qualityTab.setText("Qualities");
        qualityTab.setContent(qualityView);
        tabPane.getTabs().add(qualityTab);
        TableColumn<Entry<String, Double>, String> skillCol = new TableColumn<>("Skill");
        skillCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<String, Double>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<String, Double>, String> a) {
                return new SimpleStringProperty(a.getValue().getKey());
            }
        });
        TableColumn<Entry<String, Double>, Double> xpCol = new TableColumn<>("Experience");
        xpCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<String, Double>, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue<Double> call(TableColumn.CellDataFeatures<Entry<String, Double>, Double> a) {
                return new SimpleDoubleProperty(Math.floor(a.getValue().getValue()*10)/10).asObject();
            }
        });
        xpCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        xpCol.setOnEditCommit(
            new EventHandler<TableColumn.CellEditEvent<Entry<String, Double>, Double>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<Entry<String, Double>, Double> t) {
                    ((Entry<String, Double>) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                    ).setValue(t.getNewValue());
                }
            });
        TableColumn<Entry<String, Integer>, String> itemCol = new TableColumn<>("Item");
        itemCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<String, Integer>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<String, Integer>, String> a) {
                return new SimpleStringProperty(a.getValue().getKey());
            }
        });
        TableColumn<Entry<String, Integer>, String> itemCountCol = new TableColumn<>("Count");
        itemCountCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<String, Integer>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<String, Integer>, String> a) {
                return new SimpleStringProperty(a.getValue().getValue().toString());
            }

        });
        itemCountCol.setCellFactory(TextFieldTableCell.forTableColumn());
        itemCountCol.setOnEditCommit(
            new EventHandler<TableColumn.CellEditEvent<Entry<String, Integer>, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<Entry<String, Integer>, String> t) {
                    ((Entry<String, Integer>) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                    ).setValue(Integer.parseInt(t.getNewValue()));
                }
            });
        final TextField addItem = new TextField();
        addItem.setPromptText("Item");
        addItem.setMaxWidth(itemCol.getPrefWidth());
        addItem.setLayoutX(700);
        addItem.setLayoutY(700);
        final TextField addCount = new TextField();
        addCount.setMaxWidth(itemCountCol.getPrefWidth());
        addCount.setPromptText("Count");
        addCount.setLayoutX(800);
        addCount.setLayoutY(700);
        final Text bankValueText = new Text();
        bankValueText.setText(String.format("Total bank value: %d", p.getTotalBankValue()));
        bankValueText.setLayoutX(700);
        bankValueText.setLayoutY(650);
        final Button addToBankButton = new Button("Add");
        addToBankButton.setLayoutX(900);
        addToBankButton.setLayoutY(700);
        final Button removeFromBankButton = new Button("Remove");
        removeFromBankButton.setLayoutX(950);
        removeFromBankButton.setLayoutY(700);
        addToBankButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (ItemDatabase.getItemDatabase().getItems().get(addItem.getText()) == null) {
                    Alert alert = new Alert(AlertType.WARNING, String.format("Input item %s is not present in the items database. Please note that the bank is only meant for tradeable items. " +
                        "If you believe this item is valid, please raise a T90 issue.", addItem.getText()));
                    alert.showAndWait();
                }
                else if (p.getBank().containsKey(addItem.getText())) {
                    Alert alert = new Alert(AlertType.INFORMATION, "This is already in your bank. Please edit the existing entry rather than create a new one.");
                    alert.showAndWait();
                }
                else {
                    try {
                        p.getBank().put(addItem.getText(), Integer.parseInt(addCount.getText()));
                        addItem.clear();
                        addCount.clear();
                        root.getChildren().remove(addItem);
                        root.getChildren().remove(addCount);
                        root.getChildren().remove(bankValueText);
                        root.getChildren().remove(addToBankButton);
                        root.getChildren().remove(removeFromBankButton);
                        root.getChildren().remove(tabPane);
                        displayPlayer(p);
                    }
                    catch (NumberFormatException e) {
                        Alert alert = new Alert(AlertType.INFORMATION, String.format("%s is not an integer. Only integer quantities of items are allowed.", addCount.getText()));
                        alert.showAndWait();
                    }
                }
            }
        });
        removeFromBankButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    p.getBank().remove(itemCol.getCellObservableValue(bankView.getSelectionModel().getSelectedIndex()).getValue());
                } catch (NullPointerException e) {
                    Alert alert = new Alert(AlertType.INFORMATION, "You must select an item to remove it.");
                    alert.showAndWait();
                }
                root.getChildren().remove(addItem);
                root.getChildren().remove(addCount);
                root.getChildren().remove(bankValueText);
                root.getChildren().remove(addToBankButton);
                root.getChildren().remove(removeFromBankButton);
                root.getChildren().remove(tabPane);
                displayPlayer(p);
            }
        });
        TableColumn<String, String> weaponCol = new TableColumn<>("Weapon");
        weaponCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<String, String> a) {
                return new SimpleStringProperty(a.getValue());
            }
        });
        final TextField addWeapon = new TextField();
        addWeapon.setPromptText("Weapon");
        addWeapon.setMaxWidth(itemCol.getPrefWidth());
        addWeapon.setLayoutX(700);
        addWeapon.setLayoutY(700);
        final Button addToWeaponButton = new Button("Add");
        addToWeaponButton.setLayoutX(900);
        addToWeaponButton.setLayoutY(700);
        final Button removeFromWeaponButton = new Button("Remove");
        removeFromWeaponButton.setLayoutX(950);
        removeFromWeaponButton.setLayoutY(700);
        addToWeaponButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Weapon.getWeaponByName(addWeapon.getText()) == null) {
                    Alert alert = new Alert(AlertType.WARNING, String.format("Input weapon %s is not present in the weapons database. " +
                        "If you believe this weapon is valid, please raise a T90 issue.", addWeapon.getText()));
                    alert.showAndWait();
                }
                else if (p.getWeapons().contains(Weapon.getWeaponByName(addWeapon.getText()))) {
                    Alert alert = new Alert(AlertType.INFORMATION, "You already have this weapon--you don't need another one!!");
                    alert.showAndWait();
                }
                else {
                    p.addWeapon(Weapon.getWeaponByName(addWeapon.getText()));
                    addWeapon.clear();
                    root.getChildren().remove(addWeapon);
                    root.getChildren().remove(addToWeaponButton);
                    root.getChildren().remove(removeFromWeaponButton);
                    root.getChildren().remove(tabPane);
                    displayPlayer(p);
                }
            }
        });
        removeFromWeaponButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    p.getWeapons().remove(Weapon.getWeaponByName(weaponCol.getCellObservableValue(weaponView.getSelectionModel().getSelectedIndex()).getValue()));
                } catch (NullPointerException e) {
                    Alert alert = new Alert(AlertType.INFORMATION, "You must select a weapon to remove it.");
                    alert.showAndWait();
                }
                root.getChildren().remove(addWeapon);
                root.getChildren().remove(addToWeaponButton);
                root.getChildren().remove(removeFromWeaponButton);
                root.getChildren().remove(tabPane);
                displayPlayer(p);
            }
        });
        TableColumn<String, String> armourCol = new TableColumn<>("Armour");
        armourCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<String, String> a) {
                return new SimpleStringProperty(a.getValue());
            }
        });
        final TextField addArmour = new TextField();
        addArmour.setPromptText("Armour");
        addArmour.setMaxWidth(itemCol.getPrefWidth());
        addArmour.setLayoutX(700);
        addArmour.setLayoutY(700);
        final Button addToArmourButton = new Button("Add");
        addToArmourButton.setLayoutX(900);
        addToArmourButton.setLayoutY(700);
        final Button removeFromArmourButton = new Button("Remove");
        removeFromArmourButton.setLayoutX(950);
        removeFromArmourButton.setLayoutY(700);
        addToArmourButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Armour.getArmourByName(addArmour.getText()) == null) {
                    Alert alert = new Alert(AlertType.WARNING, String.format("Input Armour %s is not present in the armours database. " +
                        "If you believe this armour is valid, please raise a T90 issue.", addArmour.getText()));
                    alert.showAndWait();
                }
                else if (p.getArmour().contains(Armour.getArmourByName(addArmour.getText()))) {
                    Alert alert = new Alert(AlertType.INFORMATION, "You already have this armour--you don't need another one!!");
                    alert.showAndWait();
                }
                else {
                    p.addArmour(Armour.getArmourByName(addArmour.getText()));
                    addArmour.clear();
                    root.getChildren().remove(addArmour);
                    root.getChildren().remove(addToArmourButton);
                    root.getChildren().remove(removeFromArmourButton);
                    root.getChildren().remove(tabPane);
                    displayPlayer(p);
                }
            }
        });
        removeFromArmourButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    p.getArmour().remove(Armour.getArmourByName(armourCol.getCellObservableValue(armourView.getSelectionModel().getSelectedIndex()).getValue()));
                } catch (NullPointerException e) {
                    Alert alert = new Alert(AlertType.INFORMATION, "You must select an armour to remove it.");
                    alert.showAndWait();
                }
                root.getChildren().remove(addArmour);
                root.getChildren().remove(addToArmourButton);
                root.getChildren().remove(removeFromArmourButton);
                root.getChildren().remove(tabPane);
                displayPlayer(p);
            }
        });
        TableColumn<Entry<String, Integer>, String> qualityCol = new TableColumn<>("Quality");
        qualityCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<String, Integer>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<String, Integer>, String> a) {
                return new SimpleStringProperty(a.getValue().getKey());
            }
        });
        TableColumn<Entry<String, Integer>, String> qualityCountCol = new TableColumn<>("Count");
        qualityCountCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<String, Integer>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<String, Integer>, String> a) {
                return new SimpleStringProperty(a.getValue().getValue().toString());
            }
        });
        qualityCountCol.setCellFactory(TextFieldTableCell.forTableColumn());
        qualityCountCol.setOnEditCommit(
            new EventHandler<TableColumn.CellEditEvent<Entry<String, Integer>, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<Entry<String, Integer>, String> t) {
                    ((Entry<String, Integer>) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                    ).setValue(Integer.parseInt(t.getNewValue()));
                }
            });
        final TextField addQuality = new TextField();
        addQuality.setPromptText("Quality");
        addQuality.setMaxWidth(itemCol.getPrefWidth());
        addQuality.setLayoutX(700);
        addQuality.setLayoutY(700);
        final Button addToQualityButton = new Button("Add");
        addToQualityButton.setLayoutX(900);
        addToQualityButton.setLayoutY(700);
        final Button removeFromQualityButton = new Button("Remove");
        removeFromQualityButton.setLayoutX(950);
        removeFromQualityButton.setLayoutY(700);
        addToQualityButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (p.getBank().containsKey(addItem.getText())) {
                    Alert alert = new Alert(AlertType.INFORMATION, "You already have this quality. Please edit the existing entry rather than create a new one.");
                    alert.showAndWait();
                } else {
                    try {
                        p.getQualities().put(addQuality.getText(), Integer.parseInt(addCount.getText()));
                        addQuality.clear();
                        addCount.clear();
                        root.getChildren().remove(addQuality);
                        root.getChildren().remove(addCount);
                        root.getChildren().remove(addToQualityButton);
                        root.getChildren().remove(removeFromQualityButton);
                        root.getChildren().remove(tabPane);
                        displayPlayer(p);
                    } catch (NumberFormatException e) {
                        Alert alert = new Alert(AlertType.INFORMATION, String.format("%s is not an integer. Only integer quantities of qualities are allowed.", addCount.getText()));
                        alert.showAndWait();
                    }
                }
            }
        });
        removeFromQualityButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    p.getQualities().remove(qualityCol.getCellObservableValue(qualityView.getSelectionModel().getSelectedIndex()).getValue());
                } catch (NullPointerException e) {
                    Alert alert = new Alert(AlertType.INFORMATION, "You must select a quality to remove it.");
                    alert.showAndWait();
                }
                root.getChildren().remove(addQuality);
                root.getChildren().remove(addCount);
                root.getChildren().remove(addToQualityButton);
                root.getChildren().remove(removeFromQualityButton);
                root.getChildren().remove(tabPane);
                displayPlayer(p);
            }
        });
        tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
                if (oldValue.equals(bankTab)) {
                    root.getChildren().remove(addItem);
                    root.getChildren().remove(addCount);
                    root.getChildren().remove(bankValueText);
                    root.getChildren().remove(addToBankButton);
                    root.getChildren().remove(removeFromBankButton);
                }
                if (oldValue.equals(weaponTab)) {
                    root.getChildren().remove(addWeapon);
                    root.getChildren().remove(addToWeaponButton);
                    root.getChildren().remove(removeFromWeaponButton);
                }
                if (oldValue.equals(armourTab)) {
                    root.getChildren().remove(addArmour);
                    root.getChildren().remove(addToArmourButton);
                    root.getChildren().remove(removeFromArmourButton);
                }
                if (oldValue.equals(qualityTab)) {
                    root.getChildren().remove(addQuality);
                    root.getChildren().remove(addCount);
                    root.getChildren().remove(addToQualityButton);
                    root.getChildren().remove(removeFromQualityButton);
                }
                if (newValue.equals(bankTab)) {
                    root.getChildren().add(addItem);
                    root.getChildren().add(addCount);
                    root.getChildren().add(bankValueText);
                    root.getChildren().add(addToBankButton);
                    root.getChildren().add(removeFromBankButton);
                }
                if (newValue.equals(weaponTab)) {
                    root.getChildren().add(addWeapon);
                    root.getChildren().add(addToWeaponButton);
                    root.getChildren().add(removeFromWeaponButton);
                }
                if (newValue.equals(armourTab)) {
                    root.getChildren().add(addArmour);
                    root.getChildren().add(addToArmourButton);
                    root.getChildren().add(removeFromArmourButton);
                }
                if (newValue.equals(qualityTab)) {
                    root.getChildren().add(addQuality);
                    root.getChildren().add(addCount);
                    root.getChildren().add(addToQualityButton);
                    root.getChildren().add(removeFromQualityButton);
                }
            }
        });
        ObservableList<Entry<String, Double>> skillsAndExperience = FXCollections.observableArrayList(p.getXp().entrySet());
        ObservableList<Entry<String, Integer>> itemsAndCount = FXCollections.observableArrayList(p.getBank().entrySet());
        ObservableList<Entry<String, Integer>> qualitiesAndCount = FXCollections.observableArrayList(p.getQualities().entrySet());
        ObservableList<String> weapons = FXCollections.observableArrayList(p.getWeapons().stream().map(a -> a.getName()).collect(Collectors.toList()));
        ObservableList<String> armour = FXCollections.observableArrayList(p.getArmour().stream().map(a -> a.getName()).collect(Collectors.toList()));
        skillView.setItems(skillsAndExperience);
        skillView.getColumns().addAll(skillCol, xpCol);
        bankView.setItems(itemsAndCount);
        bankView.getColumns().addAll(itemCol, itemCountCol);
        weaponView.setItems(weapons);
        weaponView.getColumns().addAll(weaponCol);
        armourView.setItems(armour);
        armourView.getColumns().addAll(armourCol);
        qualityView.setItems(qualitiesAndCount);
        qualityView.getColumns().addAll(qualityCol, qualityCountCol);

        root.getChildren().add(tabPane);

        Button savePlayer = new Button();
        savePlayer.setText("Save Player Data");
        savePlayer.setOnAction(event -> { savePlayer(p); });
        savePlayer.setLayoutX(700);
        savePlayer.setLayoutY(740);
        root.getChildren().add(savePlayer);
    }

    private void savePlayer(Player p) {
        String filename = p.getName() + ".ptp";
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(p);
            out.close();
            file.close();
        }
        catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR, "Could not save player data. Please open a T99 issue.");
            alert.showAndWait();
            throw new RuntimeException(e);
        }
    }

    private void loadPlayer(String playerName) {
        try
        {
            FileInputStream file = new FileInputStream(playerName + ".ptp");
            ObjectInputStream in = new ObjectInputStream(file);
            Player player = (Player)in.readObject();
            in.close();
            file.close();
            root.getChildren().clear();
            getPlayerXp(player);
            displayTasks(player);
            displayPlayer(player);
            displayLampCalc(player);
        }
        catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR, "Failed to load player data. Verify that a player data file (" + playerName + ".ptp) exists. " +
                "If so, please open a T99 issue and include your player data file.");
            alert.showAndWait();
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e) {
            Alert alert = new Alert(AlertType.ERROR, "Failed to load internal player class. Please open a T99 issue and include your player data file.");
            alert.showAndWait();
            throw new RuntimeException(e);
        }
    }

    private void displayLampCalc(Player player) {
        Text lampTitle = new Text("What Should I Use My Lamp On?");
        lampTitle.setLayoutX(510);
        lampTitle.setLayoutY(25);
        ObservableList<String> lampOptions =
            FXCollections.observableArrayList(
                "Flat XP Reward",
                "Flat Level Multiplier",
                "Small prismatic",
                "Medium prismatic",
                "Large prismatic",
                "Huge prismatic",
                "Dragonkin"
            );
        TextField xpNum = new TextField();
        xpNum.setLayoutX(540);
        xpNum.setLayoutY(100);
        xpNum.setPrefWidth(50);
        Text qualifier = new Text("experience");
        qualifier.setLayoutX(600);
        qualifier.setLayoutY(115);
        final ComboBox lampSelection = new ComboBox(lampOptions);
        lampSelection.setLayoutX(510);
        lampSelection.setLayoutY(50);
        lampSelection.valueProperty().setValue("Flat XP Reward");
        lampSelection.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue observable, String oldValue, String newValue) {
                if (!(oldValue.equals("Flat XP Reward") || oldValue.equals("Flat Level Multiplier")) && (newValue.equals("Flat XP Reward") || newValue.equals("Flat Level Multiplier"))) {
                    root.getChildren().add(xpNum);
                    root.getChildren().add(qualifier);
                }
                if (newValue.equals("Flat XP Reward")) {
                    qualifier.setText("experience");
                }
                else if (newValue.equals("Flat Level Multiplier")) {
                    qualifier.setText("times level");
                }
                else {
                    root.getChildren().remove(xpNum);
                    root.getChildren().remove(qualifier);
                }
            }
        });
        Text lampResult = new Text("");
        lampResult.setLayoutX(560);
        lampResult.setLayoutY(200);
        Button calculateLamp = new Button("Calculate");
        calculateLamp.setLayoutX(560);
        calculateLamp.setLayoutY(150);
        calculateLamp.setOnAction(event -> {
            if (lampSelection.valueProperty().getValue().equals("Flat XP Reward")) {
                lampResult.setText(new Lamp(Player.ALL_SKILLS, Integer.parseInt(xpNum.getText()), 1).getBestReward(player).getQualifier());
            }
            else if (lampSelection.valueProperty().getValue().equals("Flat Level Multiplier")) {
                lampResult.setText(new Lamp(Player.ALL_SKILLS, Integer.parseInt(xpNum.getText())*-1, 1).getBestReward(player).getQualifier());
            }
            else if (lampSelection.valueProperty().getValue().equals("Small prismatic")) {
                lampResult.setText(new Lamp(Player.ALL_SKILLS, -1, 1).getBestReward(player).getQualifier());
            }
            else if (lampSelection.valueProperty().getValue().equals("Medium prismatic")) {
                lampResult.setText(new Lamp(Player.ALL_SKILLS, -2, 1).getBestReward(player).getQualifier());
            }
            else if (lampSelection.valueProperty().getValue().equals("Large prismatic")) {
                lampResult.setText(new Lamp(Player.ALL_SKILLS, -4, 1).getBestReward(player).getQualifier());
            }
            else if (lampSelection.valueProperty().getValue().equals("Huge prismatic")) {
                lampResult.setText(new Lamp(Player.ALL_SKILLS, -8, 1).getBestReward(player).getQualifier());
            }
            else if (lampSelection.valueProperty().getValue().equals("Dragonkin")) {
                lampResult.setText(new Lamp(Player.ALL_SKILLS, -9, 1).getBestReward(player).getQualifier());
            }
        });
        root.getChildren().add(lampTitle);
        root.getChildren().add(lampSelection);
        root.getChildren().add(xpNum);
        root.getChildren().add(qualifier);
        root.getChildren().add(calculateLamp);
        root.getChildren().add(lampResult);
    }

    private void profileCreation() {
        TextField nameEntry = new TextField();
        nameEntry.setLayoutX(450);
        nameEntry.setLayoutY(290);
        nameEntry.setPromptText("Profile Name");
        final ToggleGroup irongroup = new ToggleGroup();
        RadioButton mainscape = new RadioButton("Mainscape");
        mainscape.setToggleGroup(irongroup);
        mainscape.setUserData("Mainscape");
        mainscape.setSelected(true);
        mainscape.setLayoutX(450);
        mainscape.setLayoutY(320);
        RadioButton ironman = new RadioButton("Ironman (unsupported)");
        ironman.setToggleGroup(irongroup);
        ironman.setUserData("Ironman");
        ironman.setDisable(true);
        ironman.setLayoutX(450);
        ironman.setLayoutY(350);
        RadioButton hardcore = new RadioButton("Hardcore (unsupported)");
        hardcore.setToggleGroup(irongroup);
        hardcore.setUserData("Hardcore");
        hardcore.setDisable(true);
        hardcore.setLayoutX(450);
        hardcore.setLayoutY(380);
        Button createProfile = new Button();
        createProfile.setText("Create Profile");
        createProfile.setOnAction(event -> {
            Player p = new Player(nameEntry.getText(), irongroup.getSelectedToggle().getUserData().toString());
            try {
                getPlayerXp(p);
            } catch (Exception e) {
                Alert alert = new Alert(AlertType.WARNING, String.format("Failed to get player XP from RuneMetrics. Continuing with fresh account stats. Note that Project Tenacity cannot " +
                    "get data from private profiles. If you believe the name '%s' was valid, please raise a T99 issue.", p.getName()));
                alert.showAndWait();
            }
            try  {
                getPlayerQuests(p);
            } catch (Exception e) {
                Alert alert = new Alert(AlertType.WARNING, String.format("Failed to get player quests from RuneMetrics. Continuing with no quests completed. Note that Project Tenacity cannot " +
                    "get data from private profiles. If you believe the name '%s' was valid, please raise a T99 issue.", p.getName()));
                alert.showAndWait();
            }
            root.getChildren().clear();
            displayTasks(p);
            displayPlayer(p);
            displayLampCalc(p);
        });
        createProfile.setLayoutX(450);
        createProfile.setLayoutY(410);
        Button backButton = new Button();
        backButton.setLayoutX(500);
        backButton.setLayoutY(550);
        backButton.setText("Back");
        backButton.setOnAction(event -> {
            displayMainScreen();
        });
        root.getChildren().clear();
        root.getChildren().add(nameEntry);
        root.getChildren().add(mainscape);
        root.getChildren().add(ironman);
        root.getChildren().add(hardcore);
        root.getChildren().add(createProfile);
        root.getChildren().add(backButton);
    }

    private void getPlayerXp(Player player) {
        String alteredName = player.getName().replace(' ', '_');
        Scanner runeMetricsSkillScanner;
        try {
            runeMetricsSkillScanner = new Scanner(new URL("https://apps.runescape.com/runemetrics/profile/profile?user=" + alteredName).openStream());
        }
        catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, String.format("Looks like the name %s doesn't fit into a URL for some reason. Please raise a T99 issue.", alteredName));
            alert.showAndWait();
            throw new IllegalArgumentException(e);
        }
        JsonObject jsonObject = new JsonParser().parse(runeMetricsSkillScanner.nextLine()).getAsJsonObject();
        runeMetricsSkillScanner.close();
        JsonArray skillValues = (jsonObject.get("skillvalues").getAsJsonArray());
        for (JsonElement skill : skillValues) {
            JsonObject skillObject = (JsonObject) skill;
            String skillName = Player.ALL_SKILLS.get(skillObject.get("id").getAsInt());
            player.getXp().put(skillName, skillObject.get("xp").getAsDouble()/10.0);
        }
    }

    private void getPlayerQuests(Player player) {
        String alteredName = player.getName().replace(' ', '_');
        Scanner runeMetricsQuestScanner;
        try {
            runeMetricsQuestScanner = new Scanner(new URL("https://apps.runescape.com/runemetrics/quests?user=" + alteredName).openStream());
        }
        catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, String.format("Looks like the name %s doesn't fit into a URL for some reason. Please raise a T99 issue.", alteredName));
            alert.showAndWait();
            throw new IllegalArgumentException(String.format("Looks like the name %s doesn't fit into a URL for some reason. Please raise a T99 issue.", alteredName), e);
        }
        JsonObject jsonObject = new JsonParser().parse(runeMetricsQuestScanner.nextLine()).getAsJsonObject();
        runeMetricsQuestScanner.close();
        JsonArray questValues = (jsonObject.get("quests").getAsJsonArray());
        for (JsonElement quest : questValues) {
            JsonObject questObject = (JsonObject) quest;
            String questName = questObject.get("title").getAsString();
            String questStatus = questObject.get("status").getAsString();
            int questPoints = questObject.get("questPoints").getAsInt();
            if (questStatus.equals("COMPLETED")) {
                player.getQualities().put(questName, 1);
                if (player.getQualities().keySet().contains("Quest points")) {
                    player.getQualities().put("Quest points", player.getQualities().get("Quest points") + questPoints);
                }
                else {
                    player.getQualities().put("Quest points", questPoints);
                }
            }
        }
    }

    private void checkGeDataAge() {
        File geData = new File("gedata.txt");
        if (geData.exists()) {
            try {
                long daysSinceGeUpdate = (System.currentTimeMillis() - Files.getFileAttributeView(Paths.get("gedata.txt"), BasicFileAttributeView.class).readAttributes().creationTime().toMillis()) / 86400000;
                if (daysSinceGeUpdate >= 7) {
                    Alert alert = new Alert(AlertType.INFORMATION, String.format("Your GE data file is %d days old. It is recommended to refresh your GE data by deleting your gedata.txt file and " +
                        "restarting Project Tenacity.", daysSinceGeUpdate));
                    alert.setHeaderText("Your GE Data Is Outdated");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                Alert alert = new Alert(AlertType.ERROR, "Looks like the check for outdated GE data failed. Please raise a T90 issue.");
                alert.showAndWait();
            }
        }
    }

    private void checkForUpdates() {
        try {
            Scanner updateCheckScanner = new Scanner(new URL("https://api.github.com/repos/RenegadeLucien/project-tenacity/releases").openStream());
            JsonArray jsonArray = new JsonParser().parse(updateCheckScanner.nextLine()).getAsJsonArray();
            updateCheckScanner.close();
            String latestVersion = jsonArray.get(0).getAsJsonObject().get("tag_name").getAsString();
            if (!latestVersion.equals(CURRENT_VERSION)) {
                Alert alert = new Alert(AlertType.INFORMATION, String.format("Version %s has been released. It can be downloaded from the Github releases page.", latestVersion));
                alert.setHeaderText("Update Available");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, "Looks like the update check failed. Please raise a T90 issue.");
            alert.showAndWait();
        }
    }

    private void displayMainScreen() {
        root.getChildren().clear();
        Button newProfile = new Button();
        newProfile.setLayoutX(450);
        newProfile.setLayoutY(320);
        newProfile.setText("New Profile");
        newProfile.setOnAction(event -> { profileCreation(); });
        TextField nameEntry = new TextField();
        nameEntry.setLayoutX(450);
        nameEntry.setLayoutY(360);
        nameEntry.setPromptText("Profile Name");
        Button loadProfile = new Button();
        loadProfile.setText("Load Profile");
        loadProfile.setOnAction(event -> loadPlayer(nameEntry.getText()));
        loadProfile.setLayoutX(450);
        loadProfile.setLayoutY(390);
        root.getChildren().add(newProfile);
        root.getChildren().add(nameEntry);
        root.getChildren().add(loadProfile);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(String.format("Project Tenacity %s by Iron Lucien", CURRENT_VERSION));
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.setResizable(false);
        displayMainScreen();
        primaryStage.show();
        checkForUpdates();
        checkGeDataAge();
    }
}