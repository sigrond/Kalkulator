/**
 * 
 */
package pl.edu.pw.elka.Kalkulator.Controller;

import pl.edu.pw.elka.Kalkulator.AppActionQueue.AppAction;

/**
 * @author x
 *
 */
class CloseStrategy extends Strategy
{

    /**
     * @param controller
     */
    public CloseStrategy(final Controller controller)
    {
	super(controller);
	// TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see pl.edu.pw.elka.Kalkulator.Controller.Strategy#doAction(pl.edu.pw.elka.Kalkulator.AppActionQueue.AppAction)
     */
    @Override
    void doAction(final AppAction appAction)
    {
	controller.stop();
    }
    
}
