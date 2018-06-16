package colorclickerrestserver;

import Stubs.ColorClickerRESTdbStub;
import colorclickerclient.Logic.restapi.ResponseHelper;
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

    @Before
    public void setRestLogic() {
        ColorClickerRESTResponse.setRestLogic(logic);
    }

    @Test
    public void signIn() {
        Response r = restResponse.SignIn("{\"playerId\":\"1558375417606601\"}");
        Assert.assertEquals(Response.status(200).entity(ResponseHelper.getBooleanResultDtoResponseString(true)).build(),r);
    }

    @Test
    public void signUp() {
        Response r = restResponse.SignUp("{\"facebookId\":\"1558375417606601\",\"name\":\"FlorisKnight\"}");
        Assert.assertEquals(Response.status(200).entity(ResponseHelper.getBooleanResultDtoResponseString(true)).build(), r);
    }

    @Test
    public void getPlayer() {
        Response r = restResponse.GetPlayer("{\"playerId\":\"1558375417606601\"}");
        Assert.assertEquals(Response.status(200).entity(ResponseHelper.getGetPlayerResultDtcString("Frank")).build(), r);
    }

    @Test
    public void setHighscore() {
        Response r = restResponse.setHighscore("{\"name\":\"FlorisKnight\",\"score\":51,\"gameType\":\"Fast\"}");
        Assert.assertEquals(Response.status(200).entity(ResponseHelper.getBooleanResultDtoResponseString(true)).build(), r);
    }

    @Test
    public void getHighscore() {
        Response r = restResponse.getHighscore();
        Assert.assertEquals(Response.status(200).entity(ResponseHelper.getHighscoresResultDtcString(new ArrayList<Score>())).build(), r);
    }
}