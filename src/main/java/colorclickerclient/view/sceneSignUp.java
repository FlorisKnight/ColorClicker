package colorclickerclient.view;

import colorclickerclient.Logic.IColorClickerClientSignInSignUpLogic;
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

public class sceneSignUp {
    //Labels
    Label lblUsername;

    //Textfields
    TextField txtUsername;

    //Buttons
    Button btnSignUp;
    Button btnBack;

    //Scene
    Scene scene;

    //Controller
    sceneController controller;

    //Logic
    IColorClickerClientSignInSignUpLogic logic;

    public sceneSignUp(sceneController controller, IColorClickerClientSignInSignUpLogic logic) {
        this.controller = controller;
        scene = makeScene();
        this.logic = logic;
    }

    public Scene makeScene() {
        //Define vbox pane
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        //Define hbox pane
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(10);

        // Create the scene
        Group root = new Group();
        root.getChildren().add(vbox);
        Scene scene = new Scene(root, 800, 600);

        //Hbox buttons
        // Button to SignIn
        btnSignUp = new Button("Sign Up");
        Tooltip tooltipStartGame =
                new Tooltip("Press to sign up");
        btnSignUp.setTooltip(tooltipStartGame);
        btnSignUp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                SignUp();
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

        hbox.getChildren().addAll(btnSignUp, btnBack);

        //VBox items
        lblUsername = new Label("Username:");
        txtUsername = new TextField();

        vbox.getChildren().addAll(lblUsername, txtUsername, hbox);

        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void Back() {
        controller.signInScene();
    }

    public void SignUp() {
        logic.SignUp(txtUsername.getText());
    }
}
