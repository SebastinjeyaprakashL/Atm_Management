package myAtm;

import consoleInputOutput.UserInputs;
import consoleInputOutput.UserOutput;

public class AtmTransaction {
	protected Account account;
	protected static double accountBal;
	
	AtmTransaction(Account account){
		this.account = account;
		AtmTransaction.accountBal = this.account.getBalance();
	}

	public void updateBalance(double accountBal) {
		this.account.setBalance(accountBal);
	}

	
	public void checkBalance(Account account) {
		UserOutput.consoleStringPrinter("Account Balance : " + accountBal);
	}
	
	public double getAmountFromUserAsInput(String userAction) {
		UserOutput.consoleStringPrinter("Enter the amount "+ userAction +" :");
		double amount = UserInputs.getDoubleUserInput();
		return amount;
	}
}
