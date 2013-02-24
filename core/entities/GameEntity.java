package core.entities;

import core.engine.Physics;

abstract class GameEntity extends Entity implements Physics{
	protected double width;
	protected double height;
	
	public double v;
	public double angle;
	protected double maxSpeed;
	protected final int weight;
	protected final double stopA;

	//useful to prevent passing to everywhere
	protected double time;
	//constructor
	public GameEntity(double in_x, double in_y, double in_width, double in_height, int in_w){
		super(in_x,in_y);
		weight = in_w;
		width = in_width;
		height = in_height;
		//set default values
		v = 0;
		angle = 0.0;
		maxSpeed = 1000.0;
		stopA = MIU*G;
		time = 0;
		//EO default values
	}
	//updates the object
	/**
	 * If weight > 0, applies friction and normalises velocity to the maximum
	 * Moves the objects afterwards.
	 */
	protected void applyPhysics(){
		if(weight > 0){
			applyFriction();
			normaliseV();
		}
		move();
	}
	
	/**
	 * Accelerates the entity
	 * @param	num		value of acceleration
	 */
	protected void accelerate(double num){
			v += num-num*weight*0.01;
	}
	
	/**
	 * If entity is not stationary, turns the entity
	 * @param	num		turns by the 'num' amount
	 */
	protected void turn(double num){
		if (v > SLIDE*weight || v < -SLIDE*weight){
			double multiplier = 0.5;
			if (v < 0) multiplier *= -1; 
			angle += time*num*multiplier;
		}
	}
	/**
	 *  Moves the object
	 */
	private void move(){
		x += Math.cos(angle)*v*time;
		y += Math.sin(angle)*v*time;
	}
	/**
	 * Applies friction to the speed of the GameEntity
	 */
	private void applyFriction(){
		if (v > stopA) v -= stopA;
		else if (v < -stopA) v+= stopA;
		else v = 0;

	}

	/**
	 * Normalises the speed not to exceed the maximum. Note: maxSpeed going backwards is divided by two.
	 */
	private void normaliseV(){
		if (v > maxSpeed) v = maxSpeed;
		else if (v < -maxSpeed/2) v = -maxSpeed/2;
	}
	/**
	 * Returns a positive delta time.
	 * @param	time	raw input of delta time
	 * @return	absolute value of delta time
	 */
	public static double dTime(double time){
		return Math.abs(-time);
	}
};
