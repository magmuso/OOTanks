import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JavaTanks extends Canvas {
    
    private JFrame frame;

    private Input inp;
    private Game strat;
    private Renderer render;
    
    public JavaTanks(){
	//creating frame
	frame = new JFrame("JavaTanks");
	
	//get content of the frame, determine size
	JPanel panel = (JPanel) frame.getContentPane();
	panel.setPreferredSize(new Dimension(800,600));
	panel.setLayout(null);

	//set up canvas and boundaries, add panel to 'this' canvas
	setBounds(0,0,800,600);
	panel.add(this);
	
	//we will paint manually, so
	setIgnoreRepaint(true);
	
	//init main parts of the game
	inp = new Input();
	strat  = new Game();
	render = new Renderer();
    }
    public void mainInit(){
	frame.pack();
	frame.setResizable(false);
	frame.setVisible(true);
	
	//exiting the game by pressing "X" on the frame
	frame.addWindowListener(new WindowAdapter(){
	    public void windowClosing(WindowEvent e){
		System.exit(0);
	    }
	 });

	//Lewis look here, we are adding input handler to our canvas
	//add key to class which handles input
	//addKeyListener();

	//then we tell our canvas to focus and be always prepared for input
	//requestFocus();

	inp.init();
	strat.init();
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

	    strat.update(delta);

	    render.update();

	    //sleep for some miliseconds to limit the framerate
	    try{Thread.sleep((frameTime-System.nanoTime()+TARGET_TIME) / 1000000 );} catch (Exception e){}

	    //temporary
	    runGame = false;
	    //
	}
    }
    public void mainRelease(){
	inp.release();
	strat.release();
	render.release();
	System.exit(0);
    }
    public static void main(String[] args){
	JavaTanks jt = new JavaTanks();
	jt.mainInit();
	jt.mainLoop();
	jt.mainRelease();
    }
};
