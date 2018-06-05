package ColorClickerClient.View;

import ColorClickerClient.Logic.ColorClickerClientLogic;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;


public class sceneGame {
    //Properties
    String gameCodeText = "Gamecode:";
    int gameID;
    String player1Name;
    String player2Name ;
    String player1Points;
    String player2Points;
    String timeLeftTxt = "Time left:";
    String timeLeft ;

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

    //Scene
    Scene scene;

    //Logic
    ColorClickerClientLogic logic;

    public sceneGame(ColorClickerClientLogic logic, int gameID, String player){
        scene = makeScene();
        this.logic = logic;
        this.gameID = gameID;
        UpdateLabel(lblGameCode, String.valueOf(gameID));
        this.player1Name = player;
        UpdateLabel(lblPlayer1, player1Name);
    }

    public sceneGame(ColorClickerClientLogic logic, int gameID, String player1, String player2){
        scene = makeScene();
        this.logic = logic;
        this.gameID = gameID;
        UpdateLabel(lblGameCode, String.valueOf(gameID));
        this.player1Name = player1;
        UpdateLabel(lblPlayer1, player1Name);
        this.player2Name = player2;
        UpdateLabel(lblPlayer2, player2Name);
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
                //rec.setOnMousePressed((EventHandler<javafx.scene.input.MouseEvent>) event -> SquareClick(GridPane.getRowIndex( rec),GridPane.getColumnIndex( rec);
                rec.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_PRESSED, event -> SquareClick(GridPane.getRowIndex( rec),GridPane.getColumnIndex( rec)));
                GridPane.setRowIndex(rec, row);
                GridPane.setColumnIndex(rec, col);
                grid.getChildren().addAll(rec);
            }
        }

        //Labels
        lblGameTxt = new Label(gameCodeText);
        lblGameCode = new Label(String.valueOf(gameID));
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

    private void SquareClick(int rowIndex, int columnIndex) {
        logic.SquareClick(rowIndex, columnIndex);
    }

    public void UpdateSquares(javafx.scene.paint.Color squareColor, int xPos, int yPos){
        Rectangle rec = new Rectangle();
        rec.setWidth(60);
        rec.setHeight(60);
        rec.setFill(squareColor);
        grid.add(rec,xPos,yPos);
    }

    public void UpdatePlayerScore(int playerNr, int score){
        if (playerNr == 0){
            player1Points = String.valueOf(score);
            lblPlayer1Points.setText(player1Points);
        } else if (playerNr == 1){
            player2Points = String.valueOf(score);
            lblPlayer2Points.setText(player2Points);
        }
    }

    public void UpdatePlayerName(String playerName){
        player2Name = playerName;
        UpdateLabel(lblPlayer2, player2Name);
    }

    public void UpdateTime(int time){
        timeLeft = String.valueOf(time);
        UpdateLabel(lblTimeLeft, timeLeft);
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

    private void UpdateLabel(Label lbl, String text){
        lbl.setText(text);
    }
}
