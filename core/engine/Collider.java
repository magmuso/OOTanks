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
				if (collides(map.gameEntities.get(i),map.gameEntities.get(j))){
					System.out.println("COLLISION" + System.currentTimeMillis());
				}
			}
		}
	}
	public boolean collides(GameEntity rec1, GameEntity rec2){
		//We get relevant corners with 0, 0 as origin
		Vector2D tl1 = new Vector2D(-rec1.getWidth()/2, -rec1.getHeight()/2);
		Vector2D tr1 = new Vector2D(tl1.x + rec1.getWidth(), tl1.y);
		Vector2D br1 = new Vector2D(tl1.x + rec1.getWidth(), tl1.y + rec1.getHeight());

		Vector2D tl2 = new Vector2D(-rec2.getWidth()/2, -rec2.getHeight()/2);
		Vector2D tr2 = new Vector2D(tl2.x + rec2.getWidth(), tl2.y);
		Vector2D bl2 = new Vector2D(tl2.x, tl2.y + rec2.getHeight());
		
		//we rotate the corners and add the coordinates
		tl1 = Vector2D.add(Vector2D.rotate(tl1, rec1.getAngle()),new Vector2D(rec1.getX(),rec1.getY()));
		tr1 = Vector2D.add(Vector2D.rotate(tr1, rec1.getAngle()),new Vector2D(rec1.getX(),rec1.getY()));
		br1 = Vector2D.add(Vector2D.rotate(br1, rec1.getAngle()),new Vector2D(rec1.getX(),rec1.getY()));
		
		tl2 = Vector2D.add(Vector2D.rotate(tl2, rec2.getAngle()),new Vector2D(rec2.getX(),rec2.getY()));
		tr2 = Vector2D.add(Vector2D.rotate(tr2, rec2.getAngle()),new Vector2D(rec2.getX(),rec2.getY()));
		bl2 = Vector2D.add(Vector2D.rotate(bl2, rec2.getAngle()),new Vector2D(rec2.getX(),rec2.getY()));
		
		//calculate the axis
		Vector2D axis1 = Vector2D.sub(tr1, tl1);
		Vector2D axis2 = Vector2D.sub(tr1, br1);
		Vector2D axis3 = Vector2D.sub(tl2, bl2);
		Vector2D axis4 = Vector2D.sub(tl2, tr2);
		
		//proj on axis1
		double max11 = Vector2D.dot(Vector2D.proj(tr1, axis1), axis1);
		double min11 = Vector2D.dot(Vector2D.proj(tl1, axis1), axis1);
		
		double max12 = Vector2D.dot(Vector2D.proj(tr2, axis1), axis1);
		double min12 = Vector2D.dot(Vector2D.proj(tl2, axis1), axis1);
		
		if (max11 < min12 || min11 > max12) {
			//System.out.println("Axis1");
			return false;
		}
		
		//proj on axis2
		max11 = Vector2D.dot(Vector2D.proj(tr1, axis2), axis2);
		min11 = Vector2D.dot(Vector2D.proj(br1, axis2), axis2);
		
		max12 = Vector2D.dot(Vector2D.proj(tl2, axis2), axis2);
		min12 = Vector2D.dot(Vector2D.proj(bl2, axis2), axis2);
		
		if (max11 < min12 || min11 > max12){
			//System.out.println("Axis2");
			return false;
		}
		
		max11 = Vector2D.dot(Vector2D.proj(tr1, axis3), axis3);
		min11 = Vector2D.dot(Vector2D.proj(tl1, axis3), axis3);
		
		max12 = Vector2D.dot(Vector2D.proj(tr2, axis3), axis3);
		min12 = Vector2D.dot(Vector2D.proj(tl2, axis3), axis3);
		
		if (max11 < min12 || min11 > max12){
			//System.out.println("Axis3");
			return false;
		}

		max11 = Vector2D.dot(Vector2D.proj(tr1, axis4), axis4);
		min11 = Vector2D.dot(Vector2D.proj(br1, axis4), axis4);
		
		max12 = Vector2D.dot(Vector2D.proj(tl2, axis4), axis4);
		min12 = Vector2D.dot(Vector2D.proj(bl2, axis4), axis4);
		
		if (max11 < min12 || min11 > max12){
			//System.out.println("Axis4");
			return false;
		}
		//double max11 = Vector2D.dot();
		//check axis 2 with 3 & 4;
		return true;
	}
};
