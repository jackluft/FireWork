import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane; 
import javafx.animation.AnimationTimer;
import java.lang.Math;
import java.util.ArrayList;
public class Frame extends AnimationTimer{
	//a list of all the fireworks
	private ArrayList<FireWork> list;
	//the size of the screan
	private static final double HEIGHT = 550;
	private static final double WIDTH = 500;
	//the stage of the program
	private Stage stage;
	//the layout of the program
	private AnchorPane pane;
	//the scene of the program
	private Scene scene;

	public Frame(Stage stage){
		this.stage = stage;
		setAttridutes();
		start();
		stage.show();

	}
	private void setAttridutes(){
		list = new ArrayList<FireWork>();
		createStage();

	}
	private void createStage(){
		//setting all the stages attridutes
		stage.setWidth(WIDTH);
		stage.setHeight(HEIGHT);
		stage.setResizable(false);
		createLayout();
		stage.setScene(scene);

	}
	private void gameEngine(){
		//the gameEngine that is called from the timer
		for(int i = 0; i < list.size(); i++){
			FireWork fire = list.get(i);
			fire.move();
			explodeFireWork(fire);
			moveFireWorkParticles(fire);
			checkIfFireWorkAlive(fire);
			
			

		}
		
	}
	private void explodeFireWork(FireWork fire){
		//this method see's if the firework has exploded or not & if add the particles to the screan
		ArrayList<Particle> spots;
		spots = fire.getExplosion();
		if(spots != null){
			if(fire.getExplodedAdded() == false){
				for(int i =0; i< spots.size(); i++){
					Particle d = spots.get(i);
					addParticle(d);

				}
				fire.doneExplodedAfter();
				pane.getChildren().remove(fire);

			}

		}

	}
	private void moveFireWorkParticles(FireWork fire){
		//this method see's if firework has exploded & if so, move the particles & check if it is alive or not
		//if particle is not alive remove the particle
		ArrayList<Particle> spots;
		spots = fire.getExplosion();
		if(spots != null){
			if(fire.getExplodedAdded() == true){
				//move or remove particle
				for(int i = 0; i < spots.size(); i++){
					Particle d = spots.get(i);
					d.move();
					if(d.isAlive() == false){
						//remove particle
						spots.remove(d);
						removeParticle(d);

					}
				}

			}


		}

	}
	
	private void checkIfFireWorkAlive(FireWork fire){
		//this method checks and sees if the firework is alive or not
		if(fire.isAlive() == false){
			
			list.remove(fire);


		}

	}
	private void createLayout(){
		//this method creates the layout & scene
		//& addes a event listener to the layout
		pane = new AnchorPane();
		pane.setOnMouseClicked(e->{
			addFireWork(e.getX(),e.getY());
		});
		scene = new Scene(pane);

	}
	private void addFireWork(double x, double y){
		//this method is called when the user clicks on the screan to shoot the firework
		shoot(x,y);
	}
	public void shoot(double x, double y){
		//this method create the firework and adds it to the screan & list
		FireWork fire = new FireWork(x,y);
		addFireWork(fire);
	}
	
	private void addParticle(Particle d){
		//this method add's the particle to the screan
		pane.getChildren().add(d);

	}
	private void addFireWork(FireWork fire){
		//this method add's the firework to the list & screan
		list.add(fire);
		pane.getChildren().add(fire);

	}
	private void removeFireWork(FireWork d){
		//this method removes the firework from the list & screan
		list.remove(d);
		pane.getChildren().remove(d);

	}
	private void removeParticle(Particle d){
		//this method removes the partilce from the screan
		pane.getChildren().remove(d);

	}
	public static double getHeight(){
		//this method returns the height of the screan
		return HEIGHT;
	}
	public static double getWidth(){
		//this method returns the width of the screan
		return WIDTH;
	}
	@Override
    public void handle(long now) {
    	//this method is the timer method

    	gameEngine();
    }
}