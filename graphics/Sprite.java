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
	
	public void draw(Graphics2D g, int x, int y,double angle){
		g.translate(x, y);
		g.rotate(angle);
		g.drawImage(pic, x, y,null);
		g.rotate(-angle);
		g.translate(-x,-y);
		
	}
};
