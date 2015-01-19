package pl.edu.pw.elka.Kalkulator.Model;

import pl.edu.pw.elka.Kalkulator.AppEventQueue.EventFromView;

/**
 * @author x
 */
public class Model
{
	private String dane;

	/**
	 * @param appAction
	 * @return
	 */
	public String execute(EventFromView appAction)
	{
		int wartosc = appAction.getActionIndex();
		if(wartosc <= 9)
		{
			dane += Integer.toString(wartosc);
		}
		else if(wartosc == '+')
		{
			dane += "+";
		}
		else if(wartosc == '-')
		{
			dane += "-";
		}
		else if(wartosc == '*')
		{
			dane += "*";
		}
		else if(wartosc == '/')
		{
			dane += "/";
		}
		else if(wartosc == '=')
		{
			try
			{
				this.dane = (new CalculationData(this.dane)).Calculate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(wartosc == '.')
		{
			dane += ".";
		}
		else if(wartosc == 'C')
		{
			dane = "";
		}
		else if(wartosc == '(')
		{
			dane += "(";
		}
		else if(wartosc == ')')
		{
			dane += ")";
		}
		return dane;
	}

	public Model()
	{
		this.dane = "";
	}

}
