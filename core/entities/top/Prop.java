package core.entities.top;

import core.engine.Land;
import core.entities.GameEntity;

public class Prop extends GameEntity{
	public Prop(Land map, double x, double y, int type){
		super(map, x, y, 0, 0, 1);
		setId(type + 20);
		switch (type){
		case 0:
			//build2
			width = 107;
			height = 110;
			break;
		case 1:
			this.x += 115;
			this.y += 58;
			width = 130;
			height = 66;
			break;
		case 2:
			this.x += 47;
			this.y += 102;
			width = 90;
			height = 104;
			break;
		case 3:
			this.x += 125;
			this.y += 140;
			width = 70;
			height = 100;
			break;
		case 4:
			width = 100;
			height = 50;
			angle = Math.PI/(4.5);
		}
	}

	@Override
	public void onCollision(GameEntity ent) {		
	}

	@Override
	public void update(double time) {
	}
}
