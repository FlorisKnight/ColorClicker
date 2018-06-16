package colorclickerclient.Logic;


public interface IColorClickerClientCreateJoinGameLogic {
    void CreateGameSend(String gametype);

    void JoinGameSend(String gameID);
}
