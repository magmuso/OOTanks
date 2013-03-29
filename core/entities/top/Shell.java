package core.entities.top;

import core.entities.Projectile;
import core.entities.Tank;
import core.engine.Land;

public class Shell extends Projectile {
	public Shell(){
		//width, height, damage, maxSpeed
		super(4,2,34,200,500);
	}
	public Shell(Land map, Tank tank){
		super(new Shell(), map, tank);
		setId(11);
	}
	public void update(double delta){
		time = dTime(delta);
		fly();
	}
}
