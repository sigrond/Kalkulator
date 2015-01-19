package pl.edu.pw.elka.Kalkulator.View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Tomasz Jakubczyk
 *         ramka okna
 */
public class Frame extends JFrame
{
	private static final long serialVersionUID = 777L;
	/** widok */
	private final View view;
	/** wyœwietlacz */
	private final JTextArea logArea;

	/**
	 * konstruktor ramki
	 * 
	 * @param view
	 */
	public Frame(View view)
	{
		super("Kalkulator");
		this.view = view;
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLayout(new BorderLayout());
		this.logArea = new JTextArea(2, 50);
		JScrollPane scrollPane = new JScrollPane(logArea);
		this.logArea.setEditable(false);
		getContentPane().add(scrollPane);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * ustaw wyœwietlacz
	 * 
	 * @param newtext
	 */
	public void setLog(final String newtext)
	{
		this.logArea.setText(newtext);
	}

	/** dodaj przyciski w oknie */
	public void addButtons()
	{
		JPanel newJpanel = new JPanel();
		newJpanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(30, 2, 2, 2);

		for(int actionIndex = 0; actionIndex <= 9; actionIndex++)
		{
			CalcButton button = new CalcButton(Integer.toString(actionIndex),
					actionIndex);
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
			newJpanel.add(button, gbc);
			gbc.gridx++;
			if(actionIndex % 4 == 3)
			{
				gbc.gridx = 0;
				gbc.gridy++;
				if(gbc.gridy == 1)
				{
					gbc.insets = new Insets(2, 2, 2, 2);
				}
			}

		}

		char[] znaki =
		{ '+', '-', '*', '/', '=', '.', 'C', '(', ')' };
		for(char v : znaki)
		{
			CalcButton button = new CalcButton(String.valueOf(v), (int) v);
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
			newJpanel.add(button, gbc);
			gbc.gridx++;
			if(gbc.gridx == 4)
			{
				gbc.gridx = 0;
				gbc.gridy++;
			}
		}
		getContentPane().add(newJpanel);
		this.pack();
	}

}
