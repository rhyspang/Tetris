package ui;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Img {
	private Img() {}
	
	/**
	 * ����ǩ��
	 */
	public static Image IMG_ABOUT = new ImageIcon("graphics/string/PASH.png").getImage();
	/**
	 * ���ڱ߿�ͼƬ
	 */
	public static Image IMG_WINDOW = new ImageIcon("graphics/window/Window.png").getImage();
	/**
	 * ����ͼƬ
	 */
	public static Image IMG_NUMBER = new ImageIcon("graphics/string/num.png").getImage();
	/**
	 * ֵ��
	 */
	public static Image IMG_RECT = new ImageIcon("graphics/window/rect.png").getImage();
	/**
	 * ����
	 */
	public static Image IMG_BG_TEMP = new ImageIcon("graphics/background/bg03.jpg").getImage();
	/**
	 * ���ݿ����
	 */
	public static Image IMG_DB = new ImageIcon("graphics/string/db.png").getImage();
	/**
	 * ���ؼ�¼����
	 */
	public static Image IMG_DISK = new ImageIcon("graphics/string/disk.png").getImage();
	/**
	 * ��Ϸ����
	 */
	public static Image ACT = new ImageIcon("graphics/game/rect.png").getImage();
	/**
	 * �ȼ�����
	 */
	public static Image IMG_LV = new ImageIcon("graphics/string/level.png").getImage();
	/**
	 * ��������
	 */
	public static Image IMG_POINT = new ImageIcon("graphics/string/point.png").getImage();
	/**
	 * ���б���
	 */
	public static Image IMG_RMLINE = new ImageIcon("graphics/string/rmline.png").getImage();
	
	/**
	 * ��һ�������ͼƬ����
	 */
	public static Image[] NEXT_ACT;
	
	public static List<Image> BG_LIST;
	
	
	static {
		NEXT_ACT = new Image[7];
		for (int i = 0; i < NEXT_ACT.length; i++) {
			NEXT_ACT[i] = new ImageIcon("graphics/game/" + i + ".png")
					.getImage();
		}
		
		//����ͼƬ����
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
