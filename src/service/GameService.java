package service;

import java.awt.Point;

import java.util.List;
import java.util.Random;

import dto.GameDto;
import dto.Player;
import entity.GameAct;

public class GameService {
	private GameDto dto;
	private Random random = new Random();
	private final int MAX_TYPE = 6;
	
	public GameService(GameDto dto) {
		this.dto = dto;
		GameAct gameAct = new GameAct(random.nextInt(this.MAX_TYPE));
		dto.setGameAct(gameAct);
		this.dto.setNext(random.nextInt(this.MAX_TYPE));
	}
	
	public void keyUp() {
		// TODO 
		if (this.canRound()) {
			this.dto.getGameAct().round(this.dto.getGameAct().getTypeCode());
		}
	}

	public void KeyDown() {
		//TODO
		if (canMove(0, 1)) {
			this.dto.getGameAct().move(0, 1);
		}else {
			boolean[][] gameMap = this.dto.getGameMap();
			Point[] actPoints = this.dto.getGameAct().getActPoints();
			for (int i = 0; i < actPoints.length; i++) {
				gameMap[actPoints[i].x][actPoints[i].y] = true;
			}
			//消行
			this.rmLine();
			
			//刷新下一个方块
			this.dto.getGameAct().refresh(this.dto.getNext());
			this.dto.setNext(random.nextInt(MAX_TYPE));
			
		}
	
	}

	public void keyLeft() {
		if (canMove(-1, 0)) {
			this.dto.getGameAct().move(-1, 0);
		}
		
	}

	public void keyRight() {
		if (canMove(1 ,0)) {
			this.dto.getGameAct().move(1, 0);
		}
	}
	
	private boolean canMove(int moveX, int moveY) {
		Point[] actPoints = this.dto.getGameAct().getActPoints();
		boolean[][] gameMap = this.dto.getGameMap();
		for (int i = 0; i < actPoints.length; i++) {
			int newX = actPoints[i].x + moveX;
			int newY = actPoints[i].y + moveY;
			if (this.isOutOfBounds(newX, newY, gameMap)) {
				return false;
			}
 		}
		return true;
	}
	
	private boolean canRound() {
		Point[] actPoints = this.dto.getGameAct().getActPoints();
		boolean[][] gameMap = this.dto.getGameMap();
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			//TODO
			if (this.isOutOfBounds(newX, newY, gameMap)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isOutOfBounds(int x, int y, boolean[][] gameMap) {
		return (x < 0 || x > 9 || y < 0 || y > 17 || gameMap[x][y]);
	}
	public void LevelUp() {
		int point = this.dto.getNowPoint();
		int rmLine = this.dto.getNowRemoveLine();
		int lv = this.dto.getNowLevel();
		point += 10;
		rmLine += 1;
		if (rmLine % 20 == 0) {
			lv++;
		}
		this.dto.setNowLevel(lv);
		this.dto.setNowRemoveLine(rmLine);
		this.dto.setNowPoint(point);
		
	}
	
	private void rmLine() {
		
		boolean[][] map = this.dto.getGameMap();
		for (int y = 0; y < map[0].length; y++) {
			boolean flag = true;
			for (int x = 0; x < map.length; x++) {
				if (!map[x][y]) {
					flag = false;
				}
			}
			if (flag) {
				this.doRmLine(y);
				this.LevelUp();
			}
		}
	}
	
	private void doRmLine(int lineNum) {
		boolean[][] map = this.dto.getGameMap();
		
		for (int y = lineNum; y > 0; y--) {
			for (int x = 0; x < map.length; x++) {
				map[x][y] = map[x][y-1];
			}
		}
		for (int x = 0; x < map.length; x++) {
			map[x][0] = false;
		}
	}
	
	
	//TODO ===================================================
	public void setDbRecode(List<Player> players) {
		this.dto.setDbRecode(players);
	}
	
	public void setDiskRecode(List<Player> players) {
		this.dto.setDiskRecode(players);
	}
	
}
 