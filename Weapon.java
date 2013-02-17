public class Weapon extends GameEntity{
	public int damage;
	public boolean active;
	public double distance;
	public long lastLaunch;
	public Weapon(int in_dmg, double in_dist, double in_v){
		super(0, 0, 0.0);
		distance = in_dist;
		lastLaunch = 0;
		damage = in_dmg;
		v = in_v;
		active = false;
	}
	public Weapon(Weapon wep){
		super(wep.x,wep.y,0.0);
		angle = wep.angle;
		distance = wep.distance;
		damage = wep.damage;
		v = wep.v;
		active = wep.active;
	}
	public void launch(double in_angle, double in_x, double in_y){
		lastLaunch = System.currentTimeMillis();
		active  = true;
		angle = in_angle;
		x = in_x;
		y = in_y;
	}
	public void shutDown(){
		active = false;
	}
	public void update(double delta){
		time = dTime(delta);
		applyPhysics();
		distance -= v;
		if (distance < 0){
			active = false;
			//explode??	
		}
	}
};
