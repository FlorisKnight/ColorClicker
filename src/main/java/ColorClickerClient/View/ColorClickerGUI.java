package ColorClickerClient.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorClickerGUI extends Application implements IColorClickerClientGUI{
    Stage window;
    sceneController controller;

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        controller = new sceneController(this);

        primaryStage.setTitle("Color Clicker");
        controller.game();
        primaryStage.show();
    }

    public void Draw(Scene scene){
        window.setScene(scene);
    }

}