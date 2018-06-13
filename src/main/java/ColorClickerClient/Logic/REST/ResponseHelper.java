package ColorClickerClient.Logic.REST;

import ColorClickerClient.Logic.REST.dto.BaseResultDto;
import ColorClickerClient.Logic.REST.dto.BoolResultDto;
import com.google.gson.Gson;

public class ResponseHelper {
    private ResponseHelper(){}

    private static final Gson gson = new Gson();

    public static String getErrorResponseString()
    {
        BaseResultDto response = new BaseResultDto();
        response.setSuccess(false);
        return gson.toJson(response);
    }

    public static String getBooleanResultDtoResponseString(boolean check)
    {
        BoolResultDto response = new BoolResultDto(check);
        response.setSuccess(true);
        return gson.toJson(response);
    }
}
