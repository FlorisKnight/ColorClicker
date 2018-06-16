package colorclickerclient.Logic;

import javafx.scene.paint.Color;

public interface IColorClickerClientGameLogic {

    void CreateGameReceive(int gameId, String playername);

    void JoinGameReceived(int gameId, String player1Name, String player2Name);

    void EndGame(String playerName);

    void SquareClick(int xPos, int yPos);

    void UpdateSquares(int xPos, int yPos, Color color);

    void UpdatePlayerScore(int player, int score);

    void UpdatePlayerName(String playerName);
}
