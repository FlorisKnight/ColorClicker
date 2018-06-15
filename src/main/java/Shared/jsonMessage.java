package Shared;

public class jsonMessage {

    String message;
    String object;

    public jsonMessage(String message, String object) {
        this.message = message;
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public String getObject() {
        return object;
    }


}
