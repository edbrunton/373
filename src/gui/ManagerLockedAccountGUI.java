package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Accounts.BankAccount;
import Accounts.CheckingAccount;
import Accounts.CreditCard;
import Accounts.Mortgage;
import Accounts.SavingsAccount;
import Hardware.Bank;
import People.Customer;
import People.Employee;
import People.Person;


public class ManagerLockedAccountGUI {

	private Bank bank;
	private Container inputs;
	public ManagerLockedAccountGUI(Bank bank){
		this.bank = bank;
		if(bank.getSuspendedAccounts().size() == 0)
		{
			textParseError("No Accounts Need Unlocking", "The bank has no locked accounts");
		}
		for(int i = 0; i < bank.getSuspendedAccounts().size(); i++)
		{
			approvalMessage("Locked Account", bank.getSuspendedAccounts().get(i));
		}
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
		private final class ApproveAccount implements ActionListener {
			Person holder;
			JDialog frameHolder;
			private ApproveAccount(Person holder, JDialog frameHolder){
				this.holder = holder;
				this.frameHolder = frameHolder;
			}
			public void actionPerformed(ActionEvent e)
			{	
				bank.getSuspendedAccounts().remove(holder);
				holder.getLogin().setConsecutiveLoginFails(0);
				frameHolder.dispose();
			}
		}
		
		private final class DeclineAccount implements ActionListener {
			BankAccount approvedAccount;
			JDialog frameHolder;
			Person holder;
			private DeclineAccount(Person holder, JDialog frameHolder){
				this.holder = holder;
				this.frameHolder = frameHolder;
			}
			private DeclineAccount(BankAccount approvedAccount, JDialog frameHolder){
				this.approvedAccount = approvedAccount;
				this.frameHolder = frameHolder;
			}

			public void actionPerformed(ActionEvent e)
			{	
				frameHolder.dispose();
			}
		}
		private void approvalMessage(String title, Person bA) {
			JDialog frame = new JDialog (new JFrame(), title);//inspired by https://stackoverflow.com/questions/2665355/how-do-i-remove-the-maximize-and-minimize-buttons-from-a-jframe  
			frame = new JDialog (new JFrame(), "Login To Bank");
			frame.setSize(500, 900);
			Container inputs = frame.getContentPane();
			inputs.setLayout (new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			JLabel b1 = new JLabel("     ");
			JLabel b2 = new JLabel("     ");
			JLabel b3 = new JLabel("     ");
			JLabel b4 = new JLabel("     ");
			JLabel b5 = new JLabel("     ");
			JLabel sName = new JLabel("Client Name: ");
			JLabel sTF = new JLabel(bA.getFirstName() + " " + bA.getLastName());			
			JLabel b6 = new JLabel("     ");
			JLabel b7 = new JLabel("     ");
			JLabel dName = new JLabel("Account Info: ");
			JLabel dTF = new JLabel(bA.getLogin().getUsername());
			JLabel b8 = new JLabel("     ");
			JLabel b9 = new JLabel("     ");
			JLabel b10 = new JLabel("     ");
			JButton okay = new JButton("Unlock");
			okay.addActionListener(new ApproveAccount(bA, frame));
			JButton cancel = new JButton("Ignore");
			cancel.addActionListener(new DeclineAccount(bA, frame)); //frame.dispose());
			c.anchor = GridBagConstraints.LINE_START;
			c.weightx = 15;
			c.weighty = 15;
			c.gridy = 0;
			c.gridx = 0;
			inputs.add(b1,c);
			c.gridy = 0;
			c.gridx = 1;
			inputs.add(b2,c);
			c.gridy = 0;
			c.gridx = 2;
			inputs.add(b3,c);
			c.gridy = 0;
			c.gridx = 3;
			inputs.add(b4,c);
			c.gridy = 0;
			c.gridx = 4;
			inputs.add(b9,c);
			c.gridy = 0;
			c.gridx = 5;
			inputs.add(b10,c);
			c.gridy = 1;
			c.gridx = 0;
			inputs.add(b5,c);
			c.gridy = 1;
			c.gridx = 1;
			inputs.add(sName,c);
			c.gridy = 1;
			c.gridx = 2;
			inputs.add(sTF,c);
			c.gridy = 1;
			c.gridx = 4;
			c.gridheight =2;
			c.gridheight =1;			
			inputs.add(b5,c);
			c.gridy = 2;
			c.gridx = 0;
			inputs.add(b6,c);
			c.gridy = 2;
			c.gridx = 1;
			inputs.add(dName,c);
			c.gridy = 2;
			c.gridx = 2;
			inputs.add(dTF,c);
			c.gridy = 2;
			c.gridx = 3;
			inputs.add(b7,c);
			c.gridy = 3;
			c.gridx = 0;
			c.weightx = 25;
			c.weighty = 25;
			inputs.add(b8,c);
			c.gridy = 3;
			c.gridx = 1;
			//c.anchor = GridBagConstraints.LINE_END;	
			inputs.add(okay,c);
			c.gridy = 3;
			c.gridx = 2;
			//c.anchor = GridBagConstraints.LINE_END;
			inputs.add(cancel,c);
			c.gridy = 3;
			c.gridx = 3;
			//System.out.println(myBank.getEmployees().size());
			frame.pack();
			frame.setVisible(true);
		}
}
