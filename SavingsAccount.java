/*
 * Demonstrates inheritance. Keeps track of a savings account
 * 
 * Savings account is a bank account hat pays periodic interest
 */
public class SavingsAccount extends BankAccount {
	/*
	 * Note that balance is inherited from BankAccount, but is not 
	 * directly accessible because it is private. 
	 * 
	 * Methods: deposit, withdraw, getBalance, transfer, and toString
	 * are also inherited, because they are public. They are directly accessible 
	 */
	
	private double interestRate; //holds the interest rate for the period
	
	/*
	 * Constructor that sets rate and initial balance. 
	 */
	public SavingsAccount(double rate) {
		//because no call to super is made in the first line, 
		//the default constructor for BankAccount is automatically called here 
		
		interestRate = rate;
	}
	
	/*
	 * Constructor that sets rate and initial balance
	 * @param rate- the interest rate paid by the account 
	 * @param initialAmount- the amount in the account when it is created 
	 */
	public SavingsAccount(double rate, double initialAmount) {
		super(initialAmount); //calls for constructor for BankAccount
							  //MUST be the first line of constructor
		
		interestRate = rate;
	}
	
	/*
	 * Add interest for the current period to the account balance
	 */
	public void addPeriodicInterest() {
		double interest = getBalance() * interestRate / 100.0;
			deposit(interest);
	}
}
