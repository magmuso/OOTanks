package core.engine;

import core.entities.Tank;
import core.entities.Weapon;

public class Game{
	//constructor
	public Land map;
	public Game(){
		map = new Land(800,600);
	}
	public void init(){
		createTank(100,100, 100,1);
	}
	public void update(Input inp, double delta){
		for(Tank tank: map.tanks){
			tank.update(inp, map, delta);
		}
		int wep_id = 0;
		int wep_rm = map.weapons.size();
		for(Weapon weapon: map.weapons){
			if (weapon.active){
				weapon.update(delta);	
			}
			else {
				wep_rm = wep_id;	
			}
			wep_id++;
		}
		if (wep_rm != wep_id && wep_id != 0)
			map.weapons.remove(wep_rm);
	}
	public void release(){

	}
	private void createTank(double x, double y, int hull, int ctrl){
		map.tanks.add(new Tank(x, y, hull, ctrl));
	}
};
