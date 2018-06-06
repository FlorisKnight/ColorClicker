package ColorClickerRESTServer.OAuth;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;
import javafx.application.Application;
import javafx.stage.Stage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook{
    public int authUser(){
        String appId = "220796958728795";
        String domain = "http://localhost/";

        String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id="+appId+"&redirect_uri="+domain+"";
        System.setProperty("webdriver.chrome.drivers", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get(authUrl);

        String accessToken;
        //Check if user is on facaebook
        while(true){
            if(!driver.getCurrentUrl().contains("facebook.com")){
                String url = driver.getCurrentUrl();
                accessToken = url.replaceAll(".*#access_token=(.*)&.*", "$1");
                accessToken = accessToken.substring(0, accessToken.length() - 16);
                driver.quit();

                FacebookClient fbClient = new DefaultFacebookClient(accessToken);
                User user = fbClient.fetchObject("me",User.class);

                return Integer.valueOf(user.getId());

            }
        }
    }
}
