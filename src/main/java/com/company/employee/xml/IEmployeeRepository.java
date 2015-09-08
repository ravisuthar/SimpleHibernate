package com.company.employee.xml;

/**
 * The Interface IEmployeeRepository.
 * 
 * @author ravi.suthar
 */
public interface IEmployeeRepository {

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
	 * Adds the employee.
	 * 
	 * @param emp
	 *            the emp
	 * @return the integer
	 */
	Integer addEmployee(Employee emp);

	/**
	 * List employees.
	 */
	void listEmployees();

	/**
	 * List employees first name.
	 */
	void listEmployeesFirstName();

	/**
	 * Gets the employee by id.
	 * 
	 * @param id
	 *            the id
	 * @return the employee by id
	 */
	void getEmployeeById(int id);

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

	/**
	 * Gets the highest salary.
	 * 
	 * @return the highest salary
	 */
	void getHighestSalary();

	/**
	 * Gets the native sql.
	 * 
	 * @return the native sql
	 */
	void getNativeSQL();

	void getScalarQuries();

	void getEntityQuries();

	void addEmployeesInBatch();

}
