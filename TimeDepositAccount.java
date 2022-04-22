/*
 * Demonstrated inheritance
 * 
 * Keeps tract of a time deposit account
 * There is an interest penalty for withdrawing before time period ends
 */

public class TimeDepositAccount extends SavingsAccount 
{
	private int elapsedPeriods; //Periods the account has existed
	private int maturityPeriods; //periods for account to mature
	private double interestPenaltyRate; //rate of interest to be deducted in case of early withdrawl
	
	/*
	 * Constructor to create TimesDepositAccount given interest rate,
	 * initial amount, number of periods to maturity, and interest penalty rates 
	 * 
	 * @param rate- the interest rate paid by the account 
	 * @param initialAmount- the amount in the account when it is created 
	 * @param maturity- the number of periods before can withdraw without penalty 
	 * @param penalty- the rate charged as a penalty for early withdrawal 
	 */
	public TimeDepositAccount(double rate, double initialAmount, int maturity, 
			double penalty)
	{
		super(rate, initialAmount);
		elapsedPeriods = 0;
		maturityPeriods = maturity;
		interestPenaltyRate = penalty;
	}
	
	//Inherits methods deposit, getBalance, transfer and toString methods
	//from BankAccount and addPeriodicInterest from SavingsAccount
	
	//override addPeriodicInterest and withdraw to deal with elapsed period periods
	
	/*
	 * Add periodic interest, keeping track of number of elapsed periods
	 */
	public void addPeriodInterest() 
	{
		elapsedPeriods++;
		super.addPeriodicInterest();
	}
	
	/*
	 * Withdraw, but charge a penalty for early withdrawal if necessary 
	 * Note that the penalty is on the entire balance, not just the amount withdrawn
	 */
	public void withdraw(double amount) 
	{
		if (elapsedPeriods < maturityPeriods)
		{
			super.withdraw((interestPenaltyRate / 100) * elapsedPeriods * getBalance());
			super.withdraw(amount);
		}
	}
}
