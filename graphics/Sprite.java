package graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Sprite{
	
	private Image pic;

	//CONSTRUCTOR
	public Sprite(String path){
		pic = new ImageIcon(path).getImage();
	}
	
	public void draw(Graphics2D g, int x, int y, int width, int height, double angle){
		g.translate(x, y);
		g.rotate(angle);
		//DEBUG FOR COLLISION BOX
		g.fillRect(-(width)/2, -height/2, width, height);
		//EO DEBUG
		g.drawImage(pic, -(width)/2, -height/2,null);
		g.rotate(-angle);
		g.translate(-x,-y);
		
	}
};
