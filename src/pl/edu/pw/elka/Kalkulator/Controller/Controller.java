package pl.edu.pw.elka.Kalkulator.Controller;

import pl.edu.pw.elka.Kalkulator.AppActionQueue.*;
import pl.edu.pw.elka.Kalkulator.Model.*;
import pl.edu.pw.elka.Kalkulator.View.*;

public class Controller
{
    private final View view;
    private final AppActionQueue queue;
    private final Model model;
    public Controller()
    {
	queue = new AppActionQueue();//LinkedBlockingQueue<>();
	view = new View(queue);
	model = new Model();
    }

    public static void main(String[] args)
    {
		// TODO Auto-generated method stub
    }

}
