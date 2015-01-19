package pl.edu.pw.elka.Kalkulator.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
// import java.util.concurrent.BlockingQueue;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import pl.edu.pw.elka.Kalkulator.AppEventQueue.AppEventQueue;
import pl.edu.pw.elka.Kalkulator.AppEventQueue.CloseAppEvent;
import pl.edu.pw.elka.Kalkulator.AppEventQueue.EventFromView;

/**
 * @author Tomasz Jakubczyk
 */
public class View
{
	/** zdarzenia z view */
	private final AppEventQueue zdarzenia;
	/** ramka widoku */
	private Frame frame;

	/**
	 * konstruktor widoku
	 * 
	 * @param zdarzenia
	 */
	public View(final AppEventQueue zdarzenia)
	{
		this.zdarzenia = zdarzenia;
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		/** zbuduj ramkê w bezpiecznym w¹tku */
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				buildFrame();
			}
		});
	}

	/** zbuduj ramkê */
	private void buildFrame()
	{
		this.frame = new Frame(this);
		this.frame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				closeWindow();
			}
		});
		this.frame.addButtons();
	}

	/** wyœlij zdarzenie zamkniêcia */
	private void closeWindow()
	{
		this.zdarzenia.put(new CloseAppEvent());
	}

	/** zamknij okno */
	public void dispose()
	{
		if(this.frame != null)
		{
			this.frame.dispose();
		}
	}

	/**
	 * @param textToSet
	 *            ustawia napis na wyœwietlaczu
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
	 * 
	 * @param actionIndex
	 */
	public void sendActionToQueue(final int eventIndex)
	{
		this.zdarzenia.put(new EventFromView(eventIndex));
	}
}
