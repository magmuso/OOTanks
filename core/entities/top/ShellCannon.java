package core.entities.top;

import core.engine.Land;
import core.entities.Tank;
import core.entities.Weapon;
import core.entities.top.Shell;

public class ShellCannon extends Weapon{
	public ShellCannon(){
		super(new Shell(),500);
	}
	public void fire(Land map, Tank tank) {
		if (System.currentTimeMillis()-lastLaunch > rate){
			lastLaunch = System.currentTimeMillis();
			map.gameEntities.add(new Shell(map,tank));
		}
	}
}
