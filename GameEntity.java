public class GameEntity extends Entity implements Physics{
	public double v;
	public double angle;
	protected double maxSpeed;
	protected final double weight;
	protected final double stopA;

	//useful to prevent passing to everywhere
	protected double time;
	//constructor
	public GameEntity(double in_x, double in_y, double in_w){
		super(in_x,in_y);	
		v = 0;
		angle = 0.0;
		maxSpeed = 10.0;
		weight = in_w;
		stopA = MIU*G;
		time = 0;
	}
	//updates the object
	public void applyPhisics(){
		applyFriction();
		normaliseV();
		move();
	}
	
	//moves object according to the v
	protected void move(){
		x += Math.cos(angle)*v;
		y += Math.sin(angle)*v;
	}
	protected void accelerate(double num){
		v += num*time;
	}
	protected void turn(double num){
		double stopV = stopA*time;
		if (v > stopV*4 || v < -stopV*4) angle += time*num*0.5;
	}
	private void applyFriction(){
		double stopV = stopA*time;

		if (v > stopV) v -= stopV;
		else if (v < -stopV) v+= stopV;
		else v = 0;

	}
	//this function handles the velocity if it is going beyond scope
	private void normaliseV(){
		if (v > maxSpeed) v = maxSpeed;
		else if (v < -maxSpeed) v = -maxSpeed;
	}
	//function to normalize deltatime
	// need to config the constant
	public static double dTime(double time){
		return Math.abs(-time);
	}
};
