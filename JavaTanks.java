import java.awt.*;
import javax.swing.*;
public class JavaTanks extends JFrame {
    
    private Input inp;
    private Game core;
    private Renderer render;
    
    public JavaTanks(){
	mainInit();
	mainLoop();
	mainRelease();
    }
    public void mainInit(){
    	setTitle("OOTanks");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
	
	inp = new Input();
	core  = new Game();
	render = new Renderer();
	
	inp.init();
	core.init();
	render.init();

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
	    
	    inp.update();

	    core.update(delta);

	    render.update();

	    //sleep for some miliseconds to limit the framerate
	    try{Thread.sleep((frameTime-System.nanoTime()+TARGET_TIME) / 1000000 );} catch (Exception e){}

	    //temporary
	    runGame = false;
	    //
	}
    }
    public void mainRelease(){
	dispose();

	inp.release();
	core.release();
	render.update();
    }
    public static void main(String[] args){
	new JavaTanks();
    }
};
