package graphics;

import java.awt.Color;
import java.awt.Graphics2D;


public class GUI{


	int p1hull = 100;
	
	public GUI(){
	}
	
	public void update(Graphics2D g2D){
		//hull from 0 to 100
		if (p1hull > 0){
			p1hull--;
		}
		int p2hull = 100;
		int weapon = 0;
		drawHull1(p1hull, g2D);
		drawHull2(p2hull, g2D);
		drawWeapon(weapon, g2D);
	}
	
	public void drawHull1(int hull, Graphics2D g2D) {
		g2D.setColor(Color.BLACK);
		g2D.fillRect(20, 20, 100, 5);
		if (hull >= 50)
			g2D.setColor(new Color(250-(hull-50)*4, 200, 1));
		else
			g2D.setColor(new Color(250, (hull*4), 0));
		g2D.drawString("HEALTH", 20, 15);
		g2D.fillRect(20, 20, hull, 5);
	}
	public void drawHull2(int hull, Graphics2D g2D) {
		g2D.setColor(Color.BLACK);
		g2D.fillRect(680, 20, 100, 5);
		if (hull >= 50)
			g2D.setColor(new Color(250-(hull-50)*4, 200, 1));
		else
			g2D.setColor(new Color(250, (hull*4), 0));
		g2D.drawString("HEALTH", 680, 15);
		g2D.fillRect(680, 20, hull, 5);
	}
	public void drawWeapon(int weapon, Graphics2D g2D) {
		g2D.setColor(Color.BLACK);
		g2D.drawString("WEAPON", 20, 525);
		g2D.drawRoundRect(20, 530, 50, 50, 10, 10);
	}
};
