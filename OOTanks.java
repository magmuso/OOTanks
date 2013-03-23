import core.engine.Game;
import graphics.Renderer;

public class OOTanks {
	private Game strat;
	private Renderer render;

	public OOTanks(){	
		//init main parts of the game
		strat  = new Game();
		render = new Renderer(strat.inp);
	}
	private void mainInit(){
		strat.init();
		render.init(strat.players);
	}
	private void mainLoop(){

		// constants for game loop timer
		final double ADJUSTMENT = 10.0;
		final int FPS_TARGET = 60;
		final long TARGET_TIME = 1000000000/FPS_TARGET;

		// init of run_game
		boolean runGame = true;
		boolean notQuit = true;
		long frameTime = System.nanoTime();
		while (notQuit){
			//run init screen
			render.initScreen(strat.inp);
			//
			while(runGame){
				//let's count the time taken to run a loop
				long updateLength = frameTime - System.nanoTime();
				frameTime = System.nanoTime();
				double delta = updateLength / (double)TARGET_TIME / ADJUSTMENT;
				runGame = strat.update(delta);
				render.update(strat.map);
	
				//sleep for some milliseconds to limit the frame rate
				try{Thread.sleep((frameTime-System.nanoTime()+TARGET_TIME) / 1000000 );} catch (Exception e){}
			}
			//run gameover screen
			
			//
		}
	}
	private void mainRelease(){
		strat.release();
		render.release();

		//quits
		System.exit(0);
	}
	public static void main(String[] args){
		OOTanks jt = new OOTanks();
		jt.mainInit();
		jt.mainLoop();
		jt.mainRelease();
	}
};
