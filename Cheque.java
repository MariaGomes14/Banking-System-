
/**
 * Checking account class.
 *
 * @author (Xianta Jiang)
 * @version (V1)
 */
public class Cheque extends Account
{
    // instance variables 
    private static final float minimBalance = 1000;
    private static final float overLimitCharge = 5;
    /**
     * Constructor for objects of class Cheque
     */
    public Cheque()
    {
        // initialise instance variables
        super();
    }
    public Cheque(String user)
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
            if (balance < minimBalance)
                balance = balance -m -overLimitCharge;
            else
            balance = balance -m;}
           else{ balance = balance ; }
    }
}
