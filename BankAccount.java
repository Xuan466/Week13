// transfer the AccountTest to here 

public class BankAccount {
	private double balance; //hold the amount in the account 
	
	/*
	 * Default constructor. Creates an account with 0 balance 
	 */
	public BankAccount() {
		balance = 0.00;
	}
	
	/*
	 * 	Creates an account with an initial balance 
	 * @param initalAmount- the initial amount in the account when it is created
	 */
	public BankAccount(double initalAmount) {
		balance = initalAmount;
	}
	
	//deposits into bank account 
	public void deposit(double amount) {
		balance += amount;
	}
	
	/*
	 * Deposits into bank account
	 * Limitation: Does not test for an overdrawn account
	 */
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	//return the current balance in the account
	public double getBalance() {
		return balance;
	}
	
	/*
	 * Transfer money from this bank account to other bank 
	 * @param other bank account to transfer money to 
	 * @param amount the amount to transfer
	 */
	public void transfer(BankAccount other, double amount) {
		withdraw(amount);
		other.deposit(amount);
	}
	
	/*
	 * Overrides the toString provided by the object class
	 * @return String representation of the account 
	 */
		public String toString() {
			return "Account balance: " + balance;
		
	
		}		
}
