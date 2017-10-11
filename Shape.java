import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Color color;
	
	public Shape (int x1, int y1, int width, int height, Color color) {
		this.x = x1;
		this.y = y1;
		this.width = width;
		this.height = height;
		
	}
	
	public void draw (Graphics page) {
		// TODO Auto-generated method stub
		
	}

}
