package com.netweb.annotation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class User.
 * 
 * @author ravi.suthar
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5411851898642800345L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	/** The first name. */
	@Column(name = "first_name")
	private String firstName;

	/** The last name. */
	@Column(name = "last_name")
	private String lastName;

	/** The salary. */
	@Column(name = "salary")
	private int salary;

	/**
	 * Instantiates a new user.
	 */
	public User() {
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