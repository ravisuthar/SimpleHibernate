package com.netweb.xml;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		ManageEmployee ME = new ManageEmployee();

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

		// for (int i = 0; i < 10; i++) {
		// int k = ME.addEmployee(new Employee("first-" + i, "lname" + 1, (1000 * i)));
		// System.out.println(k);
		// }

		// ME.listEmployees();
		// ME.listEmployeesFirstName();
		ME.getEmployeeById(167);
	}

	/* Method to CREATE an employee in the database */
	public Integer addEmployee(String fname, String lname, int salary) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			Employee employee = new Employee(fname, lname, salary);
			employeeID = (Integer) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

	public Integer addEmployee(Employee emp) {
		Session session = factory.openSession();
		Transaction txn = null;
		Integer empId = 0;
		try {
			txn = session.beginTransaction();
			empId = (Integer) session.save(emp);
		} catch (HibernateException e) {
			if (txn != null)
				txn.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return empId;
	}

	/* Method to READ all the employees */
	public void listEmployees() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// List employees = session.createQuery("FROM com.netweb.xml.Employee").list();
			// List employees = session.createQuery("FROM com.netweb.xml.Employee").list();
			// List employees = session.createQuery("FROM Employee as E").list();
			List employees = session.createQuery("FROM Employee  E").list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.print("First Name: " + employee.getFirstName());
				System.out.print("  Last Name: " + employee.getLastName());
				System.out.println("  Salary: " + employee.getSalary());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to READ all the employees */
	public void listEmployeesFirstName() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<String> nameList = session.createQuery("SELECT E.firstName FROM Employee E").list();
			for (String name : nameList) {
				System.out.println(name);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to READ all the employees */
	public void getEmployeeById(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM Employee E WHERE E.id = :employee_id";
			Query query = session.createQuery(hql);
			query.setParameter("employee_id", id);

			List<String> employees = query.list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.print("First Name: " + employee.getFirstName());
				System.out.print("  Last Name: " + employee.getLastName());
				System.out.println("  Salary: " + employee.getSalary());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to UPDATE salary for an employee */
	public void updateEmployee(Integer EmployeeID, int salary) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = session.get(Employee.class, EmployeeID);
			employee.setSalary(salary);
			session.update(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE an employee from the records */
	public void deleteEmployee(Integer EmployeeID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = session.get(Employee.class, EmployeeID);
			session.delete(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
