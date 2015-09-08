package com.netweb.annotation;

/**
 * The Interface IUserRepository.
 * 
 * @author ravi.suthar
 * 
 */
public interface IUserRepository {

	/**
	 * Adds the employee.
	 * 
	 * @param fname
	 *            the fname
	 * @param lname
	 *            the lname
	 * @param salary
	 *            the salary
	 * @return the integer
	 */
	Integer addEmployee(String fname, String lname, int salary);

	/**
	 * List employees.
	 */
	void listEmployees();

	/**
	 * Update employee.
	 * 
	 * @param EmployeeID
	 *            the employee id
	 * @param salary
	 *            the salary
	 */
	void updateEmployee(Integer EmployeeID, int salary);

	/**
	 * Delete employee.
	 * 
	 * @param EmployeeID
	 *            the employee id
	 */
	void deleteEmployee(Integer EmployeeID);

}
