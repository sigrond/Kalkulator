package pl.edu.pw.elka.Kalkulator.Controller;

import pl.edu.pw.elka.Kalkulator.AppEventQueue.AppEvent;

/**
 * @author Tomasz Jakubczyk
 *         strategia zamkniecia programu
 */
class CloseStrategy extends Strategy
{

	/**
	 * @param controller
	 *            konstruktor wywo³uje konstruktor rodzica
	 */
	public CloseStrategy(final Controller controller)
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
		controller.stop();
	}

}
