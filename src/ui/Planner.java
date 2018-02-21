package ui;

import dynamicdata.Player;
import dynamicdata.Requirement;
import javafx.scene.input.MouseButton;
import staticdata.Achievement;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

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
        taskView.setPrefWidth(300);
        taskView.setPrefHeight(550);
        taskView.setEditable(true);
        TableColumn<Entry<Achievement, Double>, String> taskCol = new TableColumn<>("Achievement");
        taskCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<Achievement, Double>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<Achievement, Double>, String> a) {
                return new SimpleStringProperty(a.getValue().getKey().getName());
            }
        });
        TableColumn<Entry<Achievement, Double>, String> timeCol = new TableColumn<>("Effective Time Cost");
        timeCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<Achievement, Double>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<Achievement, Double>, String> a) {
                return new SimpleStringProperty(a.getValue().getValue().toString());
            }
        });
        ObservableList<Entry<Achievement, Double>> tasksWithTimes = FXCollections.observableArrayList(p.getPlayerTasks().entrySet()
            .stream().filter(k -> k.getKey().isDisplay()).collect(Collectors.toList()));
        taskView.setItems(tasksWithTimes);
        taskView.getColumns().addAll(taskCol, timeCol);
        taskView.setRowFactory(tv -> {
            TableRow<Entry<Achievement, Double>> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                    Entry<Achievement, Double> clickedRow = row.getItem();
                    handleRow(clickedRow, p);
                }
            });
            return row;
        });
        Button completeTask = new Button();
        completeTask.setText("Complete Achievement");
        completeTask.setOnAction(event -> {
            if (taskView.getSelectionModel().getSelectedItem() != null) {
                p.completeTask(((Entry<Achievement, Double>) (taskView.getSelectionModel().getSelectedItem())).getKey());
                displayTasks(p);
                displayPlayer(p);
            }
        });
        root.add(completeTask, 0, 1);
    }

    private void handleRow(Entry<Achievement, Double> row, Player player) {
        System.out.println(row.getKey().getTimeForRequirements(player).getTotalTime());
        System.out.println(row.getKey().getTimeForRequirements(player).getActionsWithTimes());
        for (Requirement r : row.getKey().getTimeForRequirements(player).getRequirements()) {
            System.out.print(r.getQualifier() + " " + r.getQuantifier() + ", ");
        }
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
        TableColumn<Entry<String, Double>, String> xpCol = new TableColumn<>("Experience");
        xpCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entry<String, Double>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Entry<String, Double>, String> a) {
                return new SimpleStringProperty(a.getValue().getValue().toString());
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
        System.out.println(p.getPlayerTasks().size());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Project Tenacity v0.0.01pa (by Iron Lucien)");
        Text nameText = new Text("Enter profile name:");
        TextField nameEntry = new TextField();
        final ToggleGroup irongroup = new ToggleGroup();
        RadioButton mainscape = new RadioButton("Mainscape");
        mainscape.setToggleGroup(irongroup);
        mainscape.setUserData("Mainscape");
        mainscape.setSelected(true);
        RadioButton ironman = new RadioButton("Ironman");
        ironman.setToggleGroup(irongroup);
        ironman.setUserData("Ironman");
        RadioButton hardcore = new RadioButton("Hardcore");
        hardcore.setToggleGroup(irongroup);
        hardcore.setUserData("Hardcore");
        Button createProfile = new Button();
        createProfile.setText("Create Profile");
        createProfile.setOnAction(event -> {
            Player p = new Player(nameEntry.getText(), irongroup.getSelectedToggle().getUserData().toString());
            root.getChildren().clear();
            displayTasks(p);
            displayPlayer(p);
        });
        Button newProfile = new Button();
        newProfile.setText("New Profile");
        newProfile.setOnAction(event -> {
            root.getChildren().clear();
            root.add(nameText, 0, 0);
            root.add(nameEntry, 1, 0);
            root.add(mainscape, 0, 1);
            root.add(ironman, 0, 2);
            root.add(hardcore, 0, 3);
            root.add(createProfile, 1, 4);
        });
        Button loadProfile = new Button();
        loadProfile.setText("Load Profile");
        loadProfile.setOnAction(event -> System.out.println("Load Profile"));
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        root.add(newProfile, 0, 0);
        root.add(loadProfile, 0, 1);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}