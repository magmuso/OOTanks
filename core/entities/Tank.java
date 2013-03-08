package core.entities;

import core.engine.Land;

public abstract class Tank extends GameEntity{
	protected Weapon wep;
	protected int hull;
	public Tank(Land map, double x, double y, double angle, int hull, Weapon wep, int weight){
		super(map, x, y, 60, 30, weight);
		this.wep = wep;
		this.angle = angle;
		this.hull = hull;
		this.maxVelocity = 80.0 - weight;
	}
	/**
	 * Fires a projecile(s) by adding instances to the map
	 * @param map Land where to put the instances
	 */
	//tank fire function
	protected void fire() {
		wep.fire(map, x,y,angle);
	}
	@Override
	public void onCollision(GameEntity ent){
		
	}
};
