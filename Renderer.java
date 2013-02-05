import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferStrategy;
import java.awt.event.KeyListener;

public class Renderer extends Canvas{
    private JFrame frame;
    private BufferStrategy buffer;
    private Graphics graphic;

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
    public void init(){
	//load resources here
    }
    public void update(){
	//reset the graphics
	graphic = null;

	// get ready to draw
	graphic = buffer.getDrawGraphics();
	
	//fill background to green (Green for no reason)
	graphic.setColor(Color.GREEN);
	graphic.fillRect(0,0,width,height);

	//drawing will be done here

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
