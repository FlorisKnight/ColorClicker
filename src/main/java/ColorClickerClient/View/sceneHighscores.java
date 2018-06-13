package ColorClickerClient.View;

import Models.Score;
import com.sun.deploy.xml.XMLable;
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

import java.util.ArrayList;

public class sceneHighscores {
    //Properties
    ArrayList<Score> highscores;
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
    public sceneHighscores(sceneController controller, ArrayList<Score> highscores){
        this.controller = controller;
        this.highscores = highscores;
        scene = makeScene();
    }

    public Scene makeScene(){
//Define grid pane
        GridPane gridLeaderboard = new GridPane();
        gridLeaderboard.setVgap(10);

        //Define scroll pane
        javafx.scene.control.ScrollPane scrollPane = new javafx.scene.control.ScrollPane(gridLeaderboard);
        scrollPane.setMaxWidth(100);

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
        gridLeaderboard.add(lblPoints, 1,0);

        lblName = new Label("Name");
        gridLeaderboard.add(lblName, 2,0);

        lblGameType = new Label("Gametype");
        gridLeaderboard.add(lblGameType, 2,0);

        int i = 1;
        for (Score s: highscores) {
            gridLeaderboard.add(new Label(String.valueOf(s.getScore())), 1,i);
            gridLeaderboard.add(new Label(s.getName()), 2,i);
            gridLeaderboard.add(new Label(s.getGameType()), 3,i);
        }

        // Button to go back to sceneHomeScreen
        Tooltip tooltipCollection =
                new Tooltip("Press to go back");
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

    public void Back(){
        controller.homeScene();
    }
}
