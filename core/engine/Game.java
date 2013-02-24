package core.engine;

import core.entities.*;

public class Game{
	//constructor
	public Land map;
	public Game(){
		map = new Land(800,600);
	}
	public void init(){
		createTank(100,100, 100, new Projectile(50,500,300), 8 , 1);
	}
	public void update(Input inp, double delta){
		for(Tank tank: map.tanks){
			tank.update(inp, map, delta);
		}
		int proj_id = 0;
		int proj_rm = map.projectiles.size();
		for(Projectile projectile: map.projectiles){
			if (projectile.isActive()){
				projectile.update(delta);	
			}
			else {
				proj_rm = proj_id;	
			}
			proj_id++;
		}
		if (proj_rm != proj_id && proj_id != 0)
			map.projectiles.remove(proj_rm);
	}
	public void release(){

	}
	private void createTank(double x, double y, int hull, Projectile proj, int in_w, int ctrl){
		map.tanks.add(new Tank(x, y, hull, proj, in_w, ctrl));
	}
};
