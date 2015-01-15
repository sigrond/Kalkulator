package pl.edu.pw.elka.Kalkulator.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.util.concurrent.BlockingQueue;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import pl.edu.pw.elka.Kalkulator.AppActionQueue.*;

/**
 * @author x
 *
 */
public class View
{
    //private final AppActionQueue polecenia;//polecenia do view
    private final AppActionQueue zdarzenia;//zdarzenia z view
    
    private Frame frame;
    
    /**
     * @param polecenia
     * @param zdarzenia
     */
    public View(final AppActionQueue polecenia, final AppActionQueue zdarzenia)
    {
	//this.polecenia=polecenia;
	this.zdarzenia=zdarzenia;
	
	try
	{
	    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (Exception e)
	{
	    
	}
	// zbuduj ramkê w bezpiecznym w¹tku
	SwingUtilities.invokeLater(new Runnable()
	{
	    @Override
	    public void run()
	    {
		buildFrame();
	    }
	});
    }
    private void buildFrame()
    {
	frame = new Frame(this);
	frame.addWindowListener(new WindowAdapter()
	{
	    @Override
	    public void windowClosing(WindowEvent e)
	    {
		closeWindow();
	    }
	});
	//frame.setIconImage(Resources.getAppIcon());
	frame.addButtons();
    }
    
    /**
     * 
     */
    private void closeWindow()
    {
	zdarzenia.put(new CloseAppAction());
    }
    
    /**
     * 
     */
    public void dispose()
    {
	if (frame != null)
	{
	    frame.dispose();
	}
    }
    
    /**
     * @param textToSet
     */
    public void setLog(final String textToSet)
    {
	SwingUtilities.invokeLater(new Runnable()
	{
	    @Override
	    public void run()
	    {
		frame.setLog(textToSet);
	    }
	});
    }
    
    /**
     * informacja do kontrolera
     * @param actionIndex
     */
    public void sendActionToQueue(final int actionIndex)
    {
	zdarzenia.put(new ActionFromView(actionIndex));
    }
}
