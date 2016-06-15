package main;

import service.GameService;
import ui.JFrameGame;
import ui.JPanelGame;
import control.GameControl;
import control.PlayerControl;
import dto.GameDto;

public class Main {

	public static void main(String[] args) {
		
		GameDto dto = new GameDto();
		
		JPanelGame panel = new JPanelGame(dto);
		
		GameService service = new GameService(dto);
		
		GameControl gameControl = new GameControl(panel, service);
		
		PlayerControl playerControl = new PlayerControl(gameControl);
		
		panel.setGameControl(playerControl);
		
		new JFrameGame(panel);
		
	}

}
