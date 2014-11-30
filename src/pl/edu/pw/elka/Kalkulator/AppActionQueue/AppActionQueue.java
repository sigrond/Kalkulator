package pl.edu.pw.elka.Kalkulator.AppActionQueue;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AppActionQueue
{
    private final BlockingQueue<AppAction> queue;
    public AppActionQueue()
    {
	queue=new LinkedBlockingQueue<>();
    }
}
