package patterns.clone.company;

import java.util.ArrayList;
import java.util.List;

public class Company implements Cloneable {
	private String name;
	private List<Employee> employees = new ArrayList<>();

	public Company(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}
	
	public int getSize() {
		return employees.size();
	}
	
	public void addEmployee(Employee p) {
		this.employees.add(p);
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o.getClass() == this.getClass()) {
			Company c = (Company) o;
			return name.equals(c.name) && employees.equals(c.employees);
		} else {
			return false;
		}
	}

	@Override
	public Company clone() {
		try {
			Company c = (Company) super.clone();
			c.employees = new ArrayList<>();
			for(Employee e : employees) {
				c.employees.add(e.clone());
			}
			return c;
		} catch (CloneNotSupportedException e) {
			throw new InternalError("Couldn't Clone Company");
		}
	}
}
