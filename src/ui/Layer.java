package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import config.ConfigFactory;
import config.GameConfig;
import dto.GameDto;

/*
 * 绘制窗口
 */
public abstract class Layer {
	protected static final int PADDING ;
	private static final int SIZE;
	static {
		//获取配置
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
				//左上
				g.drawImage(Img.IMG_WINDOW, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);
				//中上
				g.drawImage(Img.IMG_WINDOW ,x+SIZE ,y ,w-SIZE+x ,y+SIZE ,SIZE, 0, WINDOW_W-SIZE, SIZE, null);
				//右上
				g.drawImage(Img.IMG_WINDOW, x+w-SIZE, y, x+w, y+SIZE, WINDOW_W-SIZE, 0, WINDOW_W, SIZE, null);
				//左中
				g.drawImage(Img.IMG_WINDOW, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE, WINDOW_H-SIZE, null);
				//中 
				g.drawImage(Img.IMG_WINDOW, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WINDOW_W-SIZE, WINDOW_H-SIZE, null);
				//右中
				g.drawImage(Img.IMG_WINDOW, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_W-SIZE, SIZE, WINDOW_W, WINDOW_H-SIZE, null);
				//左下
				g.drawImage(Img.IMG_WINDOW, x, y+h-SIZE, x+SIZE, y+h, 0, WINDOW_H-SIZE, SIZE, WINDOW_H, null);
				//中下
				g.drawImage(Img.IMG_WINDOW, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_H-SIZE, WINDOW_W-SIZE, WINDOW_H, null);
				//右下
				g.drawImage(Img.IMG_WINDOW, x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_W-SIZE, WINDOW_H-SIZE, WINDOW_W, WINDOW_H, null);
	}
	
	/*
	 * 刷新游戏具体内容
	 */
	abstract public void paint(Graphics g);
	
	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	

	/**
	 * 
	 * @param g 画笔
	 * @param x 要显示图片的左上角x坐标
	 * @param y 要显示图片的左上角y坐标
	 * @param num 要显示的数字
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
		//黑色外边框
		g.setColor(Color.black);
		g.fillRect(rect_x, rect_y, this.rectW, IMG_RECT_H + 4);
		//白色内边框
		g.setColor(Color.white);
		g.fillRect(rect_x + 1, rect_y + 1, this.rectW - 2, IMG_RECT_H + 2);
		//黑色底色
		g.setColor(Color.BLACK);
		g.fillRect(rect_x + 2, rect_y + 2, this.rectW - 4, IMG_RECT_H);		
		//设置显示字体颜色
		g.setColor(Color.cyan);	
		//显示比例
		int w = (int)(percent * (this.rectW - 4));
		int subIdx = (int)((1 - percent)*IMG_RECT_W) + 1;
		//绘制值槽内部填充
		
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