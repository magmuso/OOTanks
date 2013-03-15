package graphics;

/*
 * GameEntity IDs
 * 0-9 tanks
 * 10-19 projectiles
 */
import javax.swing.*;
import java.awt.image.BufferStrategy;
import java.awt.*;
import java.util.ArrayList;

import core.engine.Land;
import core.engine.Input;
import core.entities.GameEntity;
import core.entities.top.HumanTank;

@SuppressWarnings("serial")
public class Renderer extends Canvas{
	private Sprite tank1;
	private Sprite tank2;
	private Sprite background;
    private JFrame frame;
    private BufferStrategy buffer;
    private Graphics g;
    private Graphics2D g2D;
    
    private GUI ui;

    public final int width;
    public final int height;
    //constructor
    public Renderer(Input inp){
		width = 1248;
		height = 783;
		frame = new JFrame("OOTanks");
		ui = new GUI();
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
    /**
     * Draws a tank
     * @param x X centre coordinate of the tank
     * @param y Y centre coordinate of the tank
     * @param angle
     */
    public void drawTank(int x,int y,double angle, int width, int height, int id){
	  	tank1.draw(g2D, x, y, width, height, angle);
    }
    /**
     * Draws a projectile
     * @param x X centre coordinate of the Projectile
     * @param y Y centre coordinate of the Projectile
     * @param angle Angle of the Projectile
     */
    public void drawShell(int x, int y, double angle, int width, int height, int id){
		int d = 8;
		g2D.translate(x,y);
		g2D.rotate(angle);
		
		g2D.setColor(Color.BLACK);
		g2D.fillArc(-d/2, -d/2, d, d, 0, 360);	
		g2D.rotate(-angle);
		g2D.translate(-x,-y);
    }
    /**
     * Initialises the renderer, loads resources.
     */
    public void init(ArrayList<HumanTank> tanks){
	//load resources here
    	ui.init(tanks);
    	tank1 = new Sprite("C:\\Users\\manasb\\Desktop\\JavaWorkspace\\OOTanks\\OOTanks\\resources\\tank1.png");
    	tank2 = new Sprite("C:\\Users\\manasb\\Desktop\\JavaWorkspace\\OOTanks\\OOTanks\\resources\\tank2.png");
    	background = new Sprite("C:\\Users\\manasb\\Desktop\\JavaWorkspace\\OOTanks\\OOTanks\\resources\\terrain2.png");
    }
    
    /**
     * Renders the game each frame
     * @param map map that the objects will be taken from
     */
    public void draw(double x, double y, double width, double height, double angle, int id){
    	if (id  < 10)
    		drawTank((int)x,(int)y,angle,(int)width,(int)height,id);
    	else if (id < 20)
    		drawShell((int)x,(int)y,angle,(int)width,(int)height,id);
    }
    public void update(Land map){
		//reset the graphics
		g = null;
		g2D = null;
	
		// get ready to draw
		g = buffer.getDrawGraphics();
	
		//creating a java 2D graphic object
		g2D = (Graphics2D) g;
	
		//Sets background to terrain
		background.draw(g2D, 0, 0,0,0, 0);
		
		//drawing will be done here
		
		for (GameEntity e : map.gameEntities){
			draw(e.getX(),e.getY(),e.getWidth(),e.getHeight(),e.getAngle(), e.getId());
		}
		
		//end of drawing
		
		ui.update(g2D);
		//syncs everything to smooth java frames
		Toolkit.getDefaultToolkit().sync();
		if(!buffer.contentsLost()){
		    buffer.show();
		} else {
		    System.out.println("Data Lost in buffer");
		}
    }
    /**
     * Releases used resources
     */
    public void release(){

    }
    /**
     * Function for input handler and to sync Canvas 
     * @param inp input handler
     */
    public void setKeyListener(Input inp) {
	addKeyListener(inp);
       	requestFocus();
    }
};
