package core.engine;

import java.util.ArrayList;

import core.entities.Entity;
import core.entities.top.*;

public class Game{
	//constructor
	public Land map;
	public Input inp;
	public Collider coll;
	
	public ArrayList<HumanTank> players = new ArrayList<HumanTank>();
	public ArrayList<Prop> props = new ArrayList<Prop>();
			
	public Game(){
		map = new Land(1248,702);
		inp = new Input();
		coll = new Collider(map);
	}
	/**
	 * Initialises the game logic
	 */
	public void init(){
		players.add(new HumanTank(map, inp,100,100, Math.PI,100, new ShellCannon(), 10,(byte)1));
		players.add(new HumanTank(map, inp,1100,650, 0, 100, new ShellCannon(), 10, (byte)2));
		for (HumanTank tank : players){
			map.gameEntities.add(tank);
		}
		props.add(new Prop(map, 460, 350, 0));
		props.add(new Prop(map, 920, 130, 4));
		for (Prop prop : props){
			map.gameEntities.add(prop);
		}
	}
	/**
	 * Updates the game logic
	 * @param inp Input handler
	 * @param delta delta time
	 */
	public int update(double delta){
		for(int i = 0; i < map.gameEntities.size(); i++){
			Entity ent = map.gameEntities.get(i);
			ent.update(delta);
			if(players.get(0).getHull() <= 0){
				return 2;
			} else if (players.get(1).getHull()<=0){
				return 1;
			}
		}
		for(int i = map.gameEntities.size()-1;i > -1; i--){
			if (!map.gameEntities.get(i).getActive()){
				map.gameEntities.remove(i);
			}
		}
		coll.update();
		return 0;
	}
	/**
	 * releases the game logic
	 */
	public void release(){
		players.clear();
		map.gameEntities.clear();
		init();
	}
};
