package Stubs;

import colorclickerclient.Logic.websockets.IColorClickerEventClientSocket;

import javax.websocket.CloseReason;

public class ColorClickerEventClientSocketStub implements IColorClickerEventClientSocket {
    String message;

    public String getMessage() {

        return message;
    }

    @Override
    public void start() {

    }

    @Override
    public void onWebSocketConnect() {

    }

    @Override
    public void onWebSocketText(String message) {

    }

    @Override
    public void onWebSocketClose(CloseReason reason) {

    }

    @Override
    public void onWebSocketError(Throwable cause) {

    }

    @Override
    public void sendMessageToServer(String message) {
        this.message = message;
    }

    @Override
    public void stop() {

    }
}
