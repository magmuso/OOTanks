package core.engine;

/*
// Good enough for now
*/
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Input implements KeyListener{
	public boolean[][] buttons = new boolean[2][5];
	/*
	0 = up
	1 = down
	2 = left
	3 = right
	4 = space
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
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			buttons[1][0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            buttons[1][1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			buttons[1][2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			buttons[1][3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SLASH) {
			buttons[1][4] = true;
		}
	}

	/**
	 * key function, do not rename/remove
	 * checks if a key is released
	 */
	public void keyReleased(KeyEvent e) {
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
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			buttons[1][0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            buttons[1][1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			buttons[1][2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			buttons[1][3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SLASH) {
			buttons[1][4] = false;
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
