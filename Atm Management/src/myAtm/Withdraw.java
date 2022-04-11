package myAtm;

import consoleInputOutput.UserOutput;

public class Withdraw extends AtmTransaction {

	public Withdraw(Account account) {
		super(account);

		try {
			double amount ;
			do {
				amount = getAmountFromUserAsInput ("withdraw");
				if (amount < 0) {
					UserOutput.consoleStringPrinter("Amount must be greater than Zero");
				}
				else if (amount > accountBal) {
					UserOutput.consoleStringPrinter("Insufficient balance! Amount must be lesser than account balance : "+ accountBal);
				}
			}while (amount < 0 || amount > accountBal );
			accountBal -= amount ;
			UserOutput.consoleStringPrinter("Amount : "+ amount +" withdrawn, Please collect your cash !"
					+ "\nUpdated Balance : "+ accountBal);
			
			account.setBalance(accountBal);
		}
		catch (Exception e) {
			UserOutput.consoleStringPrinter("Invalid Input");
			e.printStackTrace();
		}
		
	}

}
