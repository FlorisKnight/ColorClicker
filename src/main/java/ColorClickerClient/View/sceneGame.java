package ColorClickerClient.View;

import Models.Color;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;


public class sceneGame {
    //Properties
    String gameCodeText = "Gamecode:";
    String gameCode = "afaFSD876VKJVhkb";
    String player1Name = "dafdsf";
    String player2Name = "asdfasdf";
    String player1Points = "4";
    String player2Points = "24";
    String timeLeftTxt = "Time left:";
    String timeLeft = "45";

    GridPane grid;

    //Labels
    Label lblGameTxt;
    Label lblGameCode;
    Label lblPlayer1;
    Label lblPlayer1Points;
    Label lblPlayer2;
    Label lblPlayer2Points;
    Label lblTimeLeftTxt;
    Label lblTimeLeft;

    //Controller
    sceneController controller;

    //Scene
    Scene scene;

    //TODO generate 8x8
    public sceneGame(sceneController controller){
    this.controller = controller;
    scene = makeScene();
    }

    public Scene makeScene(){
        //Define grid
        grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        //Define HBoxes
        //Gamecodes
        HBox gameCodeHbox = new HBox();
        gameCodeHbox.setPadding(new Insets(10));
        gameCodeHbox.setSpacing(10);
        //Player1
        HBox player1Hbox = new HBox();
        player1Hbox.setPadding(new Insets(10));
        player1Hbox.setSpacing(10);//Gamecodes
        //Player2
        HBox player2Hbox = new HBox();
        player2Hbox.setPadding(new Insets(10));
        player2Hbox.setSpacing(10);//Gamecodes
        //Time
        HBox timeHbox = new HBox();
        timeHbox.setPadding(new Insets(10));
        timeHbox.setSpacing(10);

        //Define vbox pane
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        //Overall Pane
        BorderPane layoutPane = new BorderPane();
        layoutPane.setTop(gameCodeHbox);
        layoutPane.setCenter(grid);
        layoutPane.setRight(vbox);

        //Make playing grid 8x8
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Rectangle rec = new Rectangle();
                rec.setWidth(60);
                rec.setHeight(60);
                rec.setFill(javafx.scene.paint.Color.RED);
                GridPane.setRowIndex(rec, row);
                GridPane.setColumnIndex(rec, col);
                grid.getChildren().addAll(rec);
            }
        }

        //Labels
        lblGameTxt = new Label(gameCodeText);
        lblGameCode = new Label(gameCode);
        gameCodeHbox.getChildren().addAll(lblGameTxt,lblGameCode);

        lblPlayer1 = new Label(player1Name);
        lblPlayer1Points = new Label(player1Points);
        player1Hbox.getChildren().addAll(lblPlayer1,lblPlayer1Points);

        lblPlayer2 = new Label(player2Name);
        lblPlayer2Points = new Label(player2Points);
        player2Hbox.getChildren().addAll(lblPlayer2,lblPlayer2Points);

        lblTimeLeftTxt = new Label(timeLeftTxt);
        lblTimeLeft = new Label(timeLeft);
        timeHbox.getChildren().addAll(lblTimeLeftTxt,lblTimeLeft);

        vbox.getChildren().addAll(player1Hbox,player2Hbox,timeHbox);

        // Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);

        root.getChildren().add(layoutPane);
        return scene;
    }

    public Scene getScene(){
        return scene;
    }

    public void UpdateSquares(javafx.scene.paint.Color squareColor, int xPos, int yPos){

    }

    public void UpdatePlayerScore(int playerNr, int score){
        if (playerNr == 0){
            player1Points = String.valueOf(score);
        } else if (playerNr == 1){
            player2Points = String.valueOf(score);
        }
    }

    public void UpdateTime(int time){
        timeLeft = String.valueOf(time);
    }

    public void showMessage(final String message) {
        // Use Platform.runLater() to ensure that code concerning
        // the Alert message is executed by the JavaFX Application Thread
        Platform.runLater(new Runnable() {
            public void run() {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Color Clicker");
                alert.setHeaderText("Color Clicker");
                alert.setContentText(message);
                alert.showAndWait();
            }
        });
    }
}
