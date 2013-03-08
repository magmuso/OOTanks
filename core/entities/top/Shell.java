package core.entities.top;

import core.entities.GameEntity;
import core.entities.Projectile;
import core.engine.Land;

public class Shell extends Projectile {
	public Shell(){
		//width, height, damage, maxSpeed
		super(4,2,20,200,500);
	}
	public Shell(Land map, double x, double y, double angle){
		super(new Shell(), map, x,y,angle);
		setId(11);
	}
	public void update(double delta){
		time = dTime(delta);
		fly();
	}
	@Override
	public void onCollision(GameEntity ent) {
	}
}
