package ColorClickerClient.View;

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

public class sceneHighscores {
    //Properties
    String[][] highscores;
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
    public sceneHighscores(sceneController controller, String[][] highscores){
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
        gridLeaderboard.add(lblPoints, 1,1);

        lblName = new Label("Name");
        gridLeaderboard.add(lblName, 2,1);

        lblGameType = new Label("Gametype");
        gridLeaderboard.add(lblGameType, 2,1);

        for (int i = 0; i < highscores.length; ++i) {
            for (int j = 0; j < highscores[i].length; ++j) {
                switch (j){
                case(0): gridLeaderboard.add(new Label(highscores[i][j]), 1,i+2); break;
                case(1): gridLeaderboard.add(new Label(highscores[i][j]), 2,i+2); break;
                case(2): gridLeaderboard.add(new Label(highscores[i][j]), 3,i+2); break;
                }
            }
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
