package pl.edu.pw.elka.Kalkulator.Controller;

import java.util.AbstractMap;
import java.util.HashMap;

import pl.edu.pw.elka.Kalkulator.AppActionQueue.*;
import pl.edu.pw.elka.Kalkulator.Model.*;
import pl.edu.pw.elka.Kalkulator.View.*;

/**
 * @author x
 *
 */
public class Controller
{
    private final View view;
    private final AppActionQueue polecenia;//polecenia do view
    private final AppActionQueue zdarzenia;//zdarzenia z view
    private final Model model;
    private boolean alive;
    private final AbstractMap<Class<? extends AppAction>, Strategy> strategyMap;
    
    /**
     * 
     */
    public Controller()
    {
	polecenia=new AppActionQueue();
	zdarzenia=new AppActionQueue();
	view=new View(polecenia, zdarzenia);
	model=new Model();
	strategyMap = new HashMap<Class<? extends AppAction>, Strategy>();
	addStrategies();
	alive=true;
	model.start();
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
	Controller controller=new Controller();
	
	while(controller.alive)
	{
	    controller.run();
	}
    }
    
    /**
     * 
     */
    private void run()
    {
	AppAction appAction = zdarzenia.take();
	//view.setLog("test0");
	//Strategy c = strategyMap.get(appAction.getClass());
	view.setLog(appAction.getClass().getName());
	Strategy c = strategyMap.get(appAction.getClass());
	c.doAction(appAction);
    }
    
    /**
     * 
     */
    private void addStrategies()
    {
	strategyMap.put(CloseAppAction.class, new CloseStrategy(this));
	strategyMap.put(ActionFromView.class, new ViewActionStrategy(this));
    }
    
    /**
     * 
     */
    public void stop()
    {
	alive = false;
	view.dispose();
    }

    /**
     * @param appAction
     */
    public void executeAction(ActionFromView appAction)
    {
	//view.setLog(appAction.getClass().getName());
	view.setLog(model.execute(appAction));
    }


}
