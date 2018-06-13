package ColorClickerWebsocketServer.REST.dtoWebsockets;

import ColorClickerClient.Logic.REST.dto.BaseRequestDto;
import ColorClickerClient.Logic.REST.dto.BaseResultDto;

public class GetPlayerResultDto extends BaseResultDto {
    String name;

    public GetPlayerResultDto(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
