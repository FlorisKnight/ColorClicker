package colorclickerclient.Logic.websockets.messagemodels;

public class SquareClick {
    private int xPos;
    private int yPos;

    public SquareClick(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}
