package core.engine;

import java.util.ArrayList;

import core.entities.GameEntity;

public class Land {
	public final int width;
	public final int height;
	
	public ArrayList<GameEntity> gameEntities;
	
	/**
	 * Map constructor
	 * @param in_w width of the map
	 * @param in_h height of the map
	 */
	public Land(int in_w, int in_h){
		width = in_w;
		height = in_h;
		gameEntities = new ArrayList<GameEntity>();
	}
}
