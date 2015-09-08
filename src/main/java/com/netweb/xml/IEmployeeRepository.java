package com.netweb.xml;

public interface IEmployeeRepository {

	Integer addEmployee(String fname, String lname, int salary);

	Integer addEmployee(Employee emp);

	void listEmployees();

	void listEmployeesFirstName();

	void getEmployeeById(int id);

	void updateEmployee(Integer EmployeeID, int salary);

	void deleteEmployee(Integer EmployeeID);

}
