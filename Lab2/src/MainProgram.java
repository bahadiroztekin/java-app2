import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		ArrayList<Person> persons = new ArrayList<Person>();
		ArrayList<Bank> banks = new ArrayList<Bank>();
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		int pc = 0; // person counter
		int bc = 0; // bank counter
		int bac = 0; // bank account counter

		while (true) {

			System.out.println("Enter a command:");
			String input = sc.nextLine();
			String[] inputList = input.split(" ");

			if ("Q".equalsIgnoreCase(input)) {
				break;
			}

			switch (inputList[0]) {

			case "createPerson":
				String firstName = inputList[1];
				String lastName = inputList[2];
				String birthDay = inputList[3];
				String street = inputList[4];
				String city = inputList[5];
				String postCode = inputList[6];
				String country = inputList[7];
				Address totalAddressPerson = new Address(street, city, postCode, country);
				Person totalPerson = new Person(firstName, lastName, birthDay, totalAddressPerson);
				persons.add(totalPerson);
				System.out.println(persons.get(pc));
				pc++;
				break;

			case "createBank":
				String bankName = inputList[1];
				street = inputList[2];
				city = inputList[3];
				postCode = inputList[4];
				country = inputList[5];
				Address totalAddressBank = new Address(street, city, postCode, country);
				Bank totalBank = new Bank(bankName, totalAddressBank);
				banks.add(totalBank);
				System.out.println(banks.get(bc));
				bc++;
				break;

			case "createBankAccount":
				int personIndex = Integer.parseInt(inputList[1]);
				int bankIndex = Integer.parseInt(inputList[2]);
				double balance = Double.parseDouble(inputList[3]);
				int accountNumber = Integer.parseInt(inputList[4]);
				Person selectedPerson = persons.get(personIndex);
				Bank selectedBank = banks.get(bankIndex);
				BankAccount selectedBankAccount = new BankAccount(selectedBank, selectedPerson, balance, accountNumber);
				accounts.add(selectedBankAccount);
				System.out.println(accounts.get(bac));
				bac++;
				break;

			case "withdraw":
				accountNumber = Integer.parseInt(inputList[1]);
				double amount = Double.parseDouble(inputList[2]);
				double returnOfWithdraw;

				for (int i = 0; i < bac; i++) {

					if (accounts.get(i).accountNumber == accountNumber ) {
						returnOfWithdraw = accounts.get(i).withdraw(amount);
						if (returnOfWithdraw != -1) {
							System.out.println(accounts.get(i));
						}
						else
							System.out.println("Cannot withdraw a bigger amount than balance.");
							
					}
				}
				break;

			case "deposit":
				accountNumber = Integer.parseInt(inputList[1]);
				amount = Double.parseDouble(inputList[2]);

				for (int i = 0; i < bac; i++) {
					
					if (accounts.get(i).accountNumber == accountNumber ) {
						accounts.get(i).deposit(amount);
						System.out.println(accounts.get(i));
						
					}
				}
				break;
				
			case "transferBetween":	
				int account1 = Integer.parseInt(inputList[1]);
				int account2 = Integer.parseInt(inputList[2]);
				amount = Double.parseDouble(inputList[3]);
				boolean returnOfTransferTo;
				
				for(int i=0; i < bac; i++) {
					if (accounts.get(i).accountNumber == account1) {
						for (int j=0; j < bac; j++) {
							if (accounts.get(j).accountNumber == account2) {
								returnOfTransferTo = accounts.get(i).transferTo(amount, accounts.get(j));
								if (returnOfTransferTo == true) {
								System.out.println(accounts.get(i));
								System.out.println(accounts.get(j));
								}
							}
						}
					}
				}
				break;

			}

		}

	}
}