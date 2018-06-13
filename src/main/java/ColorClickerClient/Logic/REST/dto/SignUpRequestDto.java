package ColorClickerClient.Logic.REST.dto;

public class SignUpRequestDto extends BaseRequestDto {
    private String facebookId;
    private String name;

    public SignUpRequestDto(String facebookId, String name) {
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
