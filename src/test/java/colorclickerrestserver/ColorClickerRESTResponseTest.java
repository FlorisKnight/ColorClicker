package colorclickerrestserver;

import Stubs.ColorClickerRESTdbStub;
import colorclickerclient.Logic.restapi.ResponseHelper;
import com.google.gson.Gson;
import models.Score;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import javax.ws.rs.core.Response;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ColorClickerRESTResponseTest {
    IColorClickerRestDB database = new ColorClickerRESTdbStub();
    IColorClickerRESTLogic logic = new ColorClickerRESTLogic(database);
    IColorClickerRESTResponse restResponse = new ColorClickerRESTResponse();
    Response responseBoolTrue = Response.status(200).entity(ResponseHelper.getBooleanResultDtoResponseString(true)).build();
    Gson gson = new Gson();

    @Before
    public void setRestLogic() {
        ColorClickerRESTResponse.setRestLogic(logic);
    }

    @Test
    public void signIn() {
        Response r = restResponse.SignIn("{\"playerId\":\"69420\"}");
        String actual = gson.toJson(r, Response.class);
        String expected = gson.toJson(responseBoolTrue, Response.class);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void signUp() {
        Response r = restResponse.SignUp("{\"facebookId\":\"69420\",\"name\":\"Frank\"}");
        String actual = gson.toJson(r, Response.class);
        String expected = gson.toJson(responseBoolTrue, Response.class);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPlayer() {
        Response r = restResponse.GetPlayer("{\"playerId\":\"69420\"}");
        String actual = gson.toJson(r, Response.class);
        Response expectedResponse = Response.status(200).entity(ResponseHelper.getGetPlayerResultDtcString("Frank")).build();
        String expected = gson.toJson(expectedResponse, Response.class);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setHighscore() {
        Response r = restResponse.setHighscore("{\"name\":\"Frank\",\"score\":51,\"gameType\":\"Fast\"}");
        String actual = gson.toJson(r, Response.class);
        String expected = gson.toJson(responseBoolTrue, Response.class);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHighscore() {
        Response r = restResponse.getHighscore();
        String actual = gson.toJson(r, Response.class);
        Response expectedResponse = Response.status(200).entity(ResponseHelper.getHighscoresResultDtcString(new ArrayList<Score>())).build();
        String expected = gson.toJson(expectedResponse, Response.class);
        Assert.assertEquals(expected, actual);
    }
}