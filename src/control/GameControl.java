package control;

import dao.Data;
import dao.DataDisk;
import dao.DataTest;
import service.GameService;
import ui.JPanelGame;
/**
 * ������Ҽ����¼�
 * ���ƻ���
 * �����߼�
 * @author pash
 *
 */

public class GameControl {
	
	/**
	 * ���ݽӿ�A
	 */
	private Data dataA;
	
	/**
	 * ���ݽӿ�B
	 */
	private Data dataB;
	
	/**
	 * ��Ϸ�����
	 */
	private JPanelGame panelGame;
	
	/**
	 * ��Ϸ�߼���
	 */
	private GameService gameService;
	
	public GameControl(JPanelGame panelGame, GameService gameService) {
		this.panelGame = panelGame;
		this.gameService = gameService;
		this.dataA = new DataTest();
		this.gameService.setDbRecode(dataA.loadData());
		this.dataB = new DataDisk();
		this.gameService.setDiskRecode(dataB.loadData());
	}

	public void keyUp() {
		this.gameService.keyUp();
		this.panelGame.repaint();
	}

	public void KeyDown() {
		this.gameService.KeyDown();
		this.panelGame.repaint();
	}

	public void keyLeft() {
		this.gameService.keyLeft();
		this.panelGame.repaint();
		
	}

	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint();
	}

	//TODO  ========================���Է���============================
	public void testLevelUp() {
		this.gameService.LevelUp();
		this.panelGame.repaint();
	}
	
	

}
