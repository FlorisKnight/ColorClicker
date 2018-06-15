package ColorClickerWebsocketServer;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;

@ServerEndpoint(value = "/ColorClicker/")
public class ColorClickerEventServerSocket {
	IColorClickerWebsocketServerMessageProcessor messageProcessor;
	IColorClickerWebsocketLogic logic;

	public ColorClickerEventServerSocket(IColorClickerWebsocketLogic logic , IColorClickerWebsocketServerMessageProcessor messageProcessor){
		this.logic = logic;
		this.messageProcessor = messageProcessor;
	}

	static HashSet<Session> sessions = new HashSet<>();
	@OnOpen
	public void onConnect(javax.websocket.Session session) {
		sessions.add(session);
		System.out.println("[Connected] SessionID:"+session.getId());
	}

	@OnMessage
	public void onText(String message, javax.websocket.Session session) {
		System.out.println("[Session ID] : " + session.getId() + " [Received] : " + message);
		messageProcessor.processMessage(message, session.getId());
	}

	@OnClose
	public void onClose(javax.websocket.CloseReason reason, javax.websocket.Session session) {
		System.out.println("[Session ID] : " + session.getId() + "[Socket Closed: " + reason);
		try {
			logic.RemoveGame(logic.getGame(session.getId()));
		} catch (Exception e){
			System.out.println(e);
		}
		sessions.remove(session);
	}

	@OnError
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