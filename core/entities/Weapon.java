package core.entities;

public class Weapon{
	protected int rate;
	protected short proj_num;
	protected Projectile proj;
	private long lastLaunch;
	
	/**
	 * Creates a weapon
	 * @param in_proj image of a projectile
	 * @param in_rate rate of fire in miliseconds
	 */
	public Weapon(Projectile in_proj, int in_rate ){
		rate = in_rate;
		lastLaunch = 0;
		proj = in_proj;
		proj_num = 1;
	}

	/**
	 * Checks if the weapon has reloaded. If yes, creates an array
	 * of Projectiles to be used later in the Game->Land classes.
	 * @param	in_x	X coordinate from where to launch
	 * @param	in_y	Y coordinate from where to launch
	 * @param	angle	Angle in which the projectile is launched
	 * @return			Returns an array of launched projectiles. If weapon is not reloaded yet, returns null.
	 */
	public Projectile[] launch(double in_x, double in_y, double angle){
		Projectile[] result = new Projectile[proj_num];
		if(System.currentTimeMillis() - lastLaunch > rate && proj_num > 0 && proj_num < 4){
			if (proj_num == 1){
				result[0] = new Projectile(proj, in_x+12, in_y, angle);
			} else if (proj_num == 2){
				result[0] = new Projectile(proj, in_x+12, in_y, angle);
				result[1] = new Projectile(proj, in_x+12, in_y, angle);
			} else if (proj_num == 3){
				result[0] = new Projectile(proj, in_x+12, in_y, angle);
				result[1] = new Projectile(proj, in_x+12, in_y, angle);
				result[2] = new Projectile(proj, in_x+12, in_y, angle);
			}
			lastLaunch = System.currentTimeMillis();
			return result;
		} else {
			return null;
		}
	}
};
