package dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entity.GameAct;

public class GameDto {
	
	private List<Player> dbRecode;
	
	private List<Player> diskRecode;
	
	private boolean[][] gameMap;
	
	/*
	 * 下落方块
	 */
	
	private GameAct gameAct;
	
	/**
	 * 下一个方块
	 */
	
	private int next;
	
	private int nowLevel;
	
	private int nowPoint;
	
	private int nowRemoveLine;
	
	public GameDto() {
		initMap();
	}
	
	public void initMap() {
		//TODO
		this.gameMap = new boolean[10][18]; 
	}
	

	public List<Player> getDbRecode() {
		return dbRecode;
	}

	public void setDbRecode(List<Player> dbRecode) {
		this.dbRecode = this.fillData(dbRecode);
	}

	public List<Player> getDiskRecode() {
		return diskRecode;
	}

	public void setDiskRecode(List<Player> diskRecode) {
		this.diskRecode = this.fillData(diskRecode);
	}

	public boolean[][] getGameMap() {
		return gameMap;
	}

	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}

	public GameAct getGameAct() {
		return gameAct;
	}

	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	

	public int getNowLevel() {
		return nowLevel;
	}

	public void setNowLevel(int nowLevel) {
		this.nowLevel = nowLevel;
	}

	public int getNowPoint() {
		return nowPoint;
	}

	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}

	public int getNowRemoveLine() {
		return nowRemoveLine;
	}

	public void setNowRemoveLine(int nowRemoveLine) {
		this.nowRemoveLine = nowRemoveLine;
	}
	
	private List<Player> fillData(List<Player> players) {
		if( null == players ) {
			players = new ArrayList<Player>();
		}
		while( players.size() < 5 ) {
			players.add(new Player("No Data", 0));
		}
		Collections.sort(players);
		return players;
	}
}
