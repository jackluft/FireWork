/*
	Jack Luft
	June 13, 2021



*/
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.application.Application;
public class Window extends Application{
	Frame frame;

	public void start(Stage stage) throws Exception{
		frame = new Frame(stage);


	}
	public static void main(String[] args){
		launch(args);

	}


}