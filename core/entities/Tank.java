package core.entities;

import core.engine.Input;
import core.engine.Land;

public class Tank extends GameEntity{
	private final int controller;
	private Weapon wep;
	public int hull;
	/**
	 * Tank constructor
	 * @param in_x
	 * @param in_y
	 * @param in_hull hitpoints (hull) of the tank
	 * @param proj image of a projectile
	 * @param in_w weight
	 * @param control controller (0 - AI, 1 - Player One, 2 - Player Two, 3+ none)
	 */
	public Tank(double in_x, double in_y, int in_hull, Projectile proj, int in_w, int control){
		super(in_x, in_y, 60, 30, in_w);
		wep = new Weapon(proj, 500);
		//we can adjust this later
		hull = in_hull;
		maxSpeed = 80.0 - in_w;
		controller = control;
	}
	/**
	 * Fires a projecile(s) by adding instances to the map
	 * @param map Land where to put the instances
	 */
	//tank fire function
	private void fire(Land map) {
		Projectile tempProj[] = wep.launch(x, y, angle);
		if (tempProj != null){
			for (Projectile proj: tempProj){
				map.projectiles.add(proj);
			}
		}
	}
	/**
	 * Handles input
	 * @param inp input hanldler
	 * @param map map to pass to the fire function
	 * @see Input
	 */
	private void handleInput(Input inp, Land map){
		if(controller == 1){
			if (inp.buttons1[0]) accelerate(4.5);
			if (inp.buttons1[1]) accelerate(-4.5);
			if (inp.buttons1[2]) turn(-1);
			if (inp.buttons1[3]) turn(1);
			if (inp.buttons1[4]) fire(map);
		}
	}
	/**
	 * Updates the tank object
	 * @param inp input handler
	 * @param map Land where the tank is
	 * @param delta delta time for movement
	 */
	public void update(Input inp, Land map, double delta){
		time = dTime(delta);
		handleInput(inp, map);
		applyPhysics();
	}
};
