package myAtm;

import java.util.ArrayList;

import consoleInputOutput.UserOutput;

public class Account {

	private static int newAccountIdSeq = 0;
	private int accountId;
	private User accountHolder;
	private double accountBalance;
	private ArrayList <DebitCard>debitCards;
	public Account(User newUser, Bank bank, double initialBalance ) {
		this.accountId = newAccountIdSeq + 1;
		this.accountHolder = newUser;
		this.accountBalance = initialBalance;
		newAccountIdSeq ++;
		this.debitCards = new ArrayList <DebitCard>();
		UserOutput.consoleStringPrinter("UserId : "+newUser.getUserId()+ " - Account Id : "+this.accountId + " Account Balance :"
				+ this.accountBalance);
	}
	public int getAccountId() {
		return this.accountId;
	}
	public void addDebitCard(DebitCard newDebitCard) {
		this.debitCards.add(newDebitCard);
		
	}
	public String getName() {	
		return this.accountHolder.getName();
	}
	public double getBalance() {
		return this.accountBalance;
	}
	public void setBalance (double newBalance) {
		this.accountBalance = newBalance;
	}
	public void printAccountsSummary() {
		UserOutput.consoleStringPrinter("Welcome "+ getName());
	}
	
	
}
