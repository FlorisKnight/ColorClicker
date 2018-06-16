package colorclickerrestserver;

import javax.ws.rs.core.Response;

public interface IColorClickerRESTResponse {
    Response SignIn(String data);

    Response SignUp(String data);

    Response GetPlayer(String data);

    Response setHighscore(String data);

    Response getHighscore();
}
