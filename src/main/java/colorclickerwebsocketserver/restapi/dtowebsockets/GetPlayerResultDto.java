package colorclickerwebsocketserver.restapi.dtowebsockets;

import colorclickerclient.Logic.restapi.dto.BaseResultDto;

public class GetPlayerResultDto extends BaseResultDto {
    String name;

    public GetPlayerResultDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
