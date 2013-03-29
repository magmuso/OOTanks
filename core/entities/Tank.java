package core.entities;

import core.engine.Land;
import core.entities.top.LaserCannon;
import core.entities.top.ShellCannon;

public abstract class Tank extends GameEntity{
	protected boolean destroyed = false;
	protected ShellCannon shell = new ShellCannon();
	protected LaserCannon laser = new LaserCannon();
	protected Weapon wep;
	protected int wepId;
	protected int hull;
	protected int maxHull;
	public Tank(Land map, double x, double y, double angle, int hull, Weapon wep, int weight){
		super(map, x, y, 77, 49, weight);
		this.wep = wep;
		this.angle = angle;
		this.hull = hull;
		this.maxHull = hull;
		this.maxVelocity = 120.0 - weight;
	}
	/**
	 * Fires a projecile(s) by adding instances to the map
	 * @param map Land where to put the instances
	 */
	//tank fire function
	protected void fire() {
		wep.fire(map, this);
	}
	
	public void setWeapon(int id) {
		wepId = id;
		if (id == 0) {
			wep = shell;
		}
		else if (id == 1) {
			wep = laser;
		}
	}
	@Override
	public void onCollision(GameEntity ent){
		if (ent != null){
			if (ent.getWeight() > 0){
				cancelMove();
				if (weight * v > 200){
					v = -v/2;
				} else {
					v = 0;
				}
			}
		} else {
			cancelMove();
			if (weight * v > 200){
				v = -v/2;
			} else {
				v = 0;
			}
		}
	}
	public void takeDamage(int dmg){
		hull -= dmg;
		if (hull <= 0){
			destroy();
		}
	}
	public int getHull() {
		return hull;
	}
	public boolean isDestroyed(){
		return destroyed;
	}
	private void destroy(){
		destroyed = true;
	}
	public int getMaxHull() {
		return maxHull;
	}
	public int getWeapon() {
		return wepId;
	}
};
