package pl.edu.pw.elka.Kalkulator.Controller;

import pl.edu.pw.elka.Kalkulator.AppEventQueue.AppEvent;

/**
 * @author Tomasz Jakubczyk
 *         strategia m�wi kontrolerowi jak obs�u�y� zdarzenie
 */
abstract class Strategy
{
	/** kontroler kt�ry obs�uguje strategie */
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
	 *            - zdarzenie do obs�ugi
	 *            co kontroler ma zrobi�
	 */
	abstract void doAction(final AppEvent appEvent);
}
