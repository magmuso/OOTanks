public class GameEntity extends Entity{
	public double v_x;
	public double v_y;
	public double maxSpeed;
	public double angle;
	//constructor
	public GameEntity(double in_x, double in_y){
		super(in_x,in_y);	
		v_x = 0.0;
		v_y = 0.0;
		angle = 0.0;
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
		countAngle();
		//implement collision detection here??????
		//
	}
	private void countAngle(){
	/*
	//trying to figure out math here blarghghgh
		double result;	
		if(v_x < 0){
			if (v_x > -0.001) {
				if (v_y < 0) result = Math.pi;
				else result = -Math.pi;
			} else result = atan(v_y/v_x) + Math.pi;
		} else {
			if(v_x < 0.001) {
				if (v_y < 0)result = -Math.pi/2.0;
				else result = Math.pi/2.0;
			} else result = atain(v_y/v_x);
		}
		//check the result if it is not completely different from what it was before
		
		//
		*/
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
