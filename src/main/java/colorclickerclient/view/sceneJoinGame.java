package colorclickerclient.view;

import colorclickerclient.Logic.IColorClickerClientCreateJoinGameLogic;
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

public class sceneJoinGame {
    //Labels
    Label lblGameCode;

    //Textfields
    TextField txtGameCode;

    //Button
    Button btnJoinGame;
    Button btnBack;

    //Scene
    Scene scene;

    //Controller
    sceneController controller;

    //Logic
    IColorClickerClientCreateJoinGameLogic logic;

    public sceneJoinGame(sceneController controller, IColorClickerClientCreateJoinGameLogic logic) {
        this.controller = controller;
        this.logic = logic;
        scene = makeScene();
    }

    public Scene makeScene() {
        //Define hbox pane
        HBox hbox = new HBox();
        hbox.setPadding(new javafx.geometry.Insets(10));
        hbox.setSpacing(10);

        //Define vbox pane
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        // Create the scene
        Group root = new Group();
        root.getChildren().add(vbox);
        Scene scene = new Scene(root, 800, 600);

        //Hbox buttons
        // Button to Join game
        btnJoinGame = new Button("Join game");
        Tooltip tooltipStartGame =
                new Tooltip("Press to join game");
        btnJoinGame.setTooltip(tooltipStartGame);
        btnJoinGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                JoinGame();
            }
        });

        // Button to go back
        btnBack = new Button("Back");
        Tooltip tooltipCollection =
                new Tooltip("Press to go back");
        btnBack.setTooltip(tooltipCollection);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Back();
            }
        });

        hbox.getChildren().addAll(btnJoinGame, btnBack);

        //VBox
        lblGameCode = new Label("Gamecode:");
        txtGameCode = new TextField();

        vbox.getChildren().addAll(lblGameCode, txtGameCode, hbox);
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void JoinGame() {
        logic.JoinGameSend(txtGameCode.getText());
    }

    public void Back() {
        controller.homeScene();
    }
}
