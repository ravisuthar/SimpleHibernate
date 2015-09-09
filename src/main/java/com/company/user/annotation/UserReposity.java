package com.company.user.annotation;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.company.utils.HibernateUtil;

/**
 * The Class UserReposity.
 * 
 * @author ravi.suthar
 */
public class UserReposity implements IUserRepository {

	/*
	 * Method to CREATE an employee in the database
	 * 
	 * @see com.netweb.annotation.IUserRepository#addEmployee(java.lang.String, java.lang.String, int)
	 */
	@Override
	public Integer addEmployee(String fname, String lname, int salary) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			User employee = new User();
			employee.setFirstName(fname);
			employee.setLastName(lname);
			employee.setSalary(salary);
			employeeID = (Integer) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

	/*
	 * Method to READ all the employees
	 * 
	 * @see com.netweb.annotation.IUserRepository#listEmployees()
	 */
	@Override
	public void listEmployees() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM User").list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				User employee = (User) iterator.next();
				System.out.print("First Name: " + employee.getFirstName());
				System.out.print("  Last Name: " + employee.getLastName());
				System.out.println("  Salary: " + employee.getSalary());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/*
	 * Method to UPDATE salary for an employee
	 * 
	 * @see com.netweb.annotation.IUserRepository#updateEmployee(java.lang.Integer, int)
	 */
	@Override
	public void updateEmployee(Integer EmployeeID, int salary) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User employee = session.get(User.class, EmployeeID);
			employee.setSalary(salary);
			session.update(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/*
	 * Method to DELETE an employee from the records
	 * 
	 * @see com.netweb.annotation.IUserRepository#deleteEmployee(java.lang.Integer)
	 */
	@Override
	public void deleteEmployee(Integer EmployeeID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User employee = session.get(User.class, EmployeeID);
			session.delete(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
