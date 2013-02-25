package core.entities;

import core.engine.Land;

public abstract class Entity {
	protected double x; //current x coordinate
	protected double y; //current y coordinate
	protected Land map;
	protected boolean active;
	private int id;
	public Entity(Land map, double x, double y){
		this.map = map;
		this.x = x;
		this.y = y;
		this.active = true;
	}
/*
	public void teleport(int in_x, int in_y){
		x = in_x;
		y = in_y;
	}
*/
	/**
	 * @return x value of entity
	 */
	public double getX() { return x; }
	
	/**
	 * @return y value of entity
	 */
	public double getY() { return y; }
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public boolean getActive(){
		return active;
	}
	public abstract void update(double time);
};
