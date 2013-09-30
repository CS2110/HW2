
public class Person implements Comparable<Person> {
	protected String name;
	protected String homeAddress;
	
	public Person(String name, String address) {
		this.name = name;
		this.homeAddress = address;
	}

	// best if classes that will be used as superclasses have a default constructor
	public Person() {
		this.name = "?";
		this.homeAddress = "?";
	}

	public String getMailingAddress() {
		return homeAddress;
	}
	
	public String toString() {
		return "{Person: name=" + name + ", homeAddress=" + homeAddress + "|";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return homeAddress;
	}

	public void setAddress(String address) {
		this.homeAddress = address;
	}

	public static void main(String[] args) {
		Person p1 = new Person("p1", "addr1");
		System.out.println(p1);
	}

	@Override
	public int compareTo(Person arg0) {
		// TODO Auto-generated method stub
		return this.name.compareTo(arg0.getName());
	}

}