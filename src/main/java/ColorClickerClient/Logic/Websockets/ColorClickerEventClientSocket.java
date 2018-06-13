package ColorClickerClient.Logic.Websockets;

import ColorClickerClient.View.sceneGame;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;


public class ColorClickerEventClientSocket implements IColorClickerEventClientSocket{
	IColorClickerClientWebsocketMessageReader handler;
	private javax.websocket.Session session;
	sceneGame game;

	public ColorClickerEventClientSocket(IColorClickerClientWebsocketMessageReader handler){
		this.handler = handler;
		setupSocket();
	}

	private void setupSocket() {
		URI uri = URI.create("ws://localhost:8096/wstest/");
		try {
			javax.websocket.WebSocketContainer container = javax.websocket.ContainerProvider.getWebSocketContainer();
			try {
				// Attempt Connect
				session = container.connectToServer(this, uri);
			} finally {
				// Force lifecycle stop when done with container.
				// This is to free up threads and resources that the
				// JSR-356 container allocates. But unfortunately
				// the JSR-356 spec does not handle lifecycles (yet)
				if (container instanceof org.eclipse.jetty.util.component.LifeCycle) {
				 ((org.eclipse.jetty.util.component.LifeCycle) container).stop();
				 }
			}
		} catch (Throwable t) {
			t.printStackTrace(System.err);
		}

	}

    @OnOpen
	public void onWebSocketConnect() {
		System.out.println("[Connected]");
	}
	@OnMessage
	public void onWebSocketText(String message) {
		System.out.println("[Received]: " + message);
		handler.MessageReader(message);
	}
	@OnClose
	public void onWebSocketClose(CloseReason reason) {
		System.out.println("[Closed]: " + reason);
	}
	@OnError
	public void onWebSocketError(Throwable cause) {
		System.out.println("[ERROR]: " + cause.getMessage());
	}

	public void sendMessageToServer(String message)
	{
		try {
			session.getBasicRemote().sendText(message);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}
}
