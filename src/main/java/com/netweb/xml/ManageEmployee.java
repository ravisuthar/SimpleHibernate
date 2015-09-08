package com.netweb.xml;

public class ManageEmployee {

	public static void main(String[] args) {

		EmployeeRepository ME = new EmployeeRepository();

		/* Add few employee records in database */
		// Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
		// Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
		// Integer empID3 = ME.addEmployee("John", "Paul", 10000);

		/* List down all the employees */
		// ME.listEmployees();

		/* Update employee's records */
		// ME.updateEmployee(empID1, 5000);

		/* Delete an employee from the database */
		// ME.deleteEmployee(empID2);

		/* List down new list of the employees */
		// ME.listEmployees();

		// Add employee
		// for (int i = 0; i < 10; i++) {
		// int k = ME.addEmployee(new Employee("first-" + i, "lname" + 1, (1000 * i)));
		// System.out.println(k);
		// }

		/* List down all the employees */
		// ME.listEmployees();

		/* List down all the employees first names */
		// ME.listEmployeesFirstName();

		/* Get Employee details by employee id */
		ME.getEmployeeById(167);
	}

}
