import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferStrategy;
import java.awt.event.KeyListener;

public class Renderer extends Canvas{
    private JFrame frame;
    private BufferStrategy buffer;
    private Graphics g;
    private Graphics2D g2D;

    public final int width;
    public final int height;
    //constructor
    public Renderer(Input inp){
	width = 800;
	height = 600;
	frame = new JFrame("OOTanks");
	//get content of the frame, determine size
	JPanel panel = (JPanel) frame.getContentPane();
	panel.setPreferredSize(new Dimension(width,height));
	panel.setLayout(null);

	//set up canvas and boundaries, add panel to 'this' canvas
	setBounds(0,0,width,height);
	panel.add(this);

	//we will paint manually, so
	setIgnoreRepaint(true);
	frame.setIgnoreRepaint(true);

	frame.pack();
	frame.setResizable(false);
	frame.setVisible(true);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//creating buffering strategy
	createBufferStrategy(2);
	buffer = getBufferStrategy();
	
	//handle input init. Sadly, we need to you this out of our canvas
	setKeyListener(inp);
    }
    
    //function to draw tank at (x,y) and rotate it by an angle in degrees
    public void drawTank(int x,int y,double angle){
  	int h = 100;
  	int w = 50;
  	g2D.rotate((Math.toRadians(angle)));
 	g2D.setColor(Color.darkGray);
  	g2D.drawRect(x, y, h, w);
  	g2D.fillRect(x, y, h, w);
  	g2D.setColor(Color.red);
  	g2D.drawRect(x+50, y+20, 35, 10);
  	g2D.fillRect(x+50, y+20, 35, 10);
  
    }
    public void init(){
	//load resources here
    }
    public void update(Land map){
	//reset the graphics
	g = null;
	g2D = null;
	
	// get ready to draw
	g = buffer.getDrawGraphics();

	//creating a java 2D graphic object
	g2D = (Graphics2D) g;
	
	//fill background to green (Green for no reason)
	g2D.setColor(Color.GREEN);
	g2D.fillRect(0,0,width,height);

	//drawing will be done here

	for(Tank tank : map.tanks)
		drawTank((int)tank.x,(int)tank.y,tank.angle);
		// drawTank function test: SUCCESS

	// Garbage {
	/* graphic.setColor(Color.blue);

	int thickness = 4;
	//not the most wise thing to do
	for (int i = 0; i <= thickness; i++)
	    graphic.draw3DRect(600 - i, 510 - i, 80 + 2 * i, 30 + 2 * i, true); //use tabbing, especially when not using {}
	
	//same as above
	for (int i = 0; i < thickness; i++)
	    graphic.draw3DRect(600 - i, 550 - i, 80 + 2 * i, 30 + 2 * i, false); //use tabbing, especially when not using {}
	
	int height = 200;
	int width = 120;
	  
       	graphic.setColor(Color.red);
      	graphic.drawRect(10, 10, height, width);

      	graphic.setColor(Color.gray);
      	graphic.fillRect(10, 10, height, width);

      	graphic.setColor(Color.red);
     	graphic.drawOval(250, 250, height, width);

     	graphic.setColor(Color.yellow);
     	graphic.fillOval(250, 250, height, width);
       */ 
	// }
	//end of drawing

	//syncs everything to smooth java frames
	Toolkit.getDefaultToolkit().sync();
	if(!buffer.contentsLost()){
	    buffer.show();
	} else {
	    System.out.println("Data Lost in buffer");
	}
    }
    public void release(){

    }
    //input handler
    public void setKeyListener(Input inp) {
	addKeyListener(inp);
       	requestFocus();
    }
};
