public class Tank extends GameEntity{
	public final int controller;
	public Tank(double in_x, double in_y, int control){
		super(in_x, in_y);

		//we can adjust this later
		maxSpeed = 5.0;
		controller = control;
	}
	//tank fire function
	public void fire() {}
};
