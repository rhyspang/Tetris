package entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GameAct {
	
	private Point[] actPoints;
	
	/**
	 * ·½¿é±àºÅ
	 */
	
	private int typeCode;
	
	
	private static List<Point[]> TYPE_CONFIG;
	
	static {
		TYPE_CONFIG = new ArrayList<Point[]>(7);
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(6, 0)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(4, 1)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(3, 1)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 1), new Point(5, 0), new Point(4, 1)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(4, 1), new Point(5, 0), new Point(5, 1)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(5, 0), new Point(5, 1)});
		TYPE_CONFIG.add(new Point[]{new Point(4, 0), new Point(3, 0), new Point(4, 1), new Point(5, 1)});
	}
	
	public int getTypeCode() {
		return typeCode;
	}
	
	public GameAct(int typeCode) {
		//TODO
		this.refresh(typeCode);
	}

	public Point[] getActPoints() {
		return actPoints;
	}
	
	public void move(int moveX, int moveY) {
		for (int i = 0; i < actPoints.length; i++) {
			actPoints[i].x += moveX;
			actPoints[i].y += moveY;
		}
	}
	
	public void round(int typeCode) {
		if (typeCode != 4) {
			for (int i = 1; i < actPoints.length; i++) {
				int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
				int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
				//TODO
				
				actPoints[i].x = newX;
				actPoints[i].y = newY;
			}
		}
	}
	
	public void refresh(int typeCode) {
		this.typeCode = typeCode;
		Point[] points = TYPE_CONFIG.get(typeCode);
		actPoints = new Point[points.length];
		for (int i = 0; i < points.length; i++) {
			actPoints[i] = new Point(points[i].x, points[i].y);
		}
	}
}
