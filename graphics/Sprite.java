package graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Sprite{
	
	private Image pic;

	//CONSTRUCTOR
	public Sprite(String path){
		URL url = this.getClass().getResource(path);
		//System.out.println(url.getPath());
		pic = new ImageIcon(url.getPath()).getImage();
	}
	
	public void draw(Graphics2D g, int x, int y, int width, int height, double angle){
		g.translate(x, y);
		g.rotate(angle);
		//DEBUG FOR COLLISION BOX
		//g.fillRect(-(width)/2, -height/2, width, height);
		//EO DEBUG
		g.drawImage(pic, -(width)/2, -height/2,null);
		g.rotate(-angle);
		g.translate(-x,-y);
		
	}
};
