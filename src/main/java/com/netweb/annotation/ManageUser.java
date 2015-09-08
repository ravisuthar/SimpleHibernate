package com.netweb.annotation;


public class ManageUser {

	public static void main(String[] args) {

		UserReposity ME = new UserReposity();

		/* Add few employee records in database */
		Integer empID1 = ME.addEmployee("Zara", "Alibaba", 1000);
		Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
		Integer empID3 = ME.addEmployee("John", "Paul1", 10000);
 
		/* List down all the employees */
		ME.listEmployees();

		/* Update employee's records */
		// ME.updateEmployee(empID1, 5000);

		/* Delete an employee from the database */
		// ME.deleteEmployee(empID2);

		/* List down new list of the employees */
		// ME.listEmployees();
	}

}