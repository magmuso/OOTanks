public class Entity {
    protected double x; //current x coordinate
    protected double y; //current y coordinate
    public double v_x; //velocity of x
    public double v_y; //velocity of y

    public Entity(double in_x, double in_y){
	x = in_x;
	y = in_y;
	v_x = 0.0;
	v_y = 0.0;
    }
    public void teleport(int in_x, int in_y){
	x = in_x;
	y = in_y;
    }
};