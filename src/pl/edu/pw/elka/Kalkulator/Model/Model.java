package pl.edu.pw.elka.Kalkulator.Model;

import pl.edu.pw.elka.Kalkulator.AppActionQueue.ActionFromView;

/**
 * @author x
 *
 */
public class Model
{
    String dane="";
    String dane2="";
    int liczba1=0;
    int liczba2=0;
    int stan=0;
    /**
     * @param appAction
     * @return
     */
    public String execute(ActionFromView appAction)
    {
	int wartosc=appAction.getActionIndex();
	if(wartosc<=9)
	{
	    dane+=Integer.toString(wartosc);
	    dane2+=Integer.toString(wartosc);
	}
	else if(wartosc==10)
	{
	    liczba1=Integer.parseInt(dane);
	    stan=10;
	    dane+="+";
	    dane2="";
	}
	else if(wartosc==11)
	{
	    dane+="-";
	}
	else if(wartosc==12)
	{
	    dane+="*";
	}
	else if(wartosc==13)
	{
	    dane+="/";
	}
	else if(wartosc==14)
	{
	    liczba2=Integer.parseInt(dane2);
	    stan=0;
	    dane=Integer.toString(liczba1+liczba2);
	}
	else if(wartosc==15)
	{
	    dane+=",";
	}
	else if(wartosc==16)
	{
	    dane="";
	}
	return dane;
    }
    
    public void start()
    {
	
    }

}
