package core.entities;

import core.engine.Land;

public abstract class Tank extends GameEntity{
	protected Weapon wep;
	protected int hull;
	protected int maxHull;
	public Tank(Land map, double x, double y, double angle, int hull, Weapon wep, int weight){
		super(map, x, y, 80, 60, weight);
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
	@Override
	public void onCollision(GameEntity ent){
		cancelMove();
		if (ent != null){
			if (ent.getWeight() > 0){
				if (weight * v > 200){
					v = -v/2;
				} else {
					v = 0;
				}
			}
		} else {
			if (weight * v > 200){
				v = -v/2;
			} else {
				v = 0;
			}
		}
	}
	public void takeDamage(int dmg){
		hull -= dmg;
		System.out.println("Took " + dmg + " damage ");
	}
	public int getHull() {
		return hull;
	}
	public int getMaxHull() {
		return maxHull;
	}
};
