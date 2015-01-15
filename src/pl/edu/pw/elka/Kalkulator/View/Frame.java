/**
 * 
 */
package pl.edu.pw.elka.Kalkulator.View;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.InvalidClassException;






//import java.awt.event.KeyEvent;

//import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 * @author x
 *
 */
public class Frame extends JFrame
{
    private static final long serialVersionUID = 777L;
    private final View view;
    private final JTextArea logArea;
    
    /**
     * @param view
     */
    public Frame(View view)
    {
	super("okno");
	this.view = view;
	setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	
	logArea = new JTextArea(10,50);
	JScrollPane scrollPane = new JScrollPane(logArea); 
	logArea.setEditable(true);
	
	getContentPane().setLayout(new GridBagLayout());
	GridBagConstraints constaints = new GridBagConstraints();
	// dodanie logu
	
	constaints.fill = GridBagConstraints.BOTH;
	constaints.gridwidth = 2;
	constaints.gridx = 0;
	constaints.gridy = 0;
	getContentPane().add(scrollPane, constaints);
	
	
        
        buildMenuBar();
        
	
	pack();
	//setExtendedState(MAXIMIZED_BOTH);
	setVisible(true);
    }
    
    /**
     * 
     */
    private void buildMenuBar()
    {
	JMenuBar menuBar = new JMenuBar();
	JMenu helpMenu = new JMenu("menu");

	JMenuItem helpMenuItem = new JMenuItem("help");
		// dodaj akcjê pkazania pomocy
		helpMenuItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				//showHelp();
			}
		});
		helpMenu.add(helpMenuItem);

		// przycisk autorów
		JMenuItem authorsMenuItem = new JMenuItem("autor");
		authorsMenuItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//showAuthors();
			}
		});
		helpMenu.add(authorsMenuItem);

		menuBar.add(helpMenu);
		// /
		setJMenuBar(menuBar);
    }
    
    /**
     * @param newtext
     */
    public void setLog(final String newtext)
    {
	logArea.setText(newtext);
    }
    
    /**
     * 
     */
    public void addButtons()
    {
	JPanel newJpanel = new JPanel();
	newJpanel.setLayout(new BoxLayout(newJpanel, BoxLayout.Y_AXIS));
	newJpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
	JLabel nameLabel = new JLabel("nazwa");
	nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	newJpanel.add(nameLabel);
	for (int actionIndex = 0; actionIndex <= 9; actionIndex++)
	{
	    CalcButton button = new CalcButton(Integer.toString(actionIndex), actionIndex);
	    button.addActionListener(new ActionListener()
	    {
		@Override
		public void actionPerformed(ActionEvent e)
		{
		    CalcButton actionButton = (CalcButton) e.getSource();
		    int actionIndex = actionButton.getActionIndex();
		    view.sendActionToQueue(actionIndex);
		}
	    });
	    button.setAlignmentX(Component.CENTER_ALIGNMENT);
	    newJpanel.add(button);
	}
	
	CalcButton button = new CalcButton("+", 10);
	button.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		CalcButton actionButton = (CalcButton) e.getSource();
		int actionIndex = actionButton.getActionIndex();
		view.sendActionToQueue(actionIndex);
	    }
	});
	button.setAlignmentX(Component.LEFT_ALIGNMENT);
	newJpanel.add(button);
	
	button = new CalcButton("-", 11);
	button.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		CalcButton actionButton = (CalcButton) e.getSource();
		int actionIndex = actionButton.getActionIndex();
		view.sendActionToQueue(actionIndex);
	    }
	});
	button.setAlignmentX(Component.LEFT_ALIGNMENT);
	newJpanel.add(button);
	
	button = new CalcButton("*", 12);
	button.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		CalcButton actionButton = (CalcButton) e.getSource();
		int actionIndex = actionButton.getActionIndex();
		view.sendActionToQueue(actionIndex);
	    }
	});
	
	button.setAlignmentX(Component.LEFT_ALIGNMENT);
	newJpanel.add(button);
	button = new CalcButton("/", 13);
	button.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		CalcButton actionButton = (CalcButton) e.getSource();
		int actionIndex = actionButton.getActionIndex();
		view.sendActionToQueue(actionIndex);
	    }
	});
	button.setAlignmentX(Component.LEFT_ALIGNMENT);
	newJpanel.add(button);
	
	button = new CalcButton("=", 14);
	button.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		CalcButton actionButton = (CalcButton) e.getSource();
		int actionIndex = actionButton.getActionIndex();
		view.sendActionToQueue(actionIndex);
	    }
	});
	button.setAlignmentX(Component.LEFT_ALIGNMENT);
	newJpanel.add(button);
	
	button = new CalcButton(",", 15);
	button.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		CalcButton actionButton = (CalcButton) e.getSource();
		int actionIndex = actionButton.getActionIndex();
		view.sendActionToQueue(actionIndex);
	    }
	});
	button.setAlignmentX(Component.LEFT_ALIGNMENT);
	newJpanel.add(button);
	
	button = new CalcButton("C", 16);
	button.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
		CalcButton actionButton = (CalcButton) e.getSource();
		int actionIndex = actionButton.getActionIndex();
		view.sendActionToQueue(actionIndex);
	    }
	});
	button.setAlignmentX(Component.LEFT_ALIGNMENT);
	newJpanel.add(button);
	
	getContentPane().add(newJpanel);
    }
    
}
