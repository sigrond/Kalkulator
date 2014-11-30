package pl.edu.pw.elka.Kalkulator.Controller;

import pl.edu.pw.elka.Kalkulator.AppActionQueue.*;
import pl.edu.pw.elka.Kalkulator.Model.*;
import pl.edu.pw.elka.Kalkulator.View.*;

public class Controller
{
    private final View view;
    private final AppActionQueue polecenia;//polecenia do view
    private final AppActionQueue zdarzenia;//zdarzenia z view
    private final Model model;
    public Controller()
    {
	polecenia=new AppActionQueue();
	zdarzenia=new AppActionQueue();
	view=new View(polecenia, zdarzenia);
	model=new Model();
    }

    public static void main(String[] args)
    {
		// TODO Auto-generated method stub
    }

}
