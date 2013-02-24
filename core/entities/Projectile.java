package core.entities;

public class Projectile extends GameEntity{
	public int damage;
	private boolean active;
	public double distance;
	/**
	 * Constructor to be used to create an instance of projectile
	 * @param proj image of projectile
	 * @param in_x x coordinate to instantiate
	 * @param in_y y coordinate to instantiate
	 * @param in_angle angle to instantiate
	 */
	public Projectile(Projectile proj, double in_x, double in_y, double in_angle){
		super(in_x,in_y, proj.width, proj.height, proj.weight);
		active = true;
		damage = proj.damage;
		distance = proj.distance;
		angle = in_angle;
		v = proj.v;
	}
	/**
	 * Crates an image of a projectile later to instantiate
	 * @param width width of the projectile
	 * @param height height of the projectile
	 * @param in_dmg damage dealt by the projectile on hit
	 * @param in_dist maximum distance of the projectile
	 * @param in_v constant speed of the projectile
	 */
	public Projectile(double width, double height, int in_dmg, double in_dist, double in_v){
		super(0.0, 0.0, width, height, 0);
		active = false;
		distance = in_dist;
		damage = in_dmg;
		v = in_v;

		//DEBUG
		width=5;
		height=3;
		//
	}
	/**
	 * Moves the projectile 
	 * @param delta takes delta time as an argument as any updateable entity
	 */
	public void update(double delta){
		time = dTime(delta);
		distance -= v*time;
		applyPhysics();
		if(distance <= 0) active=false;
	}
	/**
	 * Returns if a projectile is active
	 * @return
	 */
	public boolean isActive(){
		return active;
	}
}
