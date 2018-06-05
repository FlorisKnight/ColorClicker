package Models;

public class Color {

	private char color;
	private int point;

	public Color(int point, char color) {
		this.point = point;
		this.color = color;
	}

	public int getPoint() {
		return point;
	}

	public char getColor() {
		return color;
	}
}