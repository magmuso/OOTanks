package core.engine;

import core.entities.GameEntity;
public class Collider{
	private Land map;
	public Collider(Land map){
		this.map = map;
	}
	public boolean update(){
		return outOfBounds();
	}
	//brute force collision detection
	private boolean outOfBounds(){
		for(GameEntity gEnt: map.gameEntities){
			Vector2D tRC = Vector2D.transform(new Vector2D(gEnt.getWidth()/2,gEnt.getHeight()/2),Vector2D.rotationMatrix(gEnt.getAngle()));
			Vector2D tLC = Vector2D.transform(new Vector2D(-gEnt.getWidth()/2,gEnt.getHeight()/2),Vector2D.rotationMatrix(gEnt.getAngle()));
			Vector2D bRC = Vector2D.transform(new Vector2D(gEnt.getWidth()/2,-gEnt.getHeight()/2),Vector2D.rotationMatrix(gEnt.getAngle()));
			Vector2D bLC = Vector2D.transform(new Vector2D(-gEnt.getWidth()/2,-gEnt.getHeight()/2),Vector2D.rotationMatrix(gEnt.getAngle()));
			if (tRC.x+gEnt.getX() < 0) { return true; }
			if (tRC.x+gEnt.getX() > 800) { return true; }
			if (tRC.y+gEnt.getY() < 0) { return true; }
			if (tRC.y+gEnt.getY() > 600) { return true; }
			if (tLC.x+gEnt.getX() < 0) { return true; }
			if (tLC.x+gEnt.getX() > 800) { return true; }
			if (tLC.y+gEnt.getY() < 0) { return true; }
			if (tLC.y+gEnt.getY() > 600) { return true; }
			if (bLC.x+gEnt.getX() < 0) { return true; }
			if (bLC.x+gEnt.getX() > 800) { return true; }
			if (bLC.y+gEnt.getY() < 0) { return true; }
			if (bLC.y+gEnt.getY() > 600) { return true; }
			if (bRC.x+gEnt.getX() < 0) { return true; }
			if (bRC.x+gEnt.getX() > 800) { return true; }
			if (bRC.y+gEnt.getY() < 0) { return true; }
			if (bRC.y+gEnt.getY() > 600) { return true; }
			return false;
		}
		return false;
	}
};
