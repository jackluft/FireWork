import javafx.scene.shape.Circle;
import javafx.scene.paint.*;
import java.util.Random;
public class Particle extends Circle{

	//location of particle
	private double x;
	private double y;
	//default speed of particle
	private final double DEFAULT_SPEED = 5.5;
	private double speed = DEFAULT_SPEED;
	
	//direction of particle movement
	private double directX;
	private double directY;

	//radius of the partile
	private double r = 5;
	//color alpha value for transparent
	private double alpha = 1.0;

	//if the partile is alive= true if not alive =false
	private boolean isAlive;

	public Particle(double x, double y,Color c){
		this.x = x;
		this.y = y;
		this.isAlive = true;
		setAttridutes(c);

	}
	private void setAttridutes(Color c){
		setColor(c);
		setCenterX(this.x);
		setCenterY(this.y);
		setRadius(r);
	}
	private void setColor(Color c){
		double r =  c.getRed(); 
		double g =  c.getGreen();
		double b =  c.getBlue();

		setFill(new Color(r,g,b,alpha));

	}

	public void setVelocity(double vx,double vy){
		this.directX = vx;
		this.directY = vy;

	}
	private void setShrink(){
		//this method will shrink the particle
		r-= 0.05;
		setRadius(r);
		if(r <= 0){
			r = 0;
			this.isAlive = false;

		}
	}
	private void setFade(){
		//this method will fade out the dot
		alpha-= 0.005;
		if(alpha <= 0){
			this.isAlive = false;
			alpha = 0;
		}
		
		setColor((Color)getFill());

	}
	private void setBounds(){
		//this method will set the bounds for the particle
		if(this.x <= 0){
			this.isAlive = false;
		}else if(x >= Frame.getWidth()){
			this.isAlive = false;
		}

		if(this.y <= 0){
			this.isAlive = false;

		}else if(this.y >= Frame.getHeight()){
			this.isAlive = false;

		}
		this.x+=directX;
		this.y+=directY;
	}
	public void move(){
		//this method will set the movement for the particle
		setBounds();
		setFade();
		setShrink();
		
		setCenterX(this.x);
		setCenterY(this.y);
	}
	public boolean isAlive(){
		//this method will return if the particle is alive or not
		return this.isAlive;
	}
}