package graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import core.entities.top.HumanTank;


public class GUI{

	ArrayList<HumanTank> tanks = new ArrayList<HumanTank>();
	
	public GUI(){ }
	public void init(ArrayList<HumanTank> in_tanks){
		tanks = in_tanks;
	}
	public void update(Graphics2D g2D){
		//hull from 0 to 100
		int weapon = 0;
		drawHull(tanks.get(0).getHull(), tanks.get(1).getMaxHull(), g2D, 1);
		drawHull(tanks.get(1).getHull(), tanks.get(1).getMaxHull(), g2D, 2);
		drawWeapon(weapon, g2D);
	}
	
	public void drawHull(int hull, int maxHull, Graphics2D g2D, int id) {
		float h = (float) hull;
		System.out.println(h);
		float m = (float) maxHull;
		int c = 20;
		if (id == 1)
			c = 20;
		else if (id == 2)
			c = 700;
		System.out.println(m);
		g2D.setColor(Color.BLACK);
		g2D.fillRect(c, 20, 100, 5);
		if (h < 0)
			g2D.setColor(new Color(1.0f, 0.0f, 0.0f));
		else if (h/m >= 0.5)
			g2D.setColor(new Color((1.0f - ((h/m)*2-1.0f)), 1.0f, 0.0f));
		else
			g2D.setColor(new Color(1.0f, h/m*2, 0.0f));
		g2D.drawString("HEALTH", 20, 15);
		g2D.fillRect(c, 20, (int) ((h/m)*100), 5);
	}
	public void drawWeapon(int weapon, Graphics2D g2D) {
		g2D.setColor(Color.BLACK);
		g2D.drawString("WEAPON", 20, 525);
		g2D.drawRoundRect(20, 530, 50, 50, 10, 10);
	}
};
