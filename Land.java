import java.util.ArrayList;

public class Land {
	public final int width;
	public final int height;
	
	public ArrayList<Tank> tanks;
	public ArrayList<Weapon> weapons;	
		
	public Land(int in_w, int in_h){
		width = in_w;
		height = in_h;
		tanks = new ArrayList<Tank>();
		weapons = new ArrayList<Weapon>();
	}
}
