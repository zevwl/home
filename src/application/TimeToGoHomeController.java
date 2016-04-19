package application;

import java.awt.Toolkit;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.util.Duration;

public class TimeToGoHomeController 
{
	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Main main;
	
	@FXML
	private void initialize()
	{
		minimizeAndBeep();
	}
	
	public void setMain(Main main)
	{
		this.main = main;
	}
	

	@FXML
	private void handleOk()
	{
		WindowUtil.restoreAll();
		System.exit(0);
	}
	
	@FXML
	private void handleSnooze()
	{
		WindowUtil.minimize();
		WindowUtil.restoreAll();
		new Timeline(new KeyFrame(Duration.minutes(2), ae ->
		{
			minimizeAndBeep();
			main.showStage();
		} )).play();
	}
	
	private void minimizeAndBeep()
	{
		toolkit.beep();
		WindowUtil.minimizeAll();
	}
}
