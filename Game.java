public class Game{
	//constructor
	public Land map;
	public Game(){
		map = new Land(800,600);
	}
	public void init(){
		map.createTank(100,100,0);
		map.createTank(200,300,0);
	}
	public void update(double delta){
	
	}
	public void release(){

	}
};
