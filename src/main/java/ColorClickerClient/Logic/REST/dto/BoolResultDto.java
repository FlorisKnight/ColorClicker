package ColorClickerClient.Logic.REST.dto;

public class BoolResultDto extends BaseResultDto {
    boolean check;

    public BoolResultDto(boolean check){
        this.check = check;
    }

    public boolean getCheck(){
        return check;
    }
}
