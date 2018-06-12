package ColorClickerClient.Logic.REST;

import WebsocketModels.getHighscores;
import WebsocketModels.jsonMessage;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ColorClickerClientRESTLogic{
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

    public String baseMethodPost(Object data, String query) {

        // Perform the query
        HttpPost httpPost = new HttpPost(query);
        Gson gson = new Gson();
        String json = gson.toJson(data);
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntity);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpPost);) {
            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            return entityString;
        } catch (IOException e) {
            System.out.println("IOException : " + e.toString());
        }

        return null;
    }

    public String baseMethodGet(String query) {

        // Perform the query
        HttpGet httpGet = new HttpGet(query);


        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpGet);) {
            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            return entityString;
        } catch (IOException e) {
            System.out.println("IOException : " + e.toString());
        }

        return null;
    }
}