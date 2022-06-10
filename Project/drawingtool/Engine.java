package drawingtool;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Path2D;

public class Engine {

	private int width, height;
	private Color color;

	public Engine(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public Engine(int width, int height) {
		this.width = width;
		this.height = height;
		color = Color.white;
	}

	public Point getBezier(Point point, Point relativeZero, double calcScaling) {
		int bezierX = (int) (calcScaling * (point.x - relativeZero.x));
		int bezierY = (int) (calcScaling * (point.y - relativeZero.y));
		Point bezier = new Point(Math.abs(bezierX), Math.abs(bezierY));

		return bezier;
	}

	public void drawAt(int left, int top) {
		int xEndPoint, yEndPoint ;
		int scaling = 2;
		
		//For bottom curve
		Point relativeZero = new Point((int) (width/0.5),(int) (height/0.3));
		Point firstBezierPoint = getBezier(new Point((int)(width/0.521), (int)(height/0.306)), relativeZero, scaling);
		Point secondBezierPoint = getBezier(new Point((int)(width/0.556),(int)(height/0.306)), relativeZero, scaling);
		Point endPoint = getBezier(new Point((int)(width/0.625),(int)(height/0.294)), relativeZero, scaling);
		
		//For top curve
		Point relativeZeroT = new Point((int) (width/0.625),(int)(height/0.227));
		Point firstBezierPointT = getBezier(new Point((int)(width/0.556),(int)(height/0.234)), relativeZeroT, scaling);
		Point secondBezierPointT = getBezier(new Point((int)(width/0.521),(int)(height/0.234)), relativeZeroT, scaling);
		
		Path2D.Double engine = new Path2D.Double();
		engine.moveTo(left, top);
		
		//FrontPart
		engine.lineTo(left, top + height);
		yEndPoint = top + height;
		
		//Bottom curved part
		
		engine.curveTo(left - firstBezierPoint.x, yEndPoint + firstBezierPoint.y, left - secondBezierPoint.x,
				yEndPoint + secondBezierPoint.y, left - endPoint.x, yEndPoint - endPoint.y);
		xEndPoint = left - endPoint.x;
		yEndPoint = yEndPoint - endPoint.y;
		
		//Back Part
		engine.lineTo(xEndPoint,yEndPoint-height/1.3);
		yEndPoint -= height/1.3;
		
//		//Top curved part
		engine.curveTo(xEndPoint + firstBezierPointT.x, yEndPoint - firstBezierPointT.y, xEndPoint + secondBezierPointT.x,
				yEndPoint - secondBezierPointT.y, left, top);
		
		

		Drawing.pen().draw(engine);
		Drawing.pen().setColor(color);
		Drawing.pen().fill(engine);
		Drawing.pen().setColor(Color.black);
	}
}
