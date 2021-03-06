package colorclickerclient.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import models.Score;

import java.util.List;

public class sceneHighscores {
    //Properties
    List<Score> highscores;
    Label lblPoints;
    Label lblName;
    Label lblGameType;

    //Labels
    Label lblHighscoresTxt;

    //Buttons
    Button btnBack;

    //Scene
    Scene scene;

    //Controller
    sceneController controller;

    public sceneHighscores(sceneController controller, List<Score> highscores) {
        this.controller = controller;
        this.highscores = highscores;
        scene = makeScene();
    }

    public Scene makeScene() {
//Define grid pane
        GridPane gridLeaderboard = new GridPane();
        gridLeaderboard.setVgap(10);
        gridLeaderboard.setHgap(20);

        //Define scroll pane
        javafx.scene.control.ScrollPane scrollPane = new javafx.scene.control.ScrollPane(gridLeaderboard);
        scrollPane.setMaxWidth(500);
        scrollPane.setMinWidth(500);
        scrollPane.setMaxHeight(400);

        //Define vbox pane
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        //Overall Pane
        BorderPane layoutPane = new BorderPane();
        layoutPane.setCenter(scrollPane);
        layoutPane.setRight(vbox);

        // Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);

        root.getChildren().add(layoutPane);


        // Leaderboard
        lblPoints = new Label("Score");
        gridLeaderboard.add(lblPoints, 1, 0);

        lblName = new Label("Name");
        gridLeaderboard.add(lblName, 2, 0);

        lblGameType = new Label("Gametype");
        gridLeaderboard.add(lblGameType, 3, 0);

        int i = 1;
        for (Score s : highscores) {
            gridLeaderboard.add(new Label(String.valueOf(s.getPoints())), 1, i);
            gridLeaderboard.add(new Label(s.getName()), 2, i);
            gridLeaderboard.add(new Label(s.getGameType()), 3, i);
            i++;
        }

        // Button to go back to sceneHomeScreen
        Tooltip tooltipCollection =
                new Tooltip("Press to go back");
        btnBack = new Button("Back");
        btnBack.setTooltip(tooltipCollection);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Back();
            }
        });

        vbox.getChildren().addAll(btnBack);

        // Define title and assign the scene for main window
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void Back() {
        controller.homeScene();
    }
}
