package core.engine;

/*
// Good enough for now
*/
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Input implements KeyListener{
	public boolean[][] buttons = new boolean[2][7];
	/*
	0 = up
	1 = down
	2 = left
	3 = right
	4 = fire
	5 = shell
	6 = laser
	*/

	//constructor
	/**
	 * Input handler constructor
	 */
	public Input(){

	}

	/**
	 * key function, do not rename/remove
	 * checks if a key is pressed
	 */
	public void keyPressed(KeyEvent e) {
		//p1
		if (e.getKeyCode() == KeyEvent.VK_W) {
			buttons[0][0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			buttons[0][1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			buttons[0][2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			buttons[0][3] = true;
		}
		if (e.getKeyChar() == KeyEvent.VK_SPACE) {
			buttons[0][4] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			buttons[0][5] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_E) {
			buttons[0][6] = true;
		}
		
		//p2
		if (e.getKeyChar() == KeyEvent.VK_8) {
			buttons[1][0] = true;
		}
		if (e.getKeyChar() == KeyEvent.VK_5) {
            buttons[1][1] = true;
		}
		if (e.getKeyChar() == KeyEvent.VK_4) {
			buttons[1][2] = true;
		}
		if (e.getKeyChar() == KeyEvent.VK_6) {
			buttons[1][3] = true;
		}
		if (e.getKeyChar() == KeyEvent.VK_0) {
			buttons[1][4] = true;
		}
		if (e.getKeyChar() == KeyEvent.VK_7) {
			buttons[1][5] = true;
		}
		if (e.getKeyChar() == KeyEvent.VK_9) {
			buttons[1][6] = true;
		}
		
	}

	/**
	 * key function, do not rename/remove
	 * checks if a key is released
	 */
	public void keyReleased(KeyEvent e) {
		//p1
		if (e.getKeyCode() == KeyEvent.VK_W) {
			buttons[0][0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			buttons[0][1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			buttons[0][2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			buttons[0][3] = false;
		}
		if (e.getKeyChar() == KeyEvent.VK_SPACE) {
			buttons[0][4] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			buttons[0][5] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_E) {
			buttons[0][6] = false;
		}
		
		//p2
		if (e.getKeyChar() == KeyEvent.VK_8) {
			buttons[1][0] = false;
		}
		if (e.getKeyChar() == KeyEvent.VK_5) {
            buttons[1][1] = false;
		}
		if (e.getKeyChar() == KeyEvent.VK_4) {
			buttons[1][2] = false;
		}
		if (e.getKeyChar() == KeyEvent.VK_6) {
			buttons[1][3] = false;
		}
		if (e.getKeyChar() == KeyEvent.VK_0) {
			buttons[1][4] = false;
		}
		if (e.getKeyChar() == KeyEvent.VK_7) {
			buttons[1][5] = false;
		}
		if (e.getKeyChar() == KeyEvent.VK_9) {
			buttons[1][6] = false;
		}
	}

	/**
	 * key function, do not rename/remove
	 * checks if a key is typed
	 */
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 27) {
			System.exit(0);
		}
	}
};
