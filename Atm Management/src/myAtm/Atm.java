package myAtm;
import consoleInputOutput.*;
public class Atm {
	
	public static Account mainMenu(Bank bank) {
		long cardNumber;
		int pin;
		Account account;
		do {
			UserOutput.consoleStringPrinter("WELCOME, PLEASE INSERT YOUR CARD");
			//Here i'm getting card number from user
			
				UserOutput.consoleStringPrinter("Enter your card number :");
				cardNumber = UserInputs.getLongUserInput();
				UserOutput.consoleStringPrinter("Enter your pin number :");
				pin = UserInputs.getIntUserInput();
				account = bank.getAccountByCard(cardNumber,pin);
				if (account == null) {
					System.out.println("Incorrect card number/Pin, Please try again");	
				}
				
			
		}while (account == null);
		return account;
	}
	
	public static void printUserMenu (Account account) {
		account.printAccountsSummary ();

		int choice;
		do {
			System.out.printf("what would you like to do ?", account.getName());
			System.out.println ("\n1 - Withdraw"
							  + "\n2 - Deposit"
							  + "\n3 - View Balance"
							  + "\n4 - Quit");
			choice = UserInputs.getIntUserInput();
			
			if (choice < 1 || choice > 4) {
				System.out.println("Invalid choice, Please choose 1-5");
				
			}
		}while (choice < 1 || choice > 4);
		
		AtmTransaction newTransaction =new AtmTransaction(account);
		switch (choice) {
		case 1 : 
			newTransaction.withdraw(account);
			break;
		case 2 :
			newTransaction.deposit (account);
			break;
		case 3 :
			newTransaction.checkBalance (account);
			break;
		}
		
		if (choice != 4) {
			Atm.printUserMenu(account);
		}
	}
	
	public static void main(String [] args) {
		Bank bank = new Bank("Indian Bank");
		// created four user with userId , name, card Number, pin number;
		User newUser1 = bank.addUser(1,"user1",00001,1111);
		User newUser2 = bank.addUser(2,"user2",00002,2222);
		User newUser3 = bank.addUser(3,"user3",00003,3333);
		User newUser4 = bank.addUser(4,"user4",00004,4444);
		Account currentAccount;
		
		
		while(true) {
			currentAccount = Atm.mainMenu(bank);
			//System.out.println(currentUser.getUserId());
			Atm.printUserMenu(currentAccount);
		}
		
		
	}
}
