package com.company.xml;

import java.io.Serializable;

/**
 * The Class Employee.
 * 
 * @author ravi.suthar
 */
public class Employee implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1890573369085102597L;
	/*
	 * All classes should contain an ID in order to allow easy identification of your objects within Hibernate and the database. This property maps to the primary key column of a database table.
	 */
	/** The id. */
	private int id;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The salary. */
	private int salary;

	// All Java classes that will be persisted need a default constructor.
	/**
	 * Instantiates a new employee.
	 */
	public Employee() {
	}

	/**
	 * Instantiates a new employee.
	 * 
	 * @param fname
	 *            the fname
	 * @param lname
	 *            the lname
	 * @param salary
	 *            the salary
	 */
	public Employee(String fname, String lname, int salary) {
		this.firstName = fname;
		this.lastName = lname;
		this.salary = salary;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the first name.
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 * 
	 * @param first_name
	 *            the new first name
	 */
	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	/**
	 * Gets the last name.
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 * 
	 * @param last_name
	 *            the new last name
	 */
	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	/**
	 * Gets the salary.
	 * 
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * Sets the salary.
	 * 
	 * @param salary
	 *            the new salary
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + salary;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Employee other = (Employee) obj;
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (salary != other.salary) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + "]";
	}

}