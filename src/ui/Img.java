package ui;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Img {
	private Img() {}
	
	/**
	 * 个人签名
	 */
	public static Image IMG_ABOUT = new ImageIcon("graphics/string/PASH.png").getImage();
	/**
	 * 窗口边框图片
	 */
	public static Image IMG_WINDOW = new ImageIcon("graphics/window/Window.png").getImage();
	/**
	 * 数字图片
	 */
	public static Image IMG_NUMBER = new ImageIcon("graphics/string/num.png").getImage();
	/**
	 * 值槽
	 */
	public static Image IMG_RECT = new ImageIcon("graphics/window/rect.png").getImage();
	/**
	 * 背景
	 */
	public static Image IMG_BG_TEMP = new ImageIcon("graphics/background/bg03.jpg").getImage();
	/**
	 * 数据库标题
	 */
	public static Image IMG_DB = new ImageIcon("graphics/string/db.png").getImage();
	/**
	 * 本地记录标题
	 */
	public static Image IMG_DISK = new ImageIcon("graphics/string/disk.png").getImage();
	/**
	 * 游戏方块
	 */
	public static Image ACT = new ImageIcon("graphics/game/rect.png").getImage();
	/**
	 * 等级标题
	 */
	public static Image IMG_LV = new ImageIcon("graphics/string/level.png").getImage();
	/**
	 * 分数标题
	 */
	public static Image IMG_POINT = new ImageIcon("graphics/string/point.png").getImage();
	/**
	 * 消行标题
	 */
	public static Image IMG_RMLINE = new ImageIcon("graphics/string/rmline.png").getImage();
	
	/**
	 * 下一个方块的图片数组
	 */
	public static Image[] NEXT_ACT;
	
	public static List<Image> BG_LIST;
	
	
	static {
		NEXT_ACT = new Image[7];
		for (int i = 0; i < NEXT_ACT.length; i++) {
			NEXT_ACT[i] = new ImageIcon("graphics/game/" + i + ".png")
					.getImage();
		}
		
		//背景图片数组
		BG_LIST = new ArrayList<Image>();
		File dir = new File("graphics/background");
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				continue;
			}
			BG_LIST.add(new ImageIcon(file.getPath()).getImage());
		}
		
	}
}
