import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {

	public Square(int x1, int y1, int width, int height, Color color) {
		super(x1, y1, width, height, color);
		// TODO Auto-generated constructor stub
	}

	
	public void draw(Graphics page) {
		page.drawRect(x, y, width, height);
		page.fillRect(x, y, width, height);
	}

}
