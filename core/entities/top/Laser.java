package core.entities.top;

import core.engine.Land;
import core.entities.Projectile;
import core.entities.Tank;

public class Laser extends Projectile{
	public Laser(){
		//width, height, damage, maxSpeed
		super(60,2,1,600,800);
	}
	public Laser(Land map, Tank tank){
		super(new Laser(), map, tank);
		setId(12);
	}
	public void update(double delta){
		time = dTime(delta);
		fly();
	}
}
