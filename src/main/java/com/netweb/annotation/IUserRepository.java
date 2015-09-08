package com.netweb.annotation;

public interface IUserRepository {

	Integer addEmployee(String fname, String lname, int salary);

	void listEmployees();

	void updateEmployee(Integer EmployeeID, int salary);

	void deleteEmployee(Integer EmployeeID);

}
