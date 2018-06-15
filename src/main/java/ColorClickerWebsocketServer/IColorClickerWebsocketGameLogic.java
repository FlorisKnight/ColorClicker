package ColorClickerWebsocketServer;

import Models.Player;

public interface IColorClickerWebsocketGameLogic {

    void StartGame();

    void SquareClick(String sessionID, int xpos, int ypos);

    void AddPlayer(Player player2);

    boolean checkSessionID(String sessionID);

    int getGameId();

    String getPlayer1Name();

    String getPlayer2Name();

    String getPlayer1SessionID();

    void placeRandomSquare();

    boolean checkAvailability();
}
