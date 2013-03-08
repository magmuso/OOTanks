package core.engine;

import core.entities.GameEntity;
public class Collider{
	private Land map;
	public Collider(Land map){
		this.map = map;
	}
	public void update(){
		for (int i = 0; i < map.gameEntities.size(); i++){
			GameEntity ent1 = map.gameEntities.get(i);
			for(int j = i+1 ; j< map.gameEntities.size();j++){
				GameEntity ent2 = map.gameEntities.get(j);
				if (collides(ent1,ent2)){
					ent1.onCollision(ent2);
					ent2.onCollision(ent1);
				}
			}
			if(outOfBounds(ent1)){
				ent1.onCollision(null);
			}
		}
	}
	private boolean collides(GameEntity rec1, GameEntity rec2){
		Vector2D[][] corners= new Vector2D[2][4];
		corners[0] = getCorners(rec1);
		corners[1] = getCorners(rec2);
		Vector2D displacement = Vector2D.sub(new Vector2D(rec2.getX(),rec2.getY()),new Vector2D(rec1.getX(), rec1.getY()));
		double angleDiff = rec2.getAngle()-rec1.getAngle();
		for(int i = 0; i < corners[1].length; i++){
			corners[1][i] = Vector2D.add(Vector2D.rotate(corners[1][i], angleDiff),displacement);
		}
		Vector2D axes[] = new Vector2D[4];
		axes[0] = new Vector2D(1,0);
		axes[1] = new Vector2D(0,1);
		axes[2] = Vector2D.sub(corners[1][1], corners[1][0]);
		axes[3] = Vector2D.sub(corners[1][1], corners[1][2]);
		double proj, min0, max0, min1, max1;
		for(int axis = 0; axis < 4; axis++){
			min0 = Vector2D.dot(Vector2D.proj(corners[0][0], axes[axis]), axes[axis]);
			max0 = Vector2D.dot(Vector2D.proj(corners[0][0], axes[axis]), axes[axis]);
			for(int i = 1; i < 4; i++){
				proj = Vector2D.dot(Vector2D.proj(corners[0][i], axes[axis]), axes[axis]);
				if (proj < min0) min0 = proj;
				else if (proj > max0) max0 = proj;
			}
			min1 = Vector2D.dot(Vector2D.proj(corners[1][0], axes[axis]), axes[axis]);
			max1 = Vector2D.dot(Vector2D.proj(corners[1][0], axes[axis]), axes[axis]);
			for(int i = 1; i < 4; i++){
				proj = Vector2D.dot(Vector2D.proj(corners[1][i], axes[axis]), axes[axis]);
				if (proj < min1) min1 = proj;
				else if (proj > max1) max1 = proj;
			}
			if (max0 < min1 || max1  < min0){
				return false;
			}
		}
		return true;
	}
	private boolean outOfBounds(GameEntity ent){
		Vector2D[] corners = getCorners(ent);
		Vector2D displ = new Vector2D(ent.getX(),ent.getY());
		for(int i = 0; i < corners.length; i++){
			corners[i] = Vector2D.add(Vector2D.rotate(corners[i], ent.getAngle()),displ);
		}
		double minX = corners[0].x;
		double maxX = corners[0].x;
		double minY = corners[0].y;
		double maxY = corners[0].y;
		for(int i = 1; i < 4; i++){
			if (corners[i].x < minX) minX = corners[i].x;
			else if (corners[i].x > maxX) maxX = corners[i].x;
			if (corners[i].y < minY) minY = corners[i].y;
			else if (corners[i].y > maxY) maxY = corners[i].y;
		}
		if (minX < 0 || maxX > map.width || minY < 0 || maxY > map.height) return true;
		else return false;
	}
	private Vector2D[] getCorners(GameEntity rec){
		Vector2D[] result = new Vector2D[4];
		result[0] = new Vector2D(-rec.getWidth()/2, -rec.getHeight()/2);
		result[1] = new Vector2D(result[0].x + rec.getWidth(), result[0].y);
		result[2]= new Vector2D(result[0].x + rec.getWidth(), result[0].y + rec.getHeight());
		result[3]= new Vector2D(result[0].x, result[0].y + rec.getHeight());
		return result;
	}
};
