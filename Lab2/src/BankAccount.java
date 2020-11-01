
public class BankAccount {

	Bank bank;
	Person owner;
	double balance;
	int accountNumber;

	public BankAccount(Bank bank, Person owner, double balance, int accountNumber) {

		this.bank = bank;
		this.owner = owner;
		this.balance = balance;
		this.accountNumber = accountNumber;

	}
	
	boolean transferTo(double amount, BankAccount toAccount) {
		
		if (this.balance < amount) {
			System.out.println("Cannot transfer a bigger amount than sender balance.");
			return false;
		}
		else {
			this.withdraw(amount);
			toAccount.deposit(amount);
			return true;
		}
			
	}
	
	double withdraw(double amount) {

		if (balance < amount) {
			return -1;
		} else {
			balance = balance - amount;
			return balance;
		}
	}

	double deposit(double amount) {

		balance = balance + amount;
		return balance;
	}

	@Override
	public String toString() {
		return "Bank Account Information: \n" + "Balance= " + balance + "\n" + "Account Number= " + accountNumber + "\n"
				+ bank + "\n" + owner;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

}
