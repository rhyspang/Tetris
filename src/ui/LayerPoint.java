package ui;


import java.awt.Graphics;

public class LayerPoint extends Layer {
	
	private final int rmLineY;
	
	private final int pointY;
	
	private  static final int POINT_BIT = 5;
	
	private final int comX;
	
	private final int expY;
	
	private static final int levelUp = 20;
	
	public LayerPoint(int x, int y , int w, int h)	{
		super(x, y, w, h);
		//LAYERPOINT中的多个控件的共同X坐标
		comX = this.w - IMG_NUMBER_W * POINT_BIT - PADDING;
		//分数显示窗口的Y坐标
		pointY = PADDING;
		//消行窗口的Y坐标
		rmLineY = this.pointY + Img.IMG_POINT.getHeight(null) + (PADDING << 1);
		//经验值槽的Y坐标
		this.expY = this.rmLineY + Img.IMG_RMLINE.getHeight(null) + PADDING;
	 
	}
	
	public void paint(Graphics g)	{
		this.createWindow(g);
		g.drawImage(Img.IMG_POINT, this.x + PADDING, this.y + pointY, null);
		
		this.drawNumberLeftPad(this.comX, pointY, this.dto.getNowPoint(), POINT_BIT, g);
	
		g.drawImage(Img.IMG_RMLINE, this.x + PADDING, this.y + rmLineY, null);
		
		this.drawNumberLeftPad(this.comX, rmLineY, this.dto.getNowRemoveLine(), POINT_BIT, g);
		
		int rmLine = this.dto.getNowRemoveLine();
		
		this.drawRect(expY, "下一级", "66", (double)(rmLine % levelUp) / (double)levelUp, g);
		
	}
	
	
}
