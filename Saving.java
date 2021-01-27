
/**
 * Checking account class.
 *
 * @author (Xianta Jiang)
 * @version (V1)
 */
public class Saving extends Account
{
    // instance variables 
    private static final float eachTimeCharge = 3.9f;
    /**
     * Constructor for objects of class sve
     */
    public Saving()
    {
        // initialise instance variables
        super();
    }
    public Saving(String user)
    {
        super(user);
        
    }
    /**
     * Withdraw amount of money
     *
     * @param  m  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void withdraw(float m)
    {
        // 
        if (m >= 0){ 
           if (balance < m)
           { System.out.println("The balance is insufficient!");return;}
        balance = balance -m - eachTimeCharge;}
        else{ balance = balance ;}
    }
}
