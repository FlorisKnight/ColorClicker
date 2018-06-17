package colorclickerclient.view;

import colorclickerclient.Logic.IColorClickerClientCreateJoinGameLogic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class sceneCreateGame {
    //Labels
    Label lblGameType;
    //Radio Buttons
    final ToggleGroup tgGametype = new ToggleGroup();

    RadioButton rbNormal;
    RadioButton rbFast;

    //Buttons
    Button btnCreateGame;
    Button btnBack;

    //Scene
    Scene scene;

    //Controller
    sceneController controller;

    //Logic
    IColorClickerClientCreateJoinGameLogic logic;

    public sceneCreateGame(sceneController controller, IColorClickerClientCreateJoinGameLogic logic) {
        this.controller = controller;
        this.logic = logic;
        scene = makeScene();
    }

    public Scene makeScene() {

        //Define hbox pane
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(10);

        //Define vbox pane
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        // Create the scene
        Group root = new Group();
        root.getChildren().add(vbox);
        Scene scene = new Scene(root, 800, 600);

        // Button to Create game
        btnCreateGame = new Button("Create game");
        Tooltip tooltipStartGame =
                new Tooltip("Press to create game");
        btnCreateGame.setTooltip(tooltipStartGame);
        btnCreateGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                CreateGame();
            }
        });

        // Button toSignUp
        btnBack = new Button("Back");
        Tooltip tooltipCollection =
                new Tooltip("Press to go back");
        btnBack.setTooltip(tooltipCollection);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Back();
            }
        });

        hbox.getChildren().addAll(btnCreateGame, btnBack);

        rbNormal = new RadioButton("Normal");
        rbFast = new RadioButton("Fast");

        rbNormal.setToggleGroup(tgGametype);
        rbFast.setToggleGroup(tgGametype);

        rbNormal.setSelected(true);

        vbox.getChildren().addAll(rbNormal, rbFast, hbox);


        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void CreateGame() {
        if (rbNormal.isSelected())
            logic.CreateGameSend("Normal");
        else if (rbFast.isSelected())
            logic.CreateGameSend("Fast");
    }

    public void Back() {
        controller.homeScene();
    }

}
