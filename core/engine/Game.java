package core.engine;

import core.entities.*;

public class Game{
	//constructor
	public Land map;
	public Game(){
		map = new Land(800,600);
	}
	/**
	 * Initialises the game logic
	 */
	public void init(){
		createTank(100,100, 100, new Projectile(2,2,50,500,300), 8 , 1);
	}
	/**
	 * Updates the game logic
	 * @param inp Input handler
	 * @param delta delta time
	 */
	public void update(Input inp, double delta){
		for(Tank tank: map.tanks){
			tank.update(inp, map, delta);
		}
		int proj_id = 0;
		int proj_rm = map.projectiles.size();
		for(Projectile projectile: map.projectiles){
			if (projectile.isActive()){
				projectile.update(delta);	
			}
			else {
				proj_rm = proj_id;	
			}
			proj_id++;
		}
		if (proj_rm != proj_id && proj_id != 0)
			map.projectiles.remove(proj_rm);
	}
	/**
	 * releases the game logic
	 */
	public void release(){

	}
	/**
	 * Creates a tank on the map
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param hull tank's hitpoints (hull)
	 * @param proj Projectile image
	 * @param in_w weight
	 * @param ctrl controller
	 */
	private void createTank(double x, double y, int hull, Projectile proj, int in_w, int ctrl){
		map.tanks.add(new Tank(x, y, hull, proj, in_w, ctrl));
	}
};
