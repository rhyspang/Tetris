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
		//LAYERPOINT�еĶ���ؼ��Ĺ�ͬX����
		comX = this.w - IMG_NUMBER_W * POINT_BIT - PADDING;
		//������ʾ���ڵ�Y����
		pointY = PADDING;
		//���д��ڵ�Y����
		rmLineY = this.pointY + Img.IMG_POINT.getHeight(null) + (PADDING << 1);
		//����ֵ�۵�Y����
		this.expY = this.rmLineY + Img.IMG_RMLINE.getHeight(null) + PADDING;
	 
	}
	
	public void paint(Graphics g)	{
		this.createWindow(g);
		g.drawImage(Img.IMG_POINT, this.x + PADDING, this.y + pointY, null);
		
		this.drawNumberLeftPad(this.comX, pointY, this.dto.getNowPoint(), POINT_BIT, g);
	
		g.drawImage(Img.IMG_RMLINE, this.x + PADDING, this.y + rmLineY, null);
		
		this.drawNumberLeftPad(this.comX, rmLineY, this.dto.getNowRemoveLine(), POINT_BIT, g);
		
		int rmLine = this.dto.getNowRemoveLine();
		
		this.drawRect(expY, "��һ��", "66", (double)(rmLine % levelUp) / (double)levelUp, g);
		
	}
	
	
}
