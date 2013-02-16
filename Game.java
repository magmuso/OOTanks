public class Game{
	//constructor
	public Land map;
	public Game(){
		map = new Land(800,600);
	}
	public void init(){
		createTank(100,100,1);
	}
	public void update(Input inp, double delta){
		for(Tank tank: map.tanks){
			tank.update(inp, delta);
		}
	}
	public void release(){

	}
	private void createTank(double x, double y, int ctrl){
		map.tanks.add(new Tank(x, y, ctrl));
	}
};
