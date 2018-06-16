package colorclickerclient.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorClickerGUI extends Application implements IColorClickerClientGUI {
    Stage window;
    sceneController controller;

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        controller = new sceneController(this);

        primaryStage.setTitle("Color Clicker");
        controller.signInScene();
        primaryStage.show();
    }

    public void Draw(Scene scene) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                window.setScene(scene);
            }
        });
    }

}