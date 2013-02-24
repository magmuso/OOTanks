package core.engine;

import java.util.ArrayList;

import core.entities.Tank;
import core.entities.Projectile;

public class Land {
	public final int width;
	public final int height;
	
	/**
	 * List of tanks on the map
	 */
	public ArrayList<Tank> tanks;
	
	/**
	 * List of projectiles on the map
	 */
	public ArrayList<Projectile> projectiles;	
	
	/**
	 * Map constructor
	 * @param in_w width of the map
	 * @param in_h height of the map
	 */
	public Land(int in_w, int in_h){
		width = in_w;
		height = in_h;
		tanks = new ArrayList<Tank>();
		projectiles = new ArrayList<Projectile>();
	}
}
