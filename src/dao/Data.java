package dao;

import java.util.List;

import dto.Player;

public interface Data {
	
	void saveData(List<Player> players);
	List<Player> loadData();
}
