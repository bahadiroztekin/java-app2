
public class Person {

	String firstName, lastName, birthday;
	Address address;
	
	public Person (String firstName, String lastName, String birthday, Address address) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.address = address;
		
	}

	
	@Override
	public String toString() {
		return "Person [First Name= " + firstName + ", Last Name= " + lastName + ", Birthday= " + birthday + ", Address= "
				+ address + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
