import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	public Circle(int x1, int y1, int width, int height, Color color) {
		super(x1, y1, width, height, color);
		
	}

	
	public void draw(Graphics page) {
		page.setColor(color);
		page.drawOval(x, y, width, height);
		page.fillOval(x, y, width, height);
	}
	
	

}
