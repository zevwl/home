package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import landau.fx.util.ExceptionDialog;


public class Main extends Application
{
	private Stage primaryStage;
	
	@Override
	public void start(Stage stage) 
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("TimeToGoHome.fxml"));
			
			AnchorPane root = (AnchorPane) loader.load();
			
			TimeToGoHomeController controller = loader.getController();
			controller.setMain(this);
			
			Scene scene = new Scene(root);
			
			this.primaryStage = stage;
			stage.setTitle("Time To Go Home");
			stage.getIcons().add(new Image("application/1441915009_Home.png"));
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
			stage.setOnCloseRequest(onClose());
			
		} 
		catch(Exception e) 
		{
			ExceptionDialog.show(e);
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}

	private EventHandler<WindowEvent> onClose()
	{
		EventHandler<WindowEvent> we = new EventHandler<WindowEvent>()
		{
			@Override
			public void handle(WindowEvent event)
			{
				Platform.runLater(new Runnable()
				{
					@Override
					public void run()
					{
						WindowUtil.restoreAll();
						System.exit(0);
					}
				});
			}
		};
		return we;
	}
	
	public void showStage()
	{
		primaryStage.setIconified(false);
	}
	

}
