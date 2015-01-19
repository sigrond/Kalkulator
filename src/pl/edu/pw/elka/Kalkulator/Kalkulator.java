/**
 * 
 */
package pl.edu.pw.elka.Kalkulator;

import pl.edu.pw.elka.Kalkulator.Controller.Controller;

/**
 * @author x
 *
 */
public final class Kalkulator
{
	/**
     * @param args
     */
    public static void main(String[] args)
    {
    	Controller controller=new Controller();
    	controller.controllerLoop();
    }

}
