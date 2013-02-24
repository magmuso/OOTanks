package core.engine;

import java.util.ArrayList;

import core.entities.Tank;
import core.entities.Projectile;

public class Land {
	public final int width;
	public final int height;
	
	public ArrayList<Tank> tanks;
	public ArrayList<Projectile> projectiles;	
		
	public Land(int in_w, int in_h){
		width = in_w;
		height = in_h;
		tanks = new ArrayList<Tank>();
		projectiles = new ArrayList<Projectile>();
	}
}
