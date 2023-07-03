package project2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputListener extends KeyAdapter{
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(BeatBox1.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			BeatBox1.game.inputA();			
		}else if (e.getKeyCode() == KeyEvent.VK_S) {
			BeatBox1.game.inputS();
		}else if (e.getKeyCode() == KeyEvent.VK_D) {
			BeatBox1.game.inputD();
		}else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			BeatBox1.game.inputSpace();
		}else if (e.getKeyCode() == KeyEvent.VK_J) {
			BeatBox1.game.inputJ();
		}else if (e.getKeyCode() == KeyEvent.VK_K) {
			BeatBox1.game.inputK();
		}else if (e.getKeyCode() == KeyEvent.VK_L) {
			BeatBox1.game.inputL();
		}
		
	};
	@Override
	public void keyReleased(KeyEvent e) {
		if(BeatBox1.game == null) {
			return;			
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			BeatBox1.game.releaseA();
		}else if (e.getKeyCode() == KeyEvent.VK_S) {
			BeatBox1.game.releaseS();
		}else if (e.getKeyCode() == KeyEvent.VK_D) {
			BeatBox1.game.releaseD();
		}else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			BeatBox1.game.releaseSpace();
		}else if (e.getKeyCode() == KeyEvent.VK_J) {
			BeatBox1.game.releaseJ();
		}else if (e.getKeyCode() == KeyEvent.VK_K) {
			BeatBox1.game.releaseK();
		}else if (e.getKeyCode() == KeyEvent.VK_L) {
			BeatBox1.game.releaseL();
		}
		
	}

}
