package control;

import dao.Data;
import dao.DataDisk;
import dao.DataTest;
import service.GameService;
import ui.JPanelGame;
/**
 * 接收玩家键盘事件
 * 控制画面
 * 控制逻辑
 * @author pash
 *
 */

public class GameControl {
	
	/**
	 * 数据接口A
	 */
	private Data dataA;
	
	/**
	 * 数据接口B
	 */
	private Data dataB;
	
	/**
	 * 游戏界面层
	 */
	private JPanelGame panelGame;
	
	/**
	 * 游戏逻辑层
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

	//TODO  ========================测试方法============================
	public void testLevelUp() {
		this.gameService.LevelUp();
		this.panelGame.repaint();
	}
	
	

}
