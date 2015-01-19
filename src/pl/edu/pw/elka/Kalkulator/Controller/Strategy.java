package pl.edu.pw.elka.Kalkulator.Controller;

import pl.edu.pw.elka.Kalkulator.AppEventQueue.AppEvent;

/**
 * @author Tomasz Jakubczyk
 *         strategia mówi kontrolerowi jak obs³u¿yæ zdarzenie
 */
abstract class Strategy
{
	/** kontroler który obs³uguje strategie */
	protected final Controller controller;

	/**
	 * @param controller
	 */
	public Strategy(final Controller controller)
	{
		this.controller = controller;
	}

	/**
	 * @param appEvent
	 *            - zdarzenie do obs³ugi
	 *            co kontroler ma zrobiæ
	 */
	abstract void doAction(final AppEvent appEvent);
}
