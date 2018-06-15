package ColorClickerClient.Logic.Websockets;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

@ClientEndpoint
public class ColorClickerEventClientSocket implements IColorClickerEventClientSocket{
	IColorClickerMessageProcessor messageProcessor;
	private Session session;
	private static final String uri = "ws://localhost:8096/ColorClicker/";

	public ColorClickerEventClientSocket(IColorClickerMessageProcessor messageProcessor){
		this.messageProcessor = messageProcessor;
		start();
	}

	@Override
	public void start() {
		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			// Attempt Connect
			session = container.connectToServer(this, new URI(uri));
		} catch (Throwable t) {
			t.printStackTrace(System.err);
		}
	}

	@Override
	public void stop() {
		try {
			if(session != null)
				session.close();

		} catch (Exception ex){
			System.out.println(ex);
		}
	}

    @OnOpen
	public void onWebSocketConnect() {
		System.out.println("[Connected]");
	}
	@OnMessage
	public void onWebSocketText(String message) {
		System.out.println("[Received]: " + message);
		messageProcessor.processMessage(message);
	}
	@OnClose
	public void onWebSocketClose(CloseReason reason) {
		System.out.println("[Closed]: " + reason);
	}
	@OnError
	public void onWebSocketError(Throwable cause) {
		System.out.println("[ERROR]: " + cause.getMessage());
	}

	@Override
	public void sendMessageToServer(String message)
	{
		try {
			session.getBasicRemote().sendText(message);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}
}
