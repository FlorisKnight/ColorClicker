package ColorClickerRESTServer;

import ColorClickerClient.Logic.REST.ResponseHelper;
import ColorClickerClient.Logic.REST.dto.*;
import ColorClickerWebsocketServer.REST.dtoWebsockets.GetPlayerRequestDto;
import ColorClickerWebsocketServer.REST.dtoWebsockets.GetPlayerResultDto;
import ColorClickerWebsocketServer.REST.dtoWebsockets.SetHighscoresPUTDto;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/ColorClicker")
public class ColorCLickerRESTResponse {
    ColorClickerRESTLogic restLogicRepository;
    ColorClickerRESTServerDB restServerDB;

    public ColorCLickerRESTResponse(){
        restServerDB = new ColorClickerRESTServerDB();
        restLogicRepository = new ColorClickerRESTLogic(restServerDB);
    }

    @POST
    @Path("/player/SignIn")
    @Consumes("application/json")
    @Produces("application/json")
    public Response SignIn(SignInRequestDto signInRequest)
    {
        if(signInRequest == null)
        {
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }

        Boolean signInCheck = restLogicRepository.SignIn(signInRequest.getPlayerId());
        if(!signInCheck)
        {
            return Response.status(401).entity(ResponseHelper.getErrorResponseString()).build();
        }

        return  Response.status(200).entity(new BoolResultDto(signInCheck)).build();

    }

    @POST
    @Path("/player/SignUp")
    @Consumes("application/json")
    @Produces("application/json")
    public Response SignUp(SignUpRequestDto signUpRequest)
    {
        if(signUpRequest == null)
        {
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }

        Boolean signUpCheck = restLogicRepository.SignUp(signUpRequest.getFacebookId(), signUpRequest.getName());
        if(!signUpCheck)
        {
            return Response.status(401).entity(ResponseHelper.getErrorResponseString()).build();
        }

        return  Response.status(200).entity(new BoolResultDto(signUpCheck)).build();

    }

    @POST
    @Path("/player/getPlayer")
    @Consumes("application/json")
    @Produces("application/json")
    public Response GetPlayer(GetPlayerRequestDto getPlayerRequest)
    {
        if(getPlayerRequest == null)
        {
            return Response.status(400).entity(ResponseHelper.getErrorResponseString()).build();
        }

        String player = restLogicRepository.getPlayer(getPlayerRequest.getPlayerId());
        if(player == null)
        {
            return Response.status(401).entity(ResponseHelper.getErrorResponseString()).build();
        }
        return  Response.status(200).entity(new GetPlayerRequestDto(player)).build();

    }

    @PUT
    @Path("/Highscores/put")
    @Consumes("application/json")
    public void setHighscore(SetHighscoresPUTDto setHighscoresPUTDto)
    {
        restLogicRepository.saveScores(setHighscoresPUTDto.getName(), setHighscoresPUTDto.getScore(), setHighscoresPUTDto.getGameType());
    }

    //TODO get highscore????

    @GET
    @Path("/Highscores/get")
    public Response get(){
        return  Response.status(200).entity(new HighscoresResultDto(restLogicRepository.getHighscores())).build();
    }


}

