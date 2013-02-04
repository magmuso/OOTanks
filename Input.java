import java.awt.event.KeyListener;

public class Input{
    //constructor
    public Input(Renderer render){
	//render.addKeyListener(this);
    }
    public void init(){

    }
    public void update(){

    }
    public void release(){

    }
    public void initKeyListener(Renderer render, KeyListener keyInputHandler){
	//Lewis look here, we are adding input handler to our canvas
	//add key to class which handles input
	render.addKeyListener(keyInputHandler);

	//then we tell our canvas to focus and be always prepared for input
	render.requestFocus();
    }
};
