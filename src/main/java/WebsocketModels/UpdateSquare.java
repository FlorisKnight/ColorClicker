package WebsocketModels;

import javafx.scene.paint.Color;

public class UpdateSquare {
    private int xPos;
    private int yPos;
    private Color color;

    public UpdateSquare(int xPos, int yPos, Color color) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public Color getColor() {
        return color;
    }
}
