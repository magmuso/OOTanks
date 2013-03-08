package core.entities;

import core.engine.Physics;
import core.engine.Land;

public abstract class GameEntity extends Entity implements Physics{
	protected double width;
	protected double height;
	
	protected double angle;
	protected double v;
	protected double maxVelocity;
	
	protected final int weight;

	//useful to prevent passing to everywhere
	protected double time;
	//constructor
	public GameEntity(Land map, double x, double y, double width, double height, int weight){
		super(map, x, y);
		this.weight = weight;
		this.width = width;
		this.height = height;
		//EO default values
	}
	
	/*
	 * *****************
	 * Protected classes
	 * *****************
	 */
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
	protected void applyMovement(boolean light){
		if(!light){
			applyFriction();
		}
		normaliseV();
		move();
	}
	/*
	 * *****************
	 * Private functions
	 * *****************
	 */
	private void move(){
		x += Math.cos(angle)*v*time;
		y += Math.sin(angle)*v*time;
	}
	/**
	 * Applies friction to the speed of the GameEntity
	 */
	private void applyFriction(){
		if (v > MIU*G) v -= MIU*G;
		else if (v < -MIU*G) v+= MIU*G;
		else v = 0;
	}

	/**
	 * Normalises the speed not to exceed the maximum. Note: maxVelocity going backwards is divided by two.
	 */
	private void normaliseV(){
		if (v > maxVelocity) v = maxVelocity;
		else if (v < -maxVelocity/2) v = -maxVelocity/2;
	}
	/*
	 * ****************
	 * Static functions
	 * ****************
	 */
	/**
	 * Returns a positive delta time.
	 * @param	time	raw input of delta time
	 * @return	absolute value of delta time
	 */
	public static double dTime(double time){
		return Math.abs(-time);
	}
	/*
	 * *************
	 * Get functions
	 * *************
	 */
	public double getAngle(){
		return angle;
	}
	public double getVelocity(){
		return v;
	}
	public double getWidth(){
		return width;
	}
	public double getHeight(){
		return height;
	}
	public double getMaxVelocity(){
		return maxVelocity;
	}
	/*
	 * ******************
	 * Abstract functions
	 * ******************
	 */
	public abstract void onCollision(GameEntity ent);
};
