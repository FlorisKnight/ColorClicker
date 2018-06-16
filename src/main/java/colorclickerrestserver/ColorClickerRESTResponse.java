package colorclickerrestserver;

import colorclickerclient.Logic.restapi.ResponseHelper;
import colorclickerclient.Logic.restapi.dto.SignInRequestDto;
import colorclickerclient.Logic.restapi.dto.SignUpRequestDto;
import colorclickerwebsocketserver.restapi.dtowebsockets.GetPlayerRequestDto;
import colorclickerwebsocketserver.restapi.dtowebsockets.SetHighscoresPUTDto;
import com.google.gson.Gson;
import models.Score;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/ColorClicker")
public class ColorClickerRESTResponse implements IColorClickerRESTResponse{
    private static IColorClickerRESTLogic restLogic;

    public static void setRestLogic(IColorClickerRESTLogic restLogic) {
        ColorClickerRESTResponse.restLogic = restLogic;
    }

    @POST
    @Path("/player/SignIn")
    @Consumes("application/json")
    @Produces("application/json")
    public Response SignIn(String data) {
        Gson gson = new Gson();
        SignInRequestDto signInRequest = gson.fromJson(data, SignInRequestDto.class);
        if (signInRequest == null) {
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }

        Boolean signInCheck = restLogic.SignIn(signInRequest.getPlayerId());
        return Response.status(200).entity(ResponseHelper.getBooleanResultDtoResponseString(signInCheck)).build();

    }

    @POST
    @Path("/player/SignUp/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response SignUp(String data) {
        Gson gson = new Gson();
        SignUpRequestDto signUpRequest = gson.fromJson(data, SignUpRequestDto.class);
        if (signUpRequest == null) {
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }
        Boolean signUpCheck = restLogic.SignUp(signUpRequest.getFacebookId(), signUpRequest.getName());

        return Response.status(200).entity(ResponseHelper.getBooleanResultDtoResponseString(signUpCheck)).build();

    }

    @POST
    @Path("/player/getPlayer")
    @Consumes("application/json")
    @Produces("application/json")
    public Response GetPlayer(String data) {
        Gson gson = new Gson();
        GetPlayerRequestDto getPlayerRequest = gson.fromJson(data, GetPlayerRequestDto.class);
        if (getPlayerRequest == null) {
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }

        String player = restLogic.getPlayer(getPlayerRequest.getPlayerId());
        if (player == null) {
            return Response.status(401).entity(ResponseHelper.getErrorResponseString()).build();
        }
        return Response.status(200).entity(ResponseHelper.getGetPlayerResultDtcString(player)).build();

    }

    @POST
    @Path("/Highscores/put")
    @Consumes("application/json")
    public Response setHighscore(String data) {
        Gson gson = new Gson();
        SetHighscoresPUTDto setHighscoresPUTDto = gson.fromJson(data, SetHighscoresPUTDto.class);
        boolean check = restLogic.saveScores(setHighscoresPUTDto.getName(), setHighscoresPUTDto.getScore(), setHighscoresPUTDto.getGameType());
        return Response.status(200).entity(ResponseHelper.getBooleanResultDtoResponseString(check)).build();
    }

    @GET
    @Path("/Highscores/get")
    public Response getHighscore() {
        List<Score> highscores = restLogic.getHighscores();
        if (highscores == null) {
            return Response.status(401).entity(ResponseHelper.getErrorResponseString()).build();
        }
        return Response.status(200).entity(ResponseHelper.getHighscoresResultDtcString(highscores)).build();
    }


}

