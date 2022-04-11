package myAtm;

import consoleInputOutput.UserOutput;

public class Deposit extends AtmTransaction {

	public Deposit(Account account) {
		super(account);
		try{
			double amount ;
			do {
				amount = getAmountFromUserAsInput ("deposit");
				if (amount < 0) {
					UserOutput.consoleStringPrinter("Amount must be greater than Zero");
				}
			}while (amount < 0);
			accountBal += amount ;
			UserOutput.consoleStringPrinter("Amount : "+ amount +" deposited"
					+ "\nUpdated Balance : " + accountBal);
			updateBalance(accountBal);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
