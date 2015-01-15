package pl.edu.pw.elka.Kalkulator.AppActionQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author x
 *
 */
public class AppActionQueue
{
    private final BlockingQueue<AppAction> queue;
    /**
     * 
     */
    public AppActionQueue()
    {
	queue=new LinkedBlockingQueue<>();
    }
    
    /**
     * @param appaction
     */
    public void put(AppAction appaction)
    {
	try {
	    queue.put(appaction);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
    }
    
    /**
     * 
     */
    public AppAction take()
    {
	try {
	    return queue.take();
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return new CloseAppAction();
	}
    }
}
