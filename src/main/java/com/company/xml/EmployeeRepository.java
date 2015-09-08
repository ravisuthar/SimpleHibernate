package com.company.xml;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

/**
 * The Class EmployeeRepository.
 * 
 * @author ravi.suthar
 */
public class EmployeeRepository implements IEmployeeRepository {

	/** The factory. */
	private static SessionFactory factory;

	/** The configuration. */
	private static Configuration configuration;

	static {
		try {
			configuration = new Configuration();
			configuration.configure();
			factory = configuration.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/*
	 * Method to CREATE an employee in the database (non-Javadoc)
	 * 
	 * @see com.netweb.xml.IEmployeeRepository#addEmployee(java.lang.String, java.lang.String, int)
	 */
	@Override
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
	 * (non-Javadoc)
	 * 
	 * @see com.netweb.xml.IEmployeeRepository#addEmployee(com.netweb.xml.Employee)
	 */
	@Override
	public Integer addEmployee(Employee emp) {
		Session session = factory.openSession();
		Transaction txn = null;
		Integer empId = 0;
		try {
			txn = session.beginTransaction();
			empId = (Integer) session.save(emp);
		} catch (HibernateException e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return empId;
	}

	/*
	 * Method to READ all the employees
	 * 
	 * @see com.netweb.xml.IEmployeeRepository#listEmployees()
	 */
	@Override
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
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/*
	 * Method to READ all the employees
	 * 
	 * @see com.netweb.xml.IEmployeeRepository#listEmployeesFirstName()
	 */
	@Override
	public void listEmployeesFirstName() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "SELECT E.firstName FROM Employee E";
			Query query = session.createQuery(hql);
			List<String> nameList = query.list();
			for (String name : nameList) {
				System.out.println(name);
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
	 * Method to READ all the employees
	 * 
	 * @see com.netweb.xml.IEmployeeRepository#getEmployeeById(int)
	 */
	@Override
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
	 * @see com.netweb.xml.IEmployeeRepository#updateEmployee(java.lang.Integer, int)
	 */
	@Override
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
	 * @see com.netweb.xml.IEmployeeRepository#deleteEmployee(java.lang.Integer)
	 */
	@Override
	public void deleteEmployee(Integer EmployeeID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = session.get(Employee.class, EmployeeID);
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

	@Override
	public void getHighestSalary() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// String hql = "select e1.id, e1.first_name. e1.last_name, e1.salary from employee e1 where e1.salary in (select max(e2.salary) from employee e2)";
			String hql = "from Employee";
			Query query = session.createQuery(hql);
			Criteria cr = session.createCriteria(Employee.class);
			Criterion salary = Restrictions.eq("salary", 5000);
			Criterion name = Restrictions.eq("first_name", "Zara");
			LogicalExpression orExp = Restrictions.or(salary, name);
			cr.add(orExp);
			List<String> employees = cr.list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
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

	@Override
	public void getNativeSQL() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "SELECT e1.id, e1.first_name, e1.last_name, e1.salary FROM employee e1 WHERE e1.salary IN (SELECT MAX(e2.salary) FROM employee e2)";
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			// String hql = "from Employee";
			// Query query = session.createQuery(hql);
			List<Employee> employees = query.list();
			System.out.println(employees);
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

	@Override
	public void getScalarQuries() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "SELECT first_name, salary FROM EMPLOYEE";
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List results = query.list();
			System.out.println(results);
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

	@Override
	public void getEntityQuries() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "SELECT * FROM EMPLOYEE";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Employee.class);
			List results = query.list();
			query.setCacheable(true);
			query.setCacheRegion("employee");
			System.out.println(results);
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

	/* Method to create employee records in batches */
	@Override
	public void addEmployeesInBatch() {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			for (int i = 0; i < 100000; i++) {
				String fname = "First Name " + i;
				String lname = "Last Name " + i;
				Integer salary = i;
				Employee employee = new Employee(fname, lname, salary);
				session.save(employee);
				if (i % 50 == 0) {
					session.flush();
					session.clear();
				}
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
		return;
	}

}
