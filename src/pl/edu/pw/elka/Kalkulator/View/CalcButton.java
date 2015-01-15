/**
 * 
 */
package pl.edu.pw.elka.Kalkulator.View;

import javax.swing.JButton;

/**
 * @author x
 *
 */
public class CalcButton extends JButton
{
    /**
     * 
     */
    private static final long serialVersionUID = 5353902292046585152L;

    private final int actionIndex;
    
    /**
     * @param name
     * @param actionIndex
     */
    public CalcButton(final String name, final int actionIndex)
    {
	super(name);
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
