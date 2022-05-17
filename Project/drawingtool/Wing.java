package drawingtool;

public class Wing {
	private int width,height;
	private Engine engine; //Composite
	
	
	public Wing() {
	}

	public Wing(int width, int height) {
		this.width = width;
		this.height = height;
		engine= new Engine((int)(width/2.5),(int) (height/1.5));
	}
	
	public void drawAt(int left, int top) {
		Drawing.pen().drawOval(left, top, width, height);
		engine.drawAt(left+(int)(width*0.9), top+(int)(height/2.3));
	}
}
