public class Tank extends GameEntity{
	private final int controller;
	private Weapon wep;
	public int hull;
	public Tank(double in_x, double in_y, int in_hull, int control){
		super(in_x, in_y, 1.0);
		wep = new Weapon(200, 600, 25);
		//we can adjust this later
		hull = in_hull;
		maxSpeed = 10.0;
		controller = control;
	}
	//tank fire function
	private void fire(Land map) {
		if (wep.lastLaunch - System.currentTimeMillis() < -1000){
			wep.launch(angle, x+30*Math.cos(angle), y+12*Math.sin(angle));
			map.weapons.add(new Weapon(wep));
			wep.shutDown();
		}
	}
	private void handleInput(Input inp, Land map){
		if(controller == 1){
			if (inp.buttons1[0]) accelerate(3.4);
			if (inp.buttons1[1]) accelerate(-3.4);
			if (inp.buttons1[2]) turn(-1);
			if (inp.buttons1[3]) turn(1);
			if (inp.buttons1[4]) fire(map);
		}
	}
	public void update(Input inp, Land map, double delta){
		time = dTime(delta);
		handleInput(inp, map);
		applyPhysics();
	}
};
