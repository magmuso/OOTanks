package core.entities;

import core.engine.Land;

public abstract class Projectile extends GameEntity{
	public int damage;
	public double distance;
	public Tank tank;
	public Projectile(double width, double height, int damage, double v, double distance) {
		super(null, 0D, 0D, width, height, 0);
		this.maxVelocity = v;
		this.active = false;
		this.damage = damage;
		this.distance = distance;
	}
	public Projectile(Projectile proj, Land map, Tank tank){
		super(map, tank.getX()+(tank.getWidth()+4)/2*Math.cos(tank.getAngle()), tank.getY()+(tank.getWidth()+4)/2*Math.sin(tank.getAngle()), proj.width, proj.height, 0);
		this.damage = proj.damage;
		this.distance = proj.distance;
		this.active = true;
		this.angle = tank.getAngle();
		this.v = proj.maxVelocity;
		this.maxVelocity = proj.maxVelocity;
		this.tank = tank;
	}
	protected void fly(){
		if (active){
			distance -= v*time;
			if(distance >= 0){
				applyMovement();
			} else {
				active = false;
			}
		}
	}
	public void onCollision(GameEntity ent){
		if (ent != null){
			if (ent.getId() > 9 && ent.getId() < 20){
				return;
			} else if (ent != (GameEntity)tank) {
				active = false;
			}
		} else {
			active = false;
		}
		if (ent != null && !active){
			if (ent.getId() < 10){
				((Tank)ent).takeDamage(damage);
			}
		}
	}
}
