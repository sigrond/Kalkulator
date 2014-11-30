package pl.edu.pw.elka.Kalkulator.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.BlockingQueue;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import pl.edu.pw.elka.Kalkulator.AppActionQueue.*;
import pl.edu.pw.elka.Kalkulator.Controller.*;

public class View
{
    private final AppActionQueue polecenia;//polecenia do view
    private final AppActionQueue zdarzenia;//zdarzenia z view
    public View(final AppActionQueue polecenia, final AppActionQueue zdarzenia)
    {
	this.polecenia=polecenia;
	this.zdarzenia=zdarzenia;
    }
}
