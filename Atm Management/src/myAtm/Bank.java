package myAtm;

import java.util.ArrayList;

public class Bank {
	private String bankName;
	private ArrayList <User> users;
	private ArrayList<Account> accounts;
	private ArrayList <DebitCard> debitCards;
	
	public Bank(String bankName) {
		this.bankName = bankName;
		this.users = new ArrayList <User>();
		this.accounts = new ArrayList <Account>();
		this.debitCards = new ArrayList <DebitCard>();
	}

	public User addUser(int userId, String name, long cardNumber, int pin) {
		User newUser = new User (userId,name);
		this.users.add(newUser);
		
		Account newUserAccount = new Account (newUser,this, 1000);
		this.accounts.add(newUserAccount);
		
		DebitCard newDebitCard = new DebitCard (newUser,newUserAccount,cardNumber, pin);
		this.debitCards.add(newDebitCard);
		
		newUser.addAccount(newUserAccount);
		newUserAccount.addDebitCard(newDebitCard);
		return newUser;
	}

	public Account getAccountByCard(long cardNumber, int pin) {		
		int accountId;
		for (DebitCard d : this.debitCards) {
			if (d.getDebitCardNumber() == cardNumber && d.getDebitPin() == pin ) {
				accountId = d.getAccounId();
				for (Account account : this.accounts) {
					if (account.getAccountId() == accountId) {
						return account;
					}
				}
			}
		}
		return null;
	}	
	
}
