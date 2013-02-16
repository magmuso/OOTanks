public class Tank extends GameEntity{
	public final int controller;
	public Tank(double in_x, double in_y, int control){
		super(in_x, in_y, 1.0);

		//we can adjust this later
		maxSpeed = 5.0;
		controller = control;
	}
	//tank fire function
	public void fire() {}
	private void handleInput(Input inp){
		if(controller == 1){
			if (inp.buttons1[0]) accelerate(3.4);
			if (inp.buttons1[1]) accelerate(-3.4);
			if (inp.buttons1[2]) turn(-1);
			if (inp.buttons1[3]) turn(1);
			if (inp.buttons1[4]) fire();
		}
	}
	public void update(Input inp, double delta){
		time = dTime(delta);
		handleInput(inp);
		applyPhisics();
	}
};
