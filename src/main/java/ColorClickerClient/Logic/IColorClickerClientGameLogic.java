package ColorClickerClient.Logic;

import WebsocketModels.CreateGameReceive;
import WebsocketModels.JoinGameReceive;
import WebsocketModels.UpdatePlayerScore;
import WebsocketModels.UpdateSquare;

public interface IColorClickerClientGameLogic {

    void CreateGameReceive(CreateGameReceive object);

    void JoinGameReceived(JoinGameReceive object);

    void EndGame(String playerName);

    void SquareClick(int xPos, int yPos);

    void UpdateSquares(UpdateSquare object);

    void UpdatePlayerScore(UpdatePlayerScore object);

    void UpdatePlayerName(String playerName);

    void UpdateTime(int time);
}
