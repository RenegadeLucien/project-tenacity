package ui;

import logic.GoalResults;
import logic.Player;
import javafx.scene.input.MouseButton;
import data.dataobjects.Achievement;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Planner extends Application {

    private GridPane root = new GridPane();

    public static void main(String args[]) {
        launch(args);
    }

    private void displayTasks(Player p) {
        TableView taskView = new TableView();
        root.add(taskView, 0, 0);
        root.setAlignment(Pos.TOP_LEFT);
        taskView.setPrefWidth(400);
        taskView.setPrefHeight(550);
        taskView.setEditable(true);
        TableColumn<Entry<String, Double>, String> taskCol = new TableColumn<>("Achievement");
        taskCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<String, Double>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<String, Double>, String> a) {
                return new SimpleStringProperty(a.getValue().getKey());
            }
        });
        TableColumn<Entry<String, Double>, String> timeCol = new TableColumn<>("Effective Time Cost");
        timeCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<String, Double>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<String, Double>, String> a) {
                return new SimpleStringProperty(String.valueOf(a.getValue().getValue()));
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
        root.add(completeTask, 0, 1);
    }

    private void handleRow(Entry<String, Double> row, Player player) {
        GoalResults timeForRequirements = Achievement.getAchievementByName(row.getKey()).getTimeForRequirements(player);
        System.out.println(timeForRequirements.getTotalTime());
        System.out.println(timeForRequirements.getActionsWithTimes());
        System.out.println(Achievement.getAchievementByName(row.getKey()).getGainFromRewards(player));
        displayPlayer(player);
    }

    private void displayPlayer(Player p) {
        TableView skillView = new TableView();
        skillView.setPrefWidth(300);
        skillView.setPrefHeight(550);
        skillView.setEditable(true);
        TableView bankView = new TableView();
        bankView.setPrefWidth(300);
        bankView.setPrefHeight(550);
        bankView.setEditable(true);
        TableView weaponView = new TableView();
        weaponView.setPrefWidth(300);
        weaponView.setPrefHeight(550);
        weaponView.setEditable(true);
        TableView armourView = new TableView();
        armourView.setPrefWidth(300);
        armourView.setPrefHeight(550);
        armourView.setEditable(true);
        TableView qualityView = new TableView();
        qualityView.setPrefWidth(300);
        qualityView.setPrefHeight(550);
        qualityView.setEditable(true);
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
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
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        TableColumn<Entry<String, Double>, String> xpCol = new TableColumn<>("Experience");
        xpCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<String, Double>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<String, Double>, String> a) {
                return new SimpleStringProperty(decimalFormat.format(a.getValue().getValue()));
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
        TableColumn<Entry<String, Integer>, String> qualityCountCol = new TableColumn<>("Count");
        qualityCountCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<String, Integer>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<String, Integer>, String> a) {
                return new SimpleStringProperty(a.getValue().getValue().toString());
            }
        });
        TableColumn<Entry<String, Integer>, String> qualityCol = new TableColumn<>("Quality");
        qualityCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<String, Integer>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<String, Integer>, String> a) {
                return new SimpleStringProperty(a.getValue().getKey());
            }
        });
        TableColumn<String, String> weaponCol = new TableColumn<>("Weapon");
        weaponCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<String, String> a) {
                return new SimpleStringProperty(a.getValue());
            }
        });
        TableColumn<String, String> armourCol = new TableColumn<>("Armour");
        armourCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<String, String> a) {
                return new SimpleStringProperty(a.getValue());
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

        root.add(tabPane, 1, 0);

        Button savePlayer = new Button();
        savePlayer.setText("Save Player Data");
        savePlayer.setOnAction(event -> { savePlayer(p); });
        root.add(savePlayer, 1, 1);
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
            throw new RuntimeException("Could not save player data. Please open a T99 issue.");
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
            displayTasks(player);
            displayPlayer(player);
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to load player data. Verify that a player data file (" + playerName + ".ptp) exists. If so, please open a T99 issue and include your player data file.");
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load internal player class. Please open a T99 issue and include your player data file.");
        }
    }

    private void profileCreation() {
        Text nameText = new Text("Enter profile name:");
        TextField nameEntry = new TextField();
        final ToggleGroup irongroup = new ToggleGroup();
        RadioButton mainscape = new RadioButton("Mainscape");
        mainscape.setToggleGroup(irongroup);
        mainscape.setUserData("Mainscape");
        mainscape.setSelected(true);
        RadioButton ironman = new RadioButton("Ironman (unsupported)");
        ironman.setToggleGroup(irongroup);
        ironman.setUserData("Ironman");
        ironman.setDisable(true);
        RadioButton hardcore = new RadioButton("Hardcore (unsupported)");
        hardcore.setToggleGroup(irongroup);
        hardcore.setUserData("Hardcore");
        hardcore.setDisable(true);
        Button createProfile = new Button();
        createProfile.setText("Create Profile");
        createProfile.setOnAction(event -> {
            Player p = new Player(nameEntry.getText(), irongroup.getSelectedToggle().getUserData().toString());
            root.getChildren().clear();
            displayTasks(p);
            displayPlayer(p);
        });
        root.getChildren().clear();
        root.add(nameText, 0, 0);
        root.add(nameEntry, 1, 0);
        root.add(mainscape, 0, 1);
        root.add(ironman, 0, 2);
        root.add(hardcore, 0, 3);
        root.add(createProfile, 1, 4);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Project Tenacity v0.3.9pa by Iron Lucien");
        Text nameText = new Text("Load profile data:");
        TextField nameEntry = new TextField();
        Button newProfile = new Button();
        newProfile.setText("New Profile");
        newProfile.setOnAction(event -> { profileCreation(); });
        Button loadProfile = new Button();
        loadProfile.setText("Load Profile");
        loadProfile.setOnAction(event -> loadPlayer(nameEntry.getText()));
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        root.add(newProfile, 0, 0);
        root.add(nameText, 0, 3);
        root.add(nameEntry, 1, 3);
        root.add(loadProfile, 0, 4);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}