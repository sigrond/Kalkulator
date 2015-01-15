/**
 * 
 */
package pl.edu.pw.elka.Kalkulator.AppActionQueue;

/**
 * @author x
 *
 */
public class ActionFromView extends AppAction
{
    private final int actionIndex;
    
    /**
     * @param actionIndex
     */
    public ActionFromView(int actionIndex)
    {
	this.actionIndex = actionIndex;
    }
    
    /**
     * @return
     */
    public int getActionIndex()
    {
	return actionIndex;
    }
}
