package core.entities;

public class Entity {
	protected double x; //current x coordinate
	protected double y; //current y coordinate

	public Entity(double in_x, double in_y){
		x = in_x;
		y = in_y;
	}
	
	public void teleport(int in_x, int in_y){
		x = in_x;
		y = in_y;
	}
	public double getX() { return x; }
	public double getY() { return y; }
};
