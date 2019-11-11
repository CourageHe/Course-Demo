package player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class MyMouseListener extends MouseAdapter {
	private MusicPlayer  player;
	
	public MyMouseListener(MusicPlayer player) {
		super();
		this.player = player;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn= (JButton)e.getSource();
		if(btn == player.btn_last) {

		}else if(btn == player.btn_player) {
			
		}else if(btn == player.btn_next) {
			
		}else if(btn == player.btn_model) {
			
		}
	}
}
