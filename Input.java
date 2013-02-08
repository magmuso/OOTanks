import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input implements KeyListener{
    //constructor
    
    public Input(){
	
    }
    //public void startUpdate(){}
    //public void finishUpdate(){}
    
    boolean upPressed, downPressed;
    
    //key class, do not rename/remove
    public void keyPressed(KeyEvent e) {
    	if (e.getKeyCode() == KeyEvent.VK_UP) {
                upPressed = true;
            }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downPressed = true;
            }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }
    } 
    //key class, do not rename/remove
    public void keyReleased(KeyEvent e) {
    	if (e.getKeyCode() == KeyEvent.VK_UP) {
                upPressed = false;
            }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downPressed = false;
            }
         if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            	leftPressed = false;
            }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            	rightPressed = false;
            }	
    }
    //key class, do not rename/remove
    public void keyTyped(KeyEvent e) {
    	if (e.getKeyChar() == 27) {
		System.exit(0);
    	}
    }
};
