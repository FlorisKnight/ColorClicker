package ColorClickerRESTServer;

import Models.RSResponse;
import com.google.gson.Gson;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/ColorClicker")
public class ColorCLickerRESTResponse {
    ColorClickerRESTMessageHandler messageHandler = new ColorClickerRESTMessageHandler();

    @GET
    @Path("/{value}")
    public Response getMsg(@PathParam("value") String msg) {
        RSResponse response = new RSResponse();
        response.setOperation("ColorClicker");
        response.setExpression(msg);
        try {
            response.setResult(messageHandler.MessageReader(msg));
        } catch (NotImplementedException nfe) {
            response.setResult("Unknown message value.");
        }
        Gson gson = new Gson();
        String output = gson.toJson(response);
        return Response.status(200).entity(output).build();
    }

}

