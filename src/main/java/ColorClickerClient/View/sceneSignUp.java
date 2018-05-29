package ColorClickerClient.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class sceneSignUp {
    //Labels
    Label lblUsername;
    Label lblEmail;
    Label lblPassword;

    //Textfields
    TextField txtUsername;
    TextField txtEmail;
    PasswordField txtPassword;

    //Buttons
    Button btnSignUp;
    Button btnBack;

    //Scene
    Scene scene;

    //Controller
    sceneController controller;

    public sceneSignUp(sceneController controller){
        this.controller = controller;
    }

    public Scene makeScene(){
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
        btnSignUp = new Button("Sign In");
        Tooltip tooltipStartGame =
                new Tooltip("Press to sign in");
        btnSignUp.setTooltip(tooltipStartGame);
        btnSignUp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                SignUp();
            }
        });

        // Button toSignUp
        btnBack = new Button("Sign Up");
        Tooltip tooltipCollection =
                new Tooltip("Press to sign up");
        btnBack.setTooltip(tooltipCollection);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Back();
            }
        });

        hbox.getChildren().addAll(btnSignUp,btnBack);

        //VBox items
        lblUsername = new Label("Username:");
        txtUsername = new TextField();
        lblEmail = new Label("E-mail:");
        txtEmail = new TextField();
        lblPassword = new Label("Password");
        txtPassword = new PasswordField();

        vbox.getChildren().addAll(lblUsername,txtUsername,lblEmail,txtEmail,lblPassword,txtPassword,hbox);

        return scene;
    }

    public void Back(){
        controller.signInScene();
    }

    public void SignUp(){
        controller.signUp(txtUsername.getText(), txtEmail.getText(), txtPassword.getText());
    }
}
