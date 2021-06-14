import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.*;
public class FireWork extends Rectangle{
	private ArrayList<Particle> list = new ArrayList<Particle>();
	//this will be the fireworks location
	private double x;
	private double y;
	//this will be the fireworks stop position, when to explode
	private double yLimit;

	//this will be the firework speed
	private final double speedY = -2.5;
	//value for if exploded or not
	private boolean explode;
	//is true, when the firework has exploded & partiles have been added to screan
	private boolean explodedAdded;

	//the size of the firework
	private final double width = 3;
	private final double height = 25;

	//value for if the firework is alive or not
	private boolean isAlive;


	public FireWork(double x, double y){
		this.x = x;
		this.yLimit = y;
		createFirework();
		setAttridutes();

		

	}
	private void setAttridutes(){
		this.y = Frame.getHeight();
		this.explode = false;
		this.explodedAdded = false;
		this.isAlive = true;
	}
	private Color setFireWorkColor(){
		//this method sets a random color for the firework particles
		Random rand = new Random();
		int limit = 255;
		int r = rand.nextInt(limit);
		int g = rand.nextInt(limit);
		int b = rand.nextInt(limit);
		//create color object
		Color color = Color.rgb(r,g,b);
		return color;


	}
	private void createFirework(){
		//this method set's all the sizes for the firework
		setWidth(width);
		setHeight(height);
		setArcWidth(15);
		setArcHeight(10);
	}

	public void move(){
		//this method controls the movement of the firework
		setBounds();
		this.y+=speedY;
		setY(y);
		setX(x);


	}
	public ArrayList<Particle> getExplosion(){
		//this method returns a list of all the particle, when the firework has exploded
		if(explode == true){
			if(this.explodedAdded == false){
				explode(x,yLimit);
				
			}
			
			return list;
		}else{
			return null;
		}
		
		

	}
	private void explode(double x, double y){
		//this method creates the fireworks & gives them their direction to move
		//the calculations will take place
		Color color = setFireWorkColor();
		for(double i = 0; i < (Math.PI*2); i+=(Math.PI/8)){

			double vx = Math.cos(i);
			double vy = Math.sin(i);
			Particle d = new Particle(x,y,color);
			d.setVelocity(vx,vy);
			list.add(d);


		}
	}
	private void setBounds(){
		//sets the bounds for the firework & when to explode
		if(this.y <= yLimit){
			//explode the fireWork
			explode = true;


		}

	}
	public boolean isAlive(){
		//returns if the firework is alive or not
		if(this.explode == true && list.size() <= 0){
			this.isAlive = false;
		}
		return this.isAlive;
	}
	public boolean getExplodedAdded(){
		//returns explodedAdded vaue
		return this.explodedAdded;
	}
	public void doneExplodedAfter(){
		//this method is called when the particles are added to the screan so they are not added twice
		this.explodedAdded = true;
	}

}