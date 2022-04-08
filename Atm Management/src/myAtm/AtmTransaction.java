package myAtm;

import consoleInputOutput.UserInputs;
import consoleInputOutput.UserOutput;

public class AtmTransaction implements AtmTransactionFacilities{
	private Account account;
	private static double accountBal;
	
	AtmTransaction(Account account){
		this.account = account;
		AtmTransaction.accountBal = this.account.getBalance();
	}

	public void withdraw(Account account2) {
		try {
			double amount ;
			do {
				amount = getAmount ("withdraw");
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
			
			this.account.setBalance(accountBal);
		}
		catch (Exception e) {
			UserOutput.consoleStringPrinter("Invalid Input");
			e.printStackTrace();
		}
		
	}

	public void deposit(Account account) {
		try{
			double amount ;
			do {
				amount = getAmount ("deposit");
				if (amount < 0) {
					UserOutput.consoleStringPrinter("Amount must be greater than Zero");
				}
			}while (amount < 0);
			accountBal += amount ;
			UserOutput.consoleStringPrinter("Amount : "+ amount +" deposited"
					+ "\nUpdated Balance : " + accountBal);
			this.account.setBalance(accountBal);
			
		}
		catch (Exception e) {
			UserOutput.consoleStringPrinter("Invalid Input");
			e.printStackTrace();
		}
	}
	
	public void checkBalance(Account account) {
		UserOutput.consoleStringPrinter("Account Balance : " + accountBal);
	}
	
	public double getAmount(String userAction) {
		UserOutput.consoleStringPrinter("Enter the amount "+ userAction +" :");
		double amount = UserInputs.getDoubleUserInput();
		return amount;
	}
}
