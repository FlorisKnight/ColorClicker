package WebsocketModels;

public class SignUp {
    private String facebookId;
    private String name;

    public SignUp(String facebookId, String name) {
        this.facebookId = facebookId;
        this.name = name;
    }

    public String getFacebookId(){
        return facebookId;
    }
    public String getName() {
        return name;
    }
}
