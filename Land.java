import java.util.ArrayList;

public class Land {
<<<<<<< HEAD
	public final int width;
	public final int height;
	
	public ArrayList<Tank> tanks;
	//public ArrayList<Weapon> weapons;	
		
	public Land(int in_w, int in_h){
		width = in_w;
		height = in_h;
		tanks = new ArrayList<Tank>();
	}
	public void createTank(double x, double y, int ctrl){
		tanks.add(new Tank(x, y, ctrl));
	}
=======
    public ArrayList<Tank> tanks;
    public final int width;
    public final int height;
    public Land(int in_w, int in_h){
	width = in_w;
	height = in_h;
	tanks = new ArrayList();
    }
    public void createTank(double x, double y, int ctrl){
	tanks.add(new Tank(x,y,ctrl));
    }
>>>>>>> e44a3a89dff492a4b9a0440365b60d5c89ed58e7
}
