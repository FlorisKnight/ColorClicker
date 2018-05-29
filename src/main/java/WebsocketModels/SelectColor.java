package WebsocketModels;

import Models.Color;

public class SelectColor {
    private Color squareColor;

    public SelectColor(Color squareColor) {
        this.squareColor = squareColor;
    }

    public Color getSquareColor() {
        return squareColor;
    }

}
