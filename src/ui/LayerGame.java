package ui;

import java.awt.Graphics;
import java.awt.Point;

public class LayerGame extends Layer {
	
	private static final int ROL_SIZE = 5;
	public LayerGame(int x, int y, int w, int h)	{
		super(x, y, w, h);
	}
	
	public void paint(Graphics g)	{
		this.createWindow(g);
		Point[] actPoints = this.dto.getGameAct().getActPoints();
		int typeCode = this.dto.getGameAct().getTypeCode();
		for (int i = 0; i < actPoints.length; i++) {
			drawActByPoint(actPoints[i].x, actPoints[i].y, typeCode+1, g);
		}
		
		boolean[][] gameMap = this.dto.getGameMap();
		for (int x = 0; x < gameMap.length; x++) {
			for (int y = 0; y < gameMap[x].length; y++) {
				if (gameMap[x][y]) {
					drawActByPoint(x, y, 0, g);
				}
			}
		}
	}
	
	private void drawActByPoint(int x, int y, int imgidx, Graphics g) {
		g.drawImage(Img.ACT,
				this.x + (x << ROL_SIZE) + 7,
				this.y + (y << ROL_SIZE) + 7,
				this.x + ((x + 1) << ROL_SIZE) + 7, 
				this.y + ((y + 1) << ROL_SIZE) + 7,
				(imgidx) << ROL_SIZE, 0, (imgidx + 1) << ROL_SIZE, 1 << ROL_SIZE, null);
	}
}
