/**
 * Write a description of class ATM here.
 * An ATM interface
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ATM
{
    private Bank bank;
    private String user;
    private JFrame frame;
    /**
     * Constructor for objects of class ATM
     */
    public ATM(String user)
    {
        this.user = user;
        createBankInfor();
        makeFrame();        
    }
    private void createBankInfor(){
        //test example
        bank = new Bank("Canada");
        bank.add(new Saving(user));
        bank.add(new Saving(user));
        bank.add(new Cheque(user));
        bank.add(new Cheque(user));
    }
    /**
     * Create the frame     
     */
    private void makeFrame()
    { 
        frame = new JFrame("ATM");
        Container contentPane = frame.getContentPane();        
        makeMenuBar(frame);        
        listAccounts();        
        frame.pack();
        frame.setVisible(true);
    }      
    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        JMenu menu;
        JMenuItem item;        
        // create the Account menu
        menu = new JMenu("Accounts");
        menubar.add(menu);
        item = new JMenuItem("All Accounts...");
        item.addActionListener(e -> listAccounts());
        menu.add(item);
        //Q1. add a Checking menu item and its listener
        //your code goest here...
        // Add a “Checking”menu item to the “Accounts”menu, in the method makeMenuBar. 
        // An eventlistener should also be added to the “Checking”menu item.Figure 2 shows checking accounts are listed after the menu item isselected
        JMenuItem checkingItem = new JMenuItem("Checking");
        checkingItem.addActionListener(e -> listAccounts("Cheque"));
        menu.add(checkingItem);

        
        
        //Q2. add a Saving menu item and its listener   
        //your code goest here...
         // Add a “Saving”menu item to the “Accounts”menu, in the method makeMenuBar.
         // An eventlistener should also be added to the “Saving”menu item.After the menu item is clicked, saving accounts will be listed
        JMenuItem savingItem = new JMenuItem("Saving");
        savingItem.addActionListener(e -> listAccounts("Saving"));
        menu.add(savingItem); 
        

        
        
        
                
        // create the Help menu
        menu = new JMenu("Help");
        menubar.add(menu);  
        item = new JMenuItem("About...");
        item.addActionListener(e -> about());
        menu.add(item);        
        item = new JMenuItem("Exit...");
        menu.add(item);  
        item.addActionListener(e -> System.exit(0));

    }
    private void listAccounts(String accType)   
    {
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        //Your may need to change this line (parameters of grid layout) to better appearance after you finish coding
        contentPane.setLayout(new GridLayout(0,7)); 
        for(Account acc:bank.getAccounts(user)){
            if (!accType.equals(acc.getClass().getName())){
                continue;
            }
            drawAccount(acc);
        }
        frame.pack();
        // frame.repaint();
        frame.setVisible(true);
    }
    private void listAccounts()   
    {
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        //Your may need to change this line (parameters of grid layout) to better appearance after you finish coding        
        contentPane.setLayout(new GridLayout(0,7));
        for(Account acc:bank.getAccounts(user)){
            drawAccount(acc);
        }
        frame.pack();
        frame.setVisible(true);
    }
    /*
     * Draw each account on the panel
     */
    private void drawAccount(Account acc){
        Container contentPane = frame.getContentPane();        
        JLabel label1 = new JLabel(acc.getClass().getName());        
        contentPane.add(label1);
        
        //Q3. adding account number using a JLabel
        //your code goest here ...    
        // Complete part of the method drawAccount, byadding account number as a label as shown in Figure 1
        // (compared to Figure 3, where there is no account numberbeing listed)
        JLabel label2 = new JLabel("Account Number : ");
        contentPane.add(label2);
        JTextField tf2 = new JTextField(Float.toString(acc.getAccountNo()));        
        contentPane.add(tf2);
        tf2.setEditable(false);


        
        JLabel label3 = new JLabel("Balance: ");
        contentPane.add(label3);
        //Add a JTestField field for displaying balance value
        JTextField tf1 = new JTextField(Float.toString(acc.getBalance()));        
        contentPane.add(tf1);
        tf1.setEditable(false);

        
       
        //Add Deposit button and its listener
        JButton bDeposit = new JButton("Deposit");
        contentPane.add(bDeposit);
        //add event listener to the button, to pop up a dialog taking input
        bDeposit.addActionListener(
            ev->{String s = JOptionPane.showInputDialog("Input money: ",0);
                acc.deposit(s==null?0:Float.parseFloat(s));
                tf1.setText(Float.toString(acc.getBalance()));});
        //Q4. Add Withdraw button and its listener
        //your code goest here ... Complete part of the method drawAccount, byadding a “Withdraw”button and its event. 
        // A Java Dialog shouldpopupto take user input fortheamountofmoney to withdraw.
        // The displayedvalue of the balance text field should be changed correspondingly.
        // Read the event process of the button “Deposit”.However, pay attention to deal with when the input dialog box is cancelled, 
        // the balance should not be affect
        JButton bWithdraw = new JButton("Withdraw");
        contentPane.add(bWithdraw);
        //add event listener to the button, to pop up a dialog taking input
        bWithdraw.addActionListener(
            ev->{String s = JOptionPane.showInputDialog("Input money: ",0);
                // acc.withdraw(s==null?0:Float.parseFloat(s));
                acc.withdraw(s==null?(-1):Float.parseFloat(s));
                tf1.setText(Float.toString(acc.getBalance()));});

        
        
    }

    private void about(){
        JOptionPane.showMessageDialog(frame, 
                    "Bank System\n" ,
                    "About ATM", 
                    JOptionPane.INFORMATION_MESSAGE);
    }     
}
