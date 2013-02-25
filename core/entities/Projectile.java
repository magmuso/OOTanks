package core.entities;

import core.engine.Land;

public abstract class Projectile extends GameEntity{
	public int damage;
	public double distance;
	public Projectile(double width, double height, int damage, double v, double distance) {
		super(null, 0D, 0D, width, height, 0);
		this.maxVelocity = v;
		this.active = false;
		this.damage = damage;
		this.distance = distance;
	}
	public Projectile(Projectile proj, Land map, double x, double y, double angle){
		super(map, x, y, proj.width, proj.height, 0);
		this.damage = proj.damage;
		this.distance = proj.distance;
		this.active = true;
		this.angle = angle;
		this.v = proj.maxVelocity;
		this.maxVelocity = proj.maxVelocity;
	}
	protected void fly(){
		if (active){
			distance -= v*time;
			if(distance >= 0){
				applyMovement(true);
			} else {
				active = false;
			}
		}
	}
	public void onCollision(){
		
	}
}
