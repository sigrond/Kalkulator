package pl.edu.pw.elka.Kalkulator.Controller;

import java.util.AbstractMap;
import java.util.HashMap;

import pl.edu.pw.elka.Kalkulator.AppEventQueue.AppEvent;
import pl.edu.pw.elka.Kalkulator.AppEventQueue.AppEventQueue;
import pl.edu.pw.elka.Kalkulator.AppEventQueue.CloseAppEvent;
import pl.edu.pw.elka.Kalkulator.AppEventQueue.EventFromView;
import pl.edu.pw.elka.Kalkulator.Model.Model;
import pl.edu.pw.elka.Kalkulator.View.View;

/**
 * @author Tomasz Jakubczyk
 *         kontroler steruje przebiegiem programu
 */
public class Controller
{
	/** widok kontrolera */
	private final View view;
	/** kolejka zdarze� z widoku */
	private final AppEventQueue zdarzenia;
	/** model kontrolera */
	private final Model model;
	private boolean alive;
	private final AbstractMap<Class<? extends AppEvent>, Strategy> strategyMap;

	/**
	 * konstruktor kontrolera
	 * tworzy widok, model i map� dzia�ania
	 */
	public Controller()
	{
		this.zdarzenia = new AppEventQueue();
		this.view = new View(zdarzenia);
		this.model = new Model();
		this.strategyMap = new HashMap<Class<? extends AppEvent>, Strategy>();
		this.addStrategies();
		this.alive = true;
	}

	/** klasa uruchamiaj�ca kontroler nale�y najpierw utworzy� ten kontroler */
	public final void controllerLoop()
	{
		while(this.alive)
		{
			this.run();
		}
	}

	/**
	 * pojedy�czy przebieg kontrolera bierze jedno zdarzenie z kolejki i
	 * wykonuje odpowiedni� strategi�
	 */
	private void run()
	{
		AppEvent appEvent = zdarzenia.take();
		// this.view.setLog(appEvent.getClass().getName());
		Strategy c = strategyMap.get(appEvent.getClass());
		c.doAction(appEvent);
	}

	/** wype�nia map� strategii */
	private void addStrategies()
	{
		this.strategyMap.put(CloseAppEvent.class, new CloseStrategy(this));
		this.strategyMap.put(EventFromView.class, new ViewActionStrategy(this));
	}

	/** zamyka widok i kontroler */
	void stop()
	{
		this.alive = false;
		this.view.dispose();
	}

	/**
	 * @param appAction
	 *            wykonuje akcje z modelu dla zdarzenia klikni�cia
	 */
	void executeAction(EventFromView appEvent)
	{
		this.view.setLog(model.execute(appEvent));
	}

}
