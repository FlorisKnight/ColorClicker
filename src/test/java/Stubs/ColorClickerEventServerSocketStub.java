package Stubs;

import colorclickerwebsocketserver.IColorClickerEventServerSocket;

import javax.websocket.CloseReason;
import javax.websocket.Session;

public class ColorClickerEventServerSocketStub implements IColorClickerEventServerSocket{
    @Override
    public void onConnect(Session session) {

    }

    @Override
    public void onText(String message, Session session) {

    }

    @Override
    public void onClose(CloseReason reason, Session session) {

    }

    @Override
    public void onError(Throwable cause, Session session) {

    }

    @Override
    public void sendMessage(String message, String sessionId) {

    }
}
