package core.entities.top;

import core.engine.Land;
import core.entities.Tank;
import core.entities.Weapon;
import core.entities.top.Laser;

public class LaserCannon extends Weapon{
	public LaserCannon(){
		super(new Laser(),10);
	}
	public void fire(Land map, Tank tank) {
		if (System.currentTimeMillis()-lastLaunch > rate){
			lastLaunch = System.currentTimeMillis();
			map.gameEntities.add(new Laser(map,tank));
		}
	}
}
