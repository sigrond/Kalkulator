/**
 * 
 */
package pl.edu.pw.elka.Kalkulator.Controller;

import pl.edu.pw.elka.Kalkulator.AppActionQueue.ActionFromView;
import pl.edu.pw.elka.Kalkulator.AppActionQueue.AppAction;

/**
 * @author x
 *
 */
public class ViewActionStrategy extends Strategy
{

    /**
     * @param controller
     */
    public ViewActionStrategy(final Controller controller)
    {
	super(controller);
    }

    /* (non-Javadoc)
     * @see pl.edu.pw.elka.Kalkulator.Controller.Strategy#doAction(pl.edu.pw.elka.Kalkulator.AppActionQueue.AppAction)
     */
    @Override
    void doAction(final AppAction appAction)
    {
	controller.executeAction((ActionFromView) appAction);
    }
    
}
