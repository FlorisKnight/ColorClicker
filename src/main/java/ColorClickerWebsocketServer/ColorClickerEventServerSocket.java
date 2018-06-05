package ColorClickerWebsocketServer;

import ColorClickerClient.Logic.Websockets.ColorClickerClientMessageReader;
import ColorClickerClient.Logic.Websockets.ColorClickerEventClientSocket;

import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;

@ServerEndpoint(value = "/wstest/")
public class ColorClickerEventServerSocket {
	private IColorClickerWebsocketMessageReader messageReader;

	public ColorClickerEventServerSocket(IColorClickerWebsocketLogic logic , IColorClickerWebsocketMessageReader messageReader){
		this.messageReader = messageReader;
	}

	static HashSet<Session> sessions = new HashSet<>();
	@javax.websocket.OnOpen
	public void onConnect(javax.websocket.Session session) {
		sessions.add(session);
		System.out.println("[Connected] SessionID:"+session.getId());
	}

	@javax.websocket.OnMessage
	public void onText(String message, javax.websocket.Session session) {
		System.out.println("[Session ID] : " + session.getId() + " [Received] : " + message);
		messageReader.MessageReader(message, session.getId());
	}

	@javax.websocket.OnClose
	public void onClose(javax.websocket.CloseReason reason, javax.websocket.Session session) {
		System.out.println("[Session ID] : " + session.getId() + "[Socket Closed: " + reason);
		sessions.remove(session);
	}

	@javax.websocket.OnError
	public void onError(Throwable cause, javax.websocket.Session session) {
		System.out.println("[Session ID] : " + session.getId() + "[ERROR]: ");
		cause.printStackTrace(System.err);
	}

	public void sendMessage(String message, String sessionID){
		for(javax.websocket.Session session : sessions) {
			if (session.getId() == sessionID) {
				try {
					session.getBasicRemote().sendText(message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}