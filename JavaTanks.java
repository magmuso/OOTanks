import java.awt.event.KeyListener;

public class OOTanks {
    
    private Input inp;
    private Game strat;
    private Renderer render;
    
    public OOTanks(){	
	//init main parts of the game
	inp = new Input();
	strat  = new Game();
	render = new Renderer(inp);
    }
    private void mainInit(){
	strat.init();
	render.init();
    }
    private void mainLoop(){
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
	    
	    //inp.startUpdate();
	    strat.update(delta);
	    render.update();
	    //inp.finishUpdate();

	    //sleep for some miliseconds to limit the framerate
	    try{Thread.sleep((frameTime-System.nanoTime()+TARGET_TIME) / 1000000 );} catch (Exception e){}

	}
    }
    private void mainRelease(){
	strat.release();
	render.release();
	//quits
	System.exit(0);
    }
    public static void main(String[] args){
	JavaTanks jt = new OOTanks();
	jt.mainInit();
	jt.mainLoop();
	jt.mainRelease();
    }
};
