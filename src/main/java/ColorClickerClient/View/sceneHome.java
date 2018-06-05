package ColorClickerClient.View;

import ColorClickerClient.Logic.IColorClickerClientHighscoreLogic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class sceneHome {
    IColorClickerClientGUI GUI;

    //Buttons
    Button btnCreateGame;
    Button btnJoinGame;
    Button btnHighscores;

    //Scene
    Scene scene;

    //Controller
    sceneController controller;

    //Logic
    IColorClickerClientHighscoreLogic logic;

    public sceneHome(sceneController controller, IColorClickerClientHighscoreLogic logic){
        scene = makeScene();
        this.logic = logic;
        this.controller = controller;
    }

    public Scene makeScene(){
        //Define vbox pane
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        // Create the scene
        Group root = new Group();
        root.getChildren().add(vbox);
        Scene scene = new Scene(root, 800, 600);



        // Button to go to create game
        btnCreateGame = new Button("Create game");
        btnCreateGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                createGame();
            }
        });

        // Button to go to join game
        btnJoinGame = new Button("Join game");
        btnJoinGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                joinGame();
            }
        });

        // Button to Highscores
        btnHighscores = new Button("Highscores");
        btnHighscores.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Highscores();
            }
        });

        vbox.getChildren().addAll(btnCreateGame,btnJoinGame,btnHighscores);

        return scene;
    }

    public Scene getScene(){
        return scene;
    }

    public void createGame(){
        controller.createGameScene();
    }

    public void joinGame(){
        controller.joinGameScene();
    }

    public void Highscores(){
        logic.GetHighscores();
    }
}
