package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import config.ConfigFactory;
import config.GameConfig;
import dto.GameDto;

/*
 * ���ƴ���
 */
public abstract class Layer {
	protected static final int PADDING ;
	private static final int SIZE;
	static {
		//��ȡ����
		GameConfig cfg = ConfigFactory.getGameConfig();
		PADDING = cfg.getPadding();
		SIZE = cfg.getWindowSize();
	}
	
	private static int WINDOW_W = Img.IMG_WINDOW.getWidth(null);
	private static int WINDOW_H = Img.IMG_WINDOW.getHeight(null);
	protected int x;	
	protected int y;	
	protected int w;
	protected int h;
	protected GameDto dto;
	
	
	protected final int IMG_NUMBER_W = Img.IMG_NUMBER.getWidth(null) / 10;
	protected final int IMG_NUMBER_H = Img.IMG_NUMBER.getHeight(null);
	
	
	protected static final int IMG_RECT_H = 12;
	protected static final int IMG_RECT_W = Img.IMG_RECT.getWidth(null);
	protected final int rectW ;

	public Layer(int x, int y, int w, int h)	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		rectW = this.w - (PADDING << 1);
	}
	protected void createWindow(Graphics g)	{
				//����
				g.drawImage(Img.IMG_WINDOW, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);
				//����
				g.drawImage(Img.IMG_WINDOW ,x+SIZE ,y ,w-SIZE+x ,y+SIZE ,SIZE, 0, WINDOW_W-SIZE, SIZE, null);
				//����
				g.drawImage(Img.IMG_WINDOW, x+w-SIZE, y, x+w, y+SIZE, WINDOW_W-SIZE, 0, WINDOW_W, SIZE, null);
				//����
				g.drawImage(Img.IMG_WINDOW, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE, WINDOW_H-SIZE, null);
				//�� 
				g.drawImage(Img.IMG_WINDOW, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WINDOW_W-SIZE, WINDOW_H-SIZE, null);
				//����
				g.drawImage(Img.IMG_WINDOW, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_W-SIZE, SIZE, WINDOW_W, WINDOW_H-SIZE, null);
				//����
				g.drawImage(Img.IMG_WINDOW, x, y+h-SIZE, x+SIZE, y+h, 0, WINDOW_H-SIZE, SIZE, WINDOW_H, null);
				//����
				g.drawImage(Img.IMG_WINDOW, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_H-SIZE, WINDOW_W-SIZE, WINDOW_H, null);
				//����
				g.drawImage(Img.IMG_WINDOW, x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_W-SIZE, WINDOW_H-SIZE, WINDOW_W, WINDOW_H, null);
	}
	
	/*
	 * ˢ����Ϸ��������
	 */
	abstract public void paint(Graphics g);
	
	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	

	/**
	 * 
	 * @param g ����
	 * @param x Ҫ��ʾͼƬ�����Ͻ�x����
	 * @param y Ҫ��ʾͼƬ�����Ͻ�y����
	 * @param num Ҫ��ʾ������
	 */
	protected void drawNumberLeftPad(int x, int y, int num, int maxBit, Graphics g) {
		String strNum = Integer.toString(num);
		for (int i = 0; i < maxBit; i++) {
			if (maxBit - i <= strNum.length()) {
				int idx = i - maxBit + strNum.length();
				int bit = strNum.charAt(idx) - '0';
				g.drawImage(Img.IMG_NUMBER, 
						this.x + x + this.IMG_NUMBER_W*i, this.y + y,
						this.x + x + this.IMG_NUMBER_W*(1 + i) , this.y + y + this.IMG_NUMBER_H,
						bit*this.IMG_NUMBER_W, 0, (bit + 1)*this.IMG_NUMBER_W, this.IMG_NUMBER_H, null);
			}
		}
		
	}
	
	protected void drawRect(int y, String title, String number, double percent, Graphics g) {
		
		int rect_x = this.x + PADDING;
		int rect_y = this.y + y;
		//��ɫ��߿�
		g.setColor(Color.black);
		g.fillRect(rect_x, rect_y, this.rectW, IMG_RECT_H + 4);
		//��ɫ�ڱ߿�
		g.setColor(Color.white);
		g.fillRect(rect_x + 1, rect_y + 1, this.rectW - 2, IMG_RECT_H + 2);
		//��ɫ��ɫ
		g.setColor(Color.BLACK);
		g.fillRect(rect_x + 2, rect_y + 2, this.rectW - 4, IMG_RECT_H);		
		//������ʾ������ɫ
		g.setColor(Color.cyan);	
		//��ʾ����
		int w = (int)(percent * (this.rectW - 4));
		int subIdx = (int)((1 - percent)*IMG_RECT_W) + 1;
		//����ֵ���ڲ����
		
			g.drawImage(Img.IMG_RECT,
					rect_x + 2, rect_y + 2,
					rect_x + 2 + w, rect_y + IMG_RECT_H + 2,
					subIdx, 0, subIdx + 1, IMG_RECT_H,
					null);
		
		g.drawString(title, rect_x + 2, rect_y + IMG_RECT_H);
		if( number != null ) {
			g.drawString(number, rect_x + 248, rect_y + IMG_RECT_H); 
		}
		
		//TODO
	}
	
	protected void drawImageAtCenter(Graphics g, Image img) {
		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
		
		g.drawImage(img, this.x + (this.w -  imgW >> 1), this.y + (this.h - imgH >> 1), null);
	}
	
	
}