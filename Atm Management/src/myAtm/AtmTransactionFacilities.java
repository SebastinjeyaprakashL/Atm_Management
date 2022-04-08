package myAtm;

public interface AtmTransactionFacilities {
	public void withdraw(Account account);
	public void deposit(Account account);
	public void checkBalance(Account account);
}
