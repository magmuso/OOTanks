package core.entities;

import core.engine.Physics;

abstract class GameEntity extends Entity implements Physics{
	public double v;
	public double angle;
	protected double maxSpeed;
	protected final int weight;
	protected final double stopA;

	//useful to prevent passing to everywhere
	protected double time;
	//constructor
	public GameEntity(double in_x, double in_y, int in_w){
		super(in_x,in_y);
		weight = in_w;
		
		//set default values
		v = 0;
		angle = 0.0;
		maxSpeed = 1000.0;
		stopA = MIU*G;
		time = 0;
		//EO default values
	}
	//updates the object
	protected void applyPhysics(){
		if(weight > 0){
			applyFriction();
			normaliseV();
		}
		move();
	}
	
	//moves object according to the v
	protected void move(){
		x += Math.cos(angle)*v*time;
		y += Math.sin(angle)*v*time;
	}
	protected void accelerate(double num){
			v += num-num*weight*0.01;
	}
	protected void turn(double num){
		if (v > SLIDE*weight || v < -SLIDE*weight){
			double multiplier = 0.5;
			if (v < 0) multiplier *= -1; 
			angle += time*num*multiplier;
		}
	}
	private void applyFriction(){
		if (v > stopA) v -= stopA;
		else if (v < -stopA) v+= stopA;
		else v = 0;

	}
	//this function handles the velocity if it is going beyond scope
	private void normaliseV(){
		if (v > maxSpeed) v = maxSpeed;
		else if (v < -maxSpeed/2) v = -maxSpeed/2;
	}
	//function to normalize deltatime
	// need to config the constant
	public static double dTime(double time){
		return Math.abs(-time);
	}
};
