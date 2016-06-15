package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class DataTest implements Data {

	@Override
	public void saveData(List<Player> players) {
	}

	@Override
	public List<Player> loadData() {
		List<Player> players = new ArrayList<Player>();
		players.add(new Player("path", 100));
		players.add(new Player("path", 10000));
		players.add(new Player("path", 200));
//		players.add(new Player("path", 500));
//		players.add(new Player("path", 1000));
		return players;
	}

	
}
