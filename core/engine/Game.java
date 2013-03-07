package core.engine;

import core.entities.top.*;

public class Game{
	//constructor
	public Land map;
	public Input inp;
	public Collider coll;
	public Game(){
		map = new Land(800,600);
		inp = new Input();
		coll = new Collider(map);
	}
	/**
	 * Initialises the game logic
	 */
	public void init(){
		map.gameEntities.add(new HumanTank(map, inp,300,300, 0, 0, new ShellCannon(), 0, (byte)0));
		map.gameEntities.add(new HumanTank(map, inp,100,100,0,0,new ShellCannon(),0,(byte)1));
	}
	/**
	 * Updates the game logic
	 * @param inp Input handler
	 * @param delta delta time
	 */
	public void update(double delta){
		coll.update();
		for(int i = 0; i < map.gameEntities.size(); i++){
			map.gameEntities.get(i).update(delta);
		}
		for(int i = map.gameEntities.size()-1;i > -1; i--){
			if (!map.gameEntities.get(i).getActive()){
				map.gameEntities.remove(i);
			}
		}
	}
	/**
	 * releases the game logic
	 */
	public void release(){
		
	}
};
