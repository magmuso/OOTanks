package core.entities;

abstract class Entity {
	protected double x; //current x coordinate
	protected double y; //current y coordinate
	
	protected double width;
	protected double height;

	public Entity(double in_x, double in_y){
		x = in_x;
		y = in_y;
		width = 0;
		height = 0;
	}
/*
	public void teleport(int in_x, int in_y){
		x = in_x;
		y = in_y;
	}
*/
	public double getX() { return x; }
	public double getY() { return y; }
};
