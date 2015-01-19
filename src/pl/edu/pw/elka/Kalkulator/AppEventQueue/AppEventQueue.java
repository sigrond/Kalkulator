package pl.edu.pw.elka.Kalkulator.AppEventQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Tomasz Jakubczyk
 *         kolejka zdarzeñ
 */
public class AppEventQueue
{
	/** kolejka */
	private final BlockingQueue<AppEvent> queue;

	/** konstruktor kolejki */
	public AppEventQueue()
	{
		queue = new LinkedBlockingQueue<>();
	}

	/**
	 * @param appaEvent
	 *            nowe zdarzenie do kolejki
	 */
	public void put(AppEvent appEvent)
	{
		try
		{
			queue.put(appEvent);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/** zdejmij zdarzenie z kolejki */
	public AppEvent take()
	{
		try
		{
			return queue.take();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
			return new CloseAppEvent();
		}
	}
}
