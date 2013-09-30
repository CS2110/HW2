import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

public class PersonTests {

	@Test
	public void testPersonOnly() {
		Person p1 = new Person("Jane", "100 Main St, Somewhere");
		Person p2 = new Person("Raul", "27 Elm St, Elsewhere");
		
		assertEquals("toString", "{Person: name=Jane, homeAddress=100 Main St, Somewhere|", p1.toString());
		assertEquals("toString", "{Person: name=Raul, homeAddress=27 Elm St, Elsewhere|", p2.toString());
	}
	@Test
	public void testPersonEmployee() {
		ArrayList<Person> list = new ArrayList<Person>();
		Person p = new Person("Mai", "3156 Grove Rd, Somewhere");
		list.add(p);
		p = new Employee("Don", "6562 Trask Way, Elsewhere", "Front Desk", 2110);
		list.add(p);
		
		assertEquals("toString", "{Person: name=Mai, homeAddress=3156 Grove Rd, Somewhere|", list.get(0).toString());
		assertEquals("toString", "{Empl: n=Don, ha=6562 Trask Way, Elsewhere, wa=Front Desk, id=2110}", list.get(1).toString());
	}
	@Test
	
	public void testPersonEmployeeStudent() {
		ArrayList<Person> list = new ArrayList<Person>();
		Person p = new Person("Mai", "3156 Grove Rd, Somewhere");
		list.add(p);
		p = new Employee("Don", "6562 Trask Way, Elsewhere", "Front Desk", 2110);
		list.add(p);
		// TODO: uncomment the following
		 p = new Student("Dana Wahoo", "21 Wahoo Ave, NOVA", "1 JPA, CVille, VA");
		 list.add(p);
		
		assertEquals("toString", "{Person: name=Mai, homeAddress=3156 Grove Rd, Somewhere|", list.get(0).toString());
		assertEquals("toString", "{Empl: n=Don, ha=6562 Trask Way, Elsewhere, wa=Front Desk, id=2110}", list.get(1).toString());
		// fail("Implement student and fix the junit to test it.");
		 assertEquals("toString", "Student [name=Dana Wahoo homeAddress=21 Wahoo Ave, NOVA campusAddress=1 JPA, CVille, VA gpa=0.0]", list.get(2).toString()); 
		 
		 for (int i = 0; i<list.size(); i++){
			 assertEquals("checking instance of person", true, list.get(i)instanceof Person);
			 assertEquals("checking Comparable type", true, list.get(i)instanceof Comparable<?>);
		 }
		 
	}
	public void testPerson(){
		ArrayList<Person> list = new ArrayList<Person>();
		Person p = new Person ("Jeff", "102 Rice");
		Person t = new Person ("Trisha", "101 Rice");
		list.add(p);
		list.add(t);
		Collections.sort(list, new CmpByName());
		assertEquals("people in order", "{Person: name=Jeff, homeAddress=102 Rice|", list.get(0).toString());
		Collections.sort(list, new CmpByAddress());
		assertEquals("people in order", "{Person: name=Trisha, homeAddress=101 Rice|", list.get(0).toString());
	}
	
	private class CmpByName implements Comparator<Person> {

		@Override
		public int compare(Person arg0, Person arg1) {
			return arg0.getName().compareTo(arg1.getName());
		}
		
	}
	
	private class CmpByAddress implements Comparator<Person> {

		@Override
		public int compare(Person o1, Person o2) {
			return o1.getAddress().compareTo(o2.getAddress());
		}
		
	}

}