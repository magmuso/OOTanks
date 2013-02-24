package core.entities;

import core.engine.Input;
import core.engine.Land;

public class Tank extends GameEntity{
	private final int controller;
	private Weapon wep;
	public int hull;
	public Tank(double in_x, double in_y, int in_hull, Projectile proj, int in_w, int control){
		super(in_x, in_y, in_w);
		wep = new Weapon(proj, 500);
		//we can adjust this later
		hull = in_hull;
		maxSpeed = 80.0 - in_w;
		controller = control;
	}
	//tank fire function
	private void fire(Land map) {
		Projectile tempProj[] = wep.launch(x, y, angle);
		if (tempProj != null){
			for (Projectile proj: tempProj){
				map.projectiles.add(proj);
			}
		}
	}
	private void handleInput(Input inp, Land map){
		if(controller == 1){
			if (inp.buttons1[0]) accelerate(4.5);
			if (inp.buttons1[1]) accelerate(-4.5);
			if (inp.buttons1[2]) turn(-1);
			if (inp.buttons1[3]) turn(1);
			if (inp.buttons1[4]) fire(map);
		}
	}
	public void update(Input inp, Land map, double delta){
		time = dTime(delta);
		handleInput(inp, map);
		applyPhysics();
	}
};
