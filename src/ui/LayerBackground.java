package ui;

import java.awt.Graphics;


public class LayerBackground extends Layer {
	//TODO ¡„ ±±≥æ∞
	
	public LayerBackground(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Img.IMG_BG_TEMP, 0, 0, 1162, 674, null);
	}

}
