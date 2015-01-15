/**
 * 
 */
package pl.edu.pw.elka.Kalkulator.Controller;

import pl.edu.pw.elka.Kalkulator.AppActionQueue.AppAction;

/**
 * @author x
 *
 */
abstract class Strategy
{
    protected final Controller controller;
    
    /**
     * @param controller
     */
    public Strategy(Controller controller)
    {
	this.controller = controller;
    }
    
    /**
     * @param appAction
     */
    abstract void doAction(AppAction appAction);
}
