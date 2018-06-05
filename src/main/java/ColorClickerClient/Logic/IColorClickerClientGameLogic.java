package ColorClickerClient.Logic;

import WebsocketModels.UpdatePlayerScore;
import WebsocketModels.UpdateSquare;

public interface IColorClickerClientGameLogic {
    public void EndGame(String playerName);

    public void SquareClick(int xPos, int yPos);

    public void UpdateSquares(UpdateSquare object);

    public void UpdatePlayerScore(UpdatePlayerScore object);

    public void UpdatePlayerName(String playerName);

    public void UpdateTime(int time);
}
