package colorclickerclient.Logic.restapi.dto;

public class SignInRequestDto extends BaseRequestDto {
    String playerId;

    public SignInRequestDto(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }
}
