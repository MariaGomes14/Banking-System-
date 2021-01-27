
/**
 * Write a description of class account here.
 * A common class for bank account which can be inherited into chk and sve
 *
 * @author (Xianta Jiang)
 * @version (V1)
 */
import java.util.Random;
import java.util.ArrayList;
public class Account
{
    // instance variables - replace the example below with your own
    private int accountNo;
    private String userName;    
    protected float balance;

    /**
     * Constructor for objects of class account
     */
    public Account()//4
    {        
        // initialise instance variables
        Random rand = new Random();
        accountNo = Math.abs(rand.nextInt());
        userName = "";
        balance = 0;
    }
    public Account(String user)//3
    {        
        // initialise instance variables
        this();
        userName = user;
    }
    /**
     * Display account number and balance
     *
     * @param  n/a
     * @return    n/a
     */
    public void display()//3
    {
        System.out.println("Account no: "+ accountNo);
        System.out.println("User name: "+ userName);
        System.out.println("Balance: "+ balance);        
    }
    /**
     * withdraw amount of money m
     *
     * @param  m amount of money m to withdraw
     * @return    n/a
     */
    public void withdraw(float m)//2
    {
        // 
    }
    /**
     * deposit amount of money m
     *
     * @param  m amount of money m to deposit
     * @return    n/a
     */
    public void deposit(float m)//3
    {
        // deposit
        balance = balance + m;
    }
    /**
     * return the balance
     * @return    balance
     */
    public float getBalance()//2
    {
        return balance;
    }
    /**
     * return the username
     * @return    username
     */
    public String getUsername() //2
    {
        return userName;
    }
    public int getAccountNo(){
        return accountNo;
    }
}
