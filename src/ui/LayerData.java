package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import dto.Player;

public abstract class LayerData extends Layer {
	//TODO ≈‰÷√Œƒº˛
	protected static final int MAX_ROW = 5;
		
	protected static final int RECT_H = IMG_RECT_H + 4;
		
	protected static int START_Y = 0;
		
	protected static int SPA;


	public LayerData(int x, int y, int w, int h) {
		super(x, y, w, h);
		SPA = (this.h - (RECT_H)*5 - (PADDING << 1) - Img.IMG_DB.getHeight(null)) / MAX_ROW;
		START_Y = PADDING + Img.IMG_DB.getHeight(null) + SPA;
	}

	protected void drawDataRect(Image img, List<Player> players, Graphics g) {
		this.createWindow(g);
		int nowPoint = this.dto.getNowPoint();
		g.drawImage(img, this.x + PADDING, this.y + PADDING, null);
		for (int i = 0; i < MAX_ROW; i++) {
			Player pla = players.get(i);
			double percent =  pla.getPoint() == 0 ? 0 : (double)nowPoint / pla.getPoint();
			percent  = percent > 1 ? 1 : percent;
			String pPoint = pla.getPoint() == 0 ? null : Integer.toString(pla.getPoint());
			this.drawRect(START_Y + i*(RECT_H + SPA), pla.getName(), 
					pPoint, percent, g);
		}
	}
}