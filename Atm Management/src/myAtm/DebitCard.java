package myAtm;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DebitCard {
	
	private Long cardNumber;
	private String cardName;
	private String expiryDate;
	private int cardPin;
	private int userId;
	private int accountId;
	
	public DebitCard(User user,Account newAccount, long cardNumber, int pin) {
		this.cardNumber = cardNumber;
		this.cardName = user.getName();
		this.cardPin = pin;
	    this.expiryDate = this.getExpiryDate();
	    this.userId = user.getUserId();
	    this.accountId = newAccount.getAccountId();
	}
	
	public String getExpiryDate () {
		Date date = new Date();
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.add(Calendar.YEAR, 10);
	    Date newDate = c.getTime();
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
	    return formatter.format(newDate);
	}

	public int getDebitPin() {
		return this.cardPin;
	}
	public long getDebitCardNumber() {
		return this.cardNumber;
	}

	public int getUserId() {
		return this.userId;
	}

	public int getAccounId() {
		return this.accountId;
	}

	
	
}
