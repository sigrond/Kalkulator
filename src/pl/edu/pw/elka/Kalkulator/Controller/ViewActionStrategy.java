package pl.edu.pw.elka.Kalkulator.Controller;

import pl.edu.pw.elka.Kalkulator.AppEventQueue.AppEvent;
import pl.edu.pw.elka.Kalkulator.AppEventQueue.EventFromView;

/**
 * @author Tomasz Jakubczyk
 *         zwyk�e zdarzenie z widoku. ma by� obs�u�one zgodnie z modelem
 */
public class ViewActionStrategy extends Strategy
{

	/**
	 * @param controller
	 *            konstruktor wywo�uje konstruktor rodzica
	 */
	public ViewActionStrategy(final Controller controller)
	{
		super(controller);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * pl.edu.pw.elka.Kalkulator.Controller.Strategy#doAction(pl.edu.pw.elka
	 * .Kalkulator.AppEventQueue.AppEvent)
	 */
	@Override
	void doAction(final AppEvent appEvent)
	{
		controller.executeAction((EventFromView) appEvent);
	}

}
