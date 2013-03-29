package graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import core.entities.top.HumanTank;


public class GUI{

	ArrayList<HumanTank> tanks = new ArrayList<HumanTank>();
	private Sprite[] weps;
	
	public GUI(){ }
	public void init(ArrayList<HumanTank> in_tanks) {
		tanks = in_tanks;
		weps = new Sprite[2];
		weps[0] = new Sprite("/resources/shellIcon.png");
    	weps[1] = new Sprite("/resources/laserIcon.png");
	}
	public void update(Graphics2D g2D) {
		//hull from 0 to 100
		for (HumanTank t : tanks) {
			drawHull(t.getHull(), t.getMaxHull(), g2D, t.getPlayer());
			drawWeapon(t.getWeapon(), g2D, t.getPlayer());
			if (t.getHull() <= 0) drawWinner(g2D, t.getPlayer());
		}
	}
	
	public void drawWinner(Graphics2D g2D, int id) {
		if (id == 1) {
			g2D.setColor(Color.RED);
			g2D.scale(5.0,  5.0);
			g2D.drawString("Player 2 Wins!", 90, 351/5);
			g2D.scale(0.2,  0.2);
		}
		else if (id == 2) {
			g2D.setColor(Color.BLUE);
			g2D.scale(5.0,  5.0);
			g2D.drawString("Player 1 Wins!", 90, 351/5);
			g2D.scale(0.2,  0.2);
		}
	}
	
	public void drawHull(int hull, int maxHull, Graphics2D g2D, int id) {
		float h = (float) hull;
		float m = (float) maxHull;
		int c = 20;
		if (id == 2) c = 1128; 
		g2D.setColor(Color.BLACK);
		g2D.fillRect(c, 30, 100, 5);
		if (h < 0)
			g2D.setColor(new Color(1.0f, 0.0f, 0.0f));
		else if (h/m >= 0.5)
			g2D.setColor(new Color((1.0f - ((h/m)*2-1.0f)), 1.0f, 0.0f));
		else
			g2D.setColor(new Color(1.0f, h/m*2, 0.0f));
		g2D.drawString("HEALTH", c+25, 20);
		g2D.fillRect(c, 30, (int) ((h/m)*100), 5);
	}
	public void drawWeapon(int weapon, Graphics2D g2D, int id) {
		int c = 140;
		if (id == 2) c = 1058;
		g2D.setColor(Color.BLACK);
		g2D.drawString("WEAPON", c, 20);
		g2D.drawRoundRect(c, 25, 50, 50, 10, 10);
		weps[weapon].draw(g2D, c, 25, 0, 0, 0);
	}
};
