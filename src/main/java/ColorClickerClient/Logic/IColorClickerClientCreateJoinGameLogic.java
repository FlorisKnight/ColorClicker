package ColorClickerClient.Logic;


import WebsocketModels.CreateGame;
import WebsocketModels.CreateGameReceive;
import WebsocketModels.JoinGameReceive;

public interface IColorClickerClientCreateJoinGameLogic {
    public void CreateGameSend(String gametype);

    public void CreateGameReceive(CreateGameReceive object);

    public void JoinGameSend(String gameID);

    public void JoinGameReceived(JoinGameReceive object);
}
