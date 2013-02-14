public class GameEntity extends Entity {
	public double v_x;
	public double v_y;
	public double maxSpeed;
	//constructor
	public GameEntity(double in_x, double in_y){
		super(in_x,in_y);	
		v_x = 0.0;
		v_y = 0.0;
		maxSpeed = 0.0;
	}
	//updates the object
	public void update(){
		normaliseVelocity();
		move();
	}
	
	//moves object according to the velocity
	private void move(){
		x += v_x;
		y += v_y;
		//implement collision detection here??????
		//
	}
	//this function handles the velocity if it is going beyond scope
	private void normaliseVelocity(){
		double diff = Math.sqrt(v_x*v_x+v_y*v_y)/maxSpeed;
		if (diff > 1){
			v_x = v_x / diff;
			v_y = v_y / diff;
		}
	}
};
