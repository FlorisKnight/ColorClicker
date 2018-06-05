package ColorClickerClient.View;

import ColorClickerClient.Logic.IColorClickerClientSignInSignUpLogic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sun.management.jdp.JdpPacketWriter;

public class sceneSignIn {
    IColorClickerClientGUI GUI;

    //Labels
    Label lblEmail;
    Label lblPassword;

    //Textfields
    TextField txtEmail;
    PasswordField txtPassword;

    //Buttons
    Button btnSignIn;
    Button btnSignUp;

    //Scene
    Scene scene;

    //Controller
    sceneController controller;

    //Logic
    IColorClickerClientSignInSignUpLogic logic;

    public sceneSignIn(sceneController controller, IColorClickerClientSignInSignUpLogic logic){
        this.controller = controller;
        this.logic = logic;
        scene = makeScene();
    }

    private Scene makeScene(){
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



        // Button to SignIn
        btnSignIn = new Button("Sign In");
        Tooltip tooltipStartGame =
                new Tooltip("Press to sign in");
        btnSignIn.setTooltip(tooltipStartGame);
        btnSignIn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                signIn();
            }
        });

        // Button toSignUp
        btnSignUp = new Button("Sign Up");
        Tooltip tooltipCollection =
                new Tooltip("Press to sign up");
        btnSignUp.setTooltip(tooltipCollection);
        btnSignUp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                signUp();
            }
        });

        hbox.getChildren().addAll(btnSignIn,btnSignUp);

        // Labels
        lblEmail = new Label("Email address:");
        lblPassword = new Label("Password:");

        //Textfields
        txtEmail = new TextField();
        txtPassword = new PasswordField();

        vbox.getChildren().addAll(lblEmail,txtEmail,lblPassword,txtPassword,hbox);

        return scene;
    }

    public Scene getScene(){
        return scene;
    }

    public void signIn(){
        logic.SignIn(txtEmail.getText(),txtPassword.getText());
    }

    public void signUp(){
        controller.signUpScene();
    }
}
