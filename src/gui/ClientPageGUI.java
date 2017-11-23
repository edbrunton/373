package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Hardware.Bank;
import People.Customer;
import People.Employee;

public class ClientPageGUI {
	private Container inputs;
	private Customer customer;
	private Bank bank;
	public ClientPageGUI(Customer customer, Bank bank)
	{
		this.setBank(bank);
		this.setCustomer(customer);
	}
	private void addAt(JScrollPane scroll, int row, int column, int rowSpan, int colSpan) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy =row;
		c.gridx = column;
		c.gridwidth = colSpan;
		c.gridheight = rowSpan;
		inputs.add(scroll, c);	
	}
	private void addAt(JButton a1, int row, int column, int span) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy =row;
		c.gridx = column;
		c.gridwidth = span;
		inputs.add(a1, c);	
	}	
	private void addAt(JLabel a1, int row, int column) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy =row;
		c.gridx = column;
		inputs.add(a1, c);	
	}
	private void addAt(JTextField a1, int row, int column) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy =row;
		c.gridx = column;
		inputs.add(a1, c);	
	}
	private void addAt(JPasswordField a1, int row, int column) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy =row;
		c.gridx = column;
		inputs.add(a1, c);	
	}
	private void addAt(JButton a1, int row, int column) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy =row;
		c.gridx = column;
		inputs.add(a1, c);	
	}
	private void addAt(JComboBox a1, int row, int column) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy =row;
		c.gridx = column;
		inputs.add(a1, c);	
	}
	private void addAt(JLabel a1, int row, int column, int span) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy =row;
		c.gridx = column;
		c.gridwidth = span;
		inputs.add(a1, c);	
	}	
	private void textParseError(String title, String message) {
		JDialog frameTemp = new JDialog (new JFrame(), title);//inspired by https://stackoverflow.com/questions/2665355/how-do-i-remove-the-maximize-and-minimize-buttons-from-a-jframe  
		        Container contentPane = frameTemp.getContentPane ();
		        contentPane.setLayout (new BorderLayout());
		        JButton okay = new JButton("OK");
		        okay.addActionListener(e2 -> frameTemp.dispose());
		        okay.setSize(30, 10);
		        JPanel p1 = new JPanel();
		        p1.add(okay);
		        contentPane.add(p1, BorderLayout.SOUTH);			    	        
		        JLabel outArea = new JLabel(message);
		        contentPane.add(outArea, BorderLayout.CENTER);
		        frameTemp.pack();
		        frameTemp.setVisible (true);		//need to throw error
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
        
}
