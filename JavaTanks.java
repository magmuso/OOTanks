import java.awt.*;
import javax.swing.*;
public class JavaTanks {
    public JavaTanks(){
	mainInit();
	mainLoop();
	mainRelease();
    }
    public void mainLoop(){
	// constants for game loop timer
	final int FPS_TARGET = 60;
	final long TARGET_TIME = 1000000000/FPS_TARGET;

	// init of run_game
	boolean runGame = true;

	long frameTime = System.nanoTime();
	while(runGame){
	    //let's count the time taken to run a loop
	    long updateLength = frameTime - System.nanoTime();
	    frameTime = System.nanoTime();
	    double delta = updateLength / (double)TARGET_TIME;
	    
	    /*
	    inputUpdate();
	    gameUpdate(delta);
	    renderUpdate();
	    */

	    //sleep for some miliseconds to limit the framerate
	    try{Thread.sleep((frameTime-System.nanoTime()+TARGET_TIME) / 1000000 );} catch (Exception e){}

	    //temporary
	    runGame = false;
	    //
	}
    }
    public void mainInit(){
	/*
	  inputInit();
	  gameInit();
	  renderInit();
	 */
    }
    public void mainRelease(){
	/*
	  inputRelease();
	  gameRelease();
	  renderRelease();
	 */
    }
    public static void main(String[] args){
	new JavaTanks();
    }
};