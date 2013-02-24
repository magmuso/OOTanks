package core.entities;

public class Weapon{
	protected int rate;
	protected short proj_num;
	protected Projectile proj;
	private long lastLaunch;
	
	public Weapon(Projectile in_proj, int in_rate ){
		rate = in_rate;
		lastLaunch = 0;
		proj = in_proj;
		proj_num = 1;
	}
	
	public Projectile[] launch(double in_x, double in_y, double angle){
		Projectile[] result = new Projectile[proj_num];
		if(System.currentTimeMillis() - lastLaunch > rate && proj_num > 0 && proj_num < 4){
			if (proj_num == 1){
				result[0] = new Projectile(proj, in_x, in_y, angle);
			} else if (proj_num == 2){
				result[0] = new Projectile(proj, in_x, in_y, angle);
				result[1] = new Projectile(proj, in_x, in_y, angle);
			} else if (proj_num == 3){
				result[0] = new Projectile(proj, in_x, in_y, angle);
				result[1] = new Projectile(proj, in_x, in_y, angle);
				result[2] = new Projectile(proj, in_x, in_y, angle);
			}
			lastLaunch = System.currentTimeMillis();
			return result;
		} else {
			return null;
		}
	}
};
