package com.netweb.xml;

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
}