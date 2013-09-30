import java.util.ArrayList;


public class PersonInspector {
	
	public static ArrayList<String> classNames(ArrayList<Person> list) {
		ArrayList<String> ret = new ArrayList<>();
		
		for (Person p : list) {
			String str = p.getClass().toString();
			if (ret.contains(str)) continue;
			ret.add(str);
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		Person p = new Person();
		Employee e = new Employee("Name", "HA", "WA", 1);
		Student s = new Student("Name", "HA", "CA");
		ArrayList<Person> list = new ArrayList<>();
		list.add(p);
		list.add(e);
		list.add(s);
		System.out.println(classNames(list));
	}
	
}
