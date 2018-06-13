package ColorClickerWebsocketServer;

import javafx.application.Application;
import javafx.stage.Stage;

public class ColorClickerWebsocketStart extends Application{
    ColorClickerEventServer eventServer;
    ColorClickerWebsocketLogic logic;
    ColorClickerEventServerSocket socket;
    ColorClickerWebsocketMessageReader messageReader;
    int port;

    @Override
    public void start(Stage primaryStage) throws Exception {
        eventServer = new ColorClickerEventServer();
        logic = new ColorClickerWebsocketLogic();
        messageReader = new ColorClickerWebsocketMessageReader(logic);
        socket = new ColorClickerEventServerSocket(logic, messageReader);

        port = 8096;

        eventServer.startWebSocketServer(socket, port);
    }
}
