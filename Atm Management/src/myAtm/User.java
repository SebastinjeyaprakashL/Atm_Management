package myAtm;

import java.util.ArrayList;

import consoleInputOutput.UserOutput;

public class User {
	
	private String name;
	private int userId;
	private ArrayList <Account> accounts ;
	
	public User(int userId, String name) {
		try {
			this.userId = userId;
			this.name = name;
			this.accounts = new ArrayList<Account>();
			UserOutput.consoleStringPrinter("New User created with Id : "+userId+" for user : "+ name);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addAccount(Account newUserAccount) {
		this.accounts.add(newUserAccount);
	}

	public int getUserId () {
		return this.userId;
	}
	public String getName () {
		return this.name;
	}
	
	
}
