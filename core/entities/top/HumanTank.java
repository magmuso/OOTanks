package core.entities.top;

import core.engine.Input;
import core.engine.Land;
import core.entities.Tank;
import core.entities.Weapon;

public class HumanTank extends Tank{

	private Input inpHandler;
	private byte controller;
	
	public HumanTank(Land map, Input inpHandler, double x, double y, double angle, int hull, Weapon wep,
			int weight, byte controller) {
		super(map, x, y, angle, hull, wep, weight);
		this.inpHandler = inpHandler;
		this.controller = controller;
		setId(1);
	}
	/**
	 * Handles input
	 * @param inp input hanldler
	 * @param map map to pass to the fire function
	 * @see Input
	 */
	private void handleInput(){
		if(controller > 0){
			if (inpHandler.buttons[controller-1][0]) accelerate(4.5);
			if (inpHandler.buttons[controller-1][1]) accelerate(-4.5);
			if (inpHandler.buttons[controller-1][2]) setTurn(-1);
			else if (inpHandler.buttons[controller-1][3]) setTurn(1);
			else setTurn(0);
			if (inpHandler.buttons[controller-1][4]) fire();
			if (inpHandler.buttons[controller-1][5]) setWeapon(0);
			if (inpHandler.buttons[controller-1][6]) setWeapon(1);
			
		}
	}
	/**
	 * Updates the tank object
	 * @param inp input handler
	 * @param map Land where the tank is
	 * @param delta delta time for movement
	 */
	public void update(double delta){
		time = dTime(delta);
		handleInput();
		applyMovement();
	}
	public int getPlayer() {
		return (int) controller;
	}
	public int getId(){
		return getPlayer();
	}
}
