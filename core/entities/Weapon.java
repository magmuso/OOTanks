package core.entities;

import core.engine.Land;

public abstract class Weapon{
	protected int rate;
	protected Projectile proj; //image of a projectile
	protected long lastLaunch;
	public Weapon(Projectile proj, int rate ){
		this.proj = proj;
		this.rate = rate;
		this.lastLaunch = 0;
	}
	public abstract void fire(Land map, Tank tank);
};
