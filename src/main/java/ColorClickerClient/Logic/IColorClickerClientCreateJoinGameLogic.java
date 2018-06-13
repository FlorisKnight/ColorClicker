package ColorClickerClient.Logic;


import WebsocketModels.CreateGame;
import WebsocketModels.CreateGameReceive;
import WebsocketModels.JoinGameReceive;

public interface IColorClickerClientCreateJoinGameLogic {
    void CreateGameSend(String gametype);

    void JoinGameSend(String gameID);
}
