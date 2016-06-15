package ui;

import java.awt.Graphics;

public class LayerLevel extends Layer {
	
	
	private final int IMG_LV_W = Img.IMG_LV.getWidth(null);
	
	public LayerLevel(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	public void paint(Graphics g)	{
		this.createWindow(g);
		//窗口标题
		int centerX = this.w - this.IMG_LV_W >> 1;
		g.drawImage(Img.IMG_LV, this.x + centerX, this.y + PADDING, null);
		//显示等级
		this.drawNumberLeftPad(16, 64, this.dto.getNowLevel(), 5, g);
	}
	 
}
