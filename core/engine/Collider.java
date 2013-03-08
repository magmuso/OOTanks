package core.engine;

import core.entities.GameEntity;
public class Collider{
	private Land map;
	public Collider(Land map){
		this.map = map;
	}
	public void update(){
		for (int i = 0; i < map.gameEntities.size()-1; i++){
			for(int j = i+1 ; j< map.gameEntities.size();j++){
				GameEntity ent1 = map.gameEntities.get(i);
				GameEntity ent2 = map.gameEntities.get(j);
				if (collides(ent1,ent2)){
					ent1.onCollision(ent2);
					ent2.onCollision(ent1);
				}
			}
		}
	}
	public boolean collides(GameEntity rec1, GameEntity rec2){
		Vector2D corners[][] = new Vector2D[2][4];
		corners[0][0] = new Vector2D(-rec1.getWidth()/2, -rec1.getHeight()/2);
		corners[0][1] = new Vector2D(corners[0][0].x + rec1.getWidth(), corners[0][0].y);
		corners[0][2]= new Vector2D(corners[0][0].x + rec1.getWidth(), corners[0][0].y + rec1.getHeight());
		corners[0][3]= new Vector2D(corners[0][0].x, corners[0][0].y + rec1.getHeight());
		
		corners[1][0] = new Vector2D(-rec2.getWidth()/2, -rec2.getHeight()/2);
		corners[1][1] = new Vector2D(corners[1][0].x + rec2.getWidth(), corners[1][0].y);
		corners[1][2]= new Vector2D(corners[1][0].x + rec2.getWidth(), corners[1][0].y + rec2.getHeight());
		corners[1][3]= new Vector2D(corners[1][0].x, corners[1][0].y + rec2.getHeight());
		
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
};
