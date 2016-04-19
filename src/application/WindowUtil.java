package application;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import landau.fx.util.ExceptionDialog;

public class WindowUtil
{
	public static void minimizeAll()
	{
		try
		{
			Robot r = new Robot();
			r.setAutoDelay(100);
			r.keyPress(KeyEvent.VK_WINDOWS);
			r.keyPress(KeyEvent.VK_M);
			r.keyRelease(KeyEvent.VK_M);
			r.keyRelease(KeyEvent.VK_WINDOWS);
		} catch (AWTException e)
		{
			e.printStackTrace();
			ExceptionDialog.show(e);
		}
	}
	
	public static void restoreAll()
	{
		try
		{
			Robot r = new Robot();
			r.setAutoDelay(100);
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_WINDOWS);
			r.keyPress(KeyEvent.VK_M);
			r.keyRelease(KeyEvent.VK_M);
			r.keyRelease(KeyEvent.VK_WINDOWS);
			r.keyRelease(KeyEvent.VK_SHIFT);
		} catch (AWTException e)
		{
			e.printStackTrace();
			ExceptionDialog.show(e);
		}
	}
	
	public static void minimize()
	{
		try
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_WINDOWS);
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_WINDOWS);
		} 
		catch (AWTException e)
		{
			e.printStackTrace();
			ExceptionDialog.show(e);
		}
	}
	
	public static void restore()
	{
		try
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_WINDOWS);
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_WINDOWS);
		}
		catch (AWTException e)
		{
			e.printStackTrace();
			ExceptionDialog.show(e);
		}
	}
}
