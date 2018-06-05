package ColorClickerWebsocketServer.REST;

import ColorClickerWebsocketServer.IColorClickerWebsocketMessageReader;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ColorClickerWebsocketRESTLogic implements IColorClickerWebsocketRESTLogic{
    IColorClickerWebsocketMessageReader messageReader;
    class Response {

        private String operation = "n/a";
        private String expression = "n/a";
        private String result = "n/a";

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }

        public String getExpression() {
            return expression;
        }

        public void setExpression(String expression) {
            this.expression = expression;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }

    public ColorClickerWebsocketRESTLogic(IColorClickerWebsocketMessageReader messageReader){
        this.messageReader = messageReader;
    }

    public String getPlayerName(int playerID){
        String result = null;

        final String query = "http://localhost:8091/ColorClicker/" + playerID;

        System.out.println("[Query] : " + query);

        // Perform the query
        HttpGet httpGet = new HttpGet(query);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpGet);) {
            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            Gson gson = new Gson();
            ColorClickerWebsocketRESTLogic.Response jsonResponse = gson.fromJson(entityString,ColorClickerWebsocketRESTLogic.Response.class);
            String stringResult = jsonResponse.getResult();
            System.out.println("[Result] : " + stringResult );
            result = stringResult;
        } catch (IOException e) {
            // Evil, pure evil this solution: ....
            System.out.println("IOException : " + e.toString());
        }

        return result;

    }
}