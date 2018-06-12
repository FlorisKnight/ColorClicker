package Models;

public class Color {

	javafx.scene.paint.Color color;
	int point;

	public Color(int point, javafx.scene.paint.Color color) {
		this.point = point;
		this.color = color;
	}

	public int getPoint() {
		return point;
	}

	public javafx.scene.paint.Color getColor() {
		return color;
	}
}