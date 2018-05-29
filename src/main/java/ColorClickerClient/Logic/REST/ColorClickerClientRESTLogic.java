package ColorClickerClient.Logic.REST;

import WebsocketModels.getHighscores;
import WebsocketModels.jsonMessage;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ColorClickerClientRESTLogic {
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

    public int SignIn(String message) {
        int result = 0;

        final String query = "http://localhost:8091/ColorClicker/" + message;

        System.out.println("[Query] : " + query);

        // Perform the query
        HttpGet httpGet = new HttpGet(query);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpGet);) {
            System.out.println("[Status Line] : " + response.getStatusLine());
            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            System.out.println("[Entity] : " + entityString);
            Gson gson = new Gson();
            Response jsonResponse = gson.fromJson(entityString,Response.class);
            String stringResult = jsonResponse.getResult();
            System.out.println("[Result] : " + stringResult );
            result = Integer.parseInt(stringResult);
        } catch (IOException e) {
            // Evil, pure evil this solution: ....
            System.out.println("IOException : " + e.toString());
        }

        return result;
    }

    public String[][] getHighscores(){
        String[][] result = null;

        final String query = "http://localhost:8091/ColorClicker/getHighscores";

        System.out.println("[Query] : " + query);

        // Perform the query
        HttpGet httpGet = new HttpGet(query);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpGet);) {
            System.out.println("[Status Line] : " + response.getStatusLine());
            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            System.out.println("[Entity] : " + entityString);
            Gson gson = new Gson();
            Response jsonResponse = gson.fromJson(entityString,Response.class);
            String stringResult = jsonResponse.getResult();
            System.out.println("[Result] : " + stringResult );
            gson = new Gson();
            jsonMessage messageObject = gson.fromJson(stringResult, jsonMessage.class);
            getHighscores object = (getHighscores)messageObject.getObject();
            result = object.getHighscores();
        } catch (IOException e) {
            // Evil, pure evil this solution: ....
            System.out.println("IOException : " + e.toString());
        }

        return result;
    }
}