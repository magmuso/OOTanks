package core.entities;

public class Projectile extends GameEntity{
	public int damage;
	private boolean active;
	public double distance;
	public Projectile(Projectile proj, double in_x, double in_y, double in_angle){
		super(in_x,in_y,proj.weight);
		active = true;
		damage = proj.damage;
		distance = proj.distance;
		angle = in_angle;
		v = proj.v;
	}
	public Projectile(int in_dmg, double in_dist, double in_v){
		super(0.0, 0.0, 0);
		active = false;
		distance = in_dist;
		damage = in_dmg;
		v = in_v;

		//DEBUG
		width=5;
		height=3;
		//
	}
	
	public void update(double delta){
		time = dTime(delta);
		distance -= v*time;
		applyPhysics();
		if(distance <= 0) active=false;
	}
	public boolean isActive(){
		return active;
	}
}
