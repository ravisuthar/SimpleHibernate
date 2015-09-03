package com.netweb.xml;

public class Employee {
	/*
	 * All classes should contain an ID in order to allow easy identification of your objects within Hibernate and the database. 
	 * This property maps to the primary key column of a database table.
	 */
	private int id;
	private String firstName;
	private String lastName;
	private int salary;

	// All Java classes that will be persisted need a default constructor.
	public Employee() {
	}

	public Employee(String fname, String lname, int salary) {
		this.firstName = fname;
		this.lastName = lname;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}