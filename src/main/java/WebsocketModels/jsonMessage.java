package WebsocketModels;

public class jsonMessage {

    public String message;
    public Object object;

    public jsonMessage(String message, Object object) {
        this.message = message;
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public Object getObject() {
        return object;
    }


}
