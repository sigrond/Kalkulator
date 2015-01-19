package pl.edu.pw.elka.Kalkulator.AppEventQueue;

/**
 * @author Tomasz Jakubczyk
 *         zwyk³e zdarzenie z widoku
 */
public class EventFromView extends AppEvent
{
	private final int eventIndex;

	/**
	 * @param actionIndex
	 */
	public EventFromView(final int eventIndex)
	{
		this.eventIndex = eventIndex;
	}

	/**
	 * @return eventIndex
	 */
	public int getActionIndex()
	{
		return eventIndex;
	}
}
