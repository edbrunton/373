package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Hardware.Bank;
import Hardware.MonthlyButton;
import People.Employee;


public class ManagerPageGUI {
	private Employee employee;
	private Bank bank;
	private Container inputs;
	private JTextField c0;
	private DefaultListModel<String> listModel;
	private JList<String> list;
	private JDialog frame;
	private JDialog frameTemp; 
	public ManagerPageGUI(Employee employee, Bank bank)
	{
		this.setBank(bank);
		this.setEmployee(employee);
		System.out.println("Bank and Employee info loaded");
		frame = new JDialog (new JFrame(), employee.getFirstName() + " " + employee.getLastName() + "'s portal");
		frame.setSize(500, 900);
		inputs = frame.getContentPane();
		inputs.setLayout (new GridBagLayout());
		JLabel a0 = new JLabel("     ");
		JLabel d0 = new JLabel("     ");
		JLabel f0 = new JLabel("     ");
		JLabel b0 = new JLabel("Search Account: ");
		JButton e0 = new JButton("Pending Accounts");
		e0.addActionListener(new PendingAccounts());
		JButton e1 = new JButton("Locked Accounts");
		e1.addActionListener(new LockedAccounts());
		JButton e2 = new JButton("Edit Personal Info");
		e2.addActionListener(new EditPersonalInfo());
		JButton e3 = new JButton("Delete Account");
		e3.addActionListener(new DeleteAccount());
		JButton e7  = new JButton("Exit");
		e7.addActionListener(e -> frame.dispose());
		JButton b7 = new JButton("Open Selected");
		b7.addActionListener(new OpenAccount());
		JButton b1 = new JButton("Search");
		b1.addActionListener(new SearchAccount());
		JButton monthylButton = new JButton("Monthly Button");
		monthylButton.addActionListener(new AdvanceMonth());
		listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		JScrollPane scroll = new JScrollPane(list);
		addAt(scroll, 2, 1, 4, 2);
		c0 = new JTextField(10);
		listModel.addElement("new");//example of how to have a search element
	//	System.out.println("Removing trial element");
		listModel.remove(0);
	//	System.out.println("Trial element removed");
		addAt(a0, 0, 0);
		addAt(b0, 0, 1);
		addAt(c0, 0, 2);
		addAt(d0, 0, 3);
		addAt(e0, 0, 4);
		addAt(f0, 0, 5);
		addAt(b1, 1, 2, 2);
		addAt(e1, 2, 4);
		addAt(monthylButton, 3, 4);
		addAt(e2, 5, 4);
		addAt(e3, 6, 4);
		addAt(b7, 7, 1);
		addAt(e7, 7, 4);
		frame.pack();
		frame.setVisible(true);
	}
	private final class OpenAccount implements ActionListener {
		
		private OpenAccount(){
		}

		public void actionPerformed(ActionEvent e)
		{
			try {
				String result = list.getSelectedValue();
				//TODO Ryan. Parse result and find associate account and customer
			}
			catch(Exception p){
				
			}
		}
	}	
	private final class EditPersonalInfo implements ActionListener {
		
		private EditPersonalInfo(){
		}

		public void actionPerformed(ActionEvent e)
		{
			new ManagerEditPersonalInfo(employee, bank);
		}
	}	
	private final class DeleteAccount implements ActionListener {
		
		private DeleteAccount(){
		}

		public void actionPerformed(ActionEvent e)
		{
			confirmDelete("Your Account is About to be Deleted", "Close this window if you wish to abort the deletion"); 
		}
	}
	private final class AdvanceMonth implements ActionListener {
		
		private AdvanceMonth(){
		}

		public void actionPerformed(ActionEvent e)
		{
			
			//TODO Implement the monthly push here TODO Ryan
			//add monthly button to bank
			//MonthlyButton temp = new MonthlyButton();
			//temp.pushMonthlyButton();
			textParseError("Month Advanced", "The Monthly Button has been sucessfully pressed");
			
		}
	}
	private final class ActuallyDelete implements ActionListener {
		
		private ActuallyDelete(){
		}

		public void actionPerformed(ActionEvent e)
		{
			bank.getEmployees().remove(employee);
			frameTemp.dispose();
			frame.dispose();
		}
	}
	private final class LockedAccounts implements ActionListener {
		
		private LockedAccounts(){
		}

		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	private final class SearchAccount implements ActionListener {
		
		private SearchAccount(){
			
		}

		public void actionPerformed(ActionEvent e)
		{
		//TODO Ryan. 
			//go through all customer accounts, search first names, last names, emails and account numbers; return email + acccount number
		}
	}
	private final class PendingAccounts implements ActionListener {
		
		private PendingAccounts(){
		}

		public void actionPerformed(ActionEvent e)
		{
			new ManagerPendingAccountGUI(bank);
		}
	}


	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
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
	private void confirmDelete(String title, String message) {
		frameTemp = new JDialog (new JFrame(), title);//inspired by https://stackoverflow.com/questions/2665355/how-do-i-remove-the-maximize-and-minimize-buttons-from-a-jframe  
		        Container contentPane = frameTemp.getContentPane ();
		        contentPane.setLayout (new BorderLayout());
		        JButton okay = new JButton("Confirm Delete");
		        okay.addActionListener(new ActuallyDelete());
		        okay.setSize(30, 10);
		        JPanel p1 = new JPanel();
		        p1.add(okay);
		        contentPane.add(p1, BorderLayout.SOUTH);			    	        
		        JLabel outArea = new JLabel(message);
		        contentPane.add(outArea, BorderLayout.CENTER);
		        frameTemp.pack();
		        frameTemp.setVisible (true);		//need to throw error
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
}
