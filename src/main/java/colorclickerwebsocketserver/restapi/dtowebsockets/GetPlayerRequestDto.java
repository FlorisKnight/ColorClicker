package colorclickerwebsocketserver.restapi.dtowebsockets;

import colorclickerclient.Logic.restapi.dto.BaseRequestDto;

public class GetPlayerRequestDto extends BaseRequestDto {
    String playerId;

    public GetPlayerRequestDto(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }
}
