
public class Student extends Person {
	private String campusAddress;
	private double gpa;
	
	public Student(String name, String homeAddress, String campusAddress){
		super(name, homeAddress);
		this.campusAddress = campusAddress;
		gpa = 0.0;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + " homeAddress=" + homeAddress +  " campusAddress=" + campusAddress + " gpa=" + gpa+ "]";
				
	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((campusAddress == null) ? 0 : campusAddress.hashCode());
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (campusAddress == null) {
			if (other.campusAddress != null)
				return false;
		} else if (!campusAddress.equals(other.campusAddress))
			return false;
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa))
			return false;
		return true;
	}
	
	
	
}
