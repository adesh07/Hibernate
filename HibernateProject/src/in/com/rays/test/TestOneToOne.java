package in.com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import in.com.one.to.one.Address;
import in.com.one.to.one.Employee;

public class TestOneToOne {

	public static void main(String[] args) {

		Address address = new Address();
		address.setId(1);
		address.setStreet("street-1");
		address.setCity("Indore");

		Employee emp = new Employee();
		emp.setId(1);
		emp.setFirstName("Mera");
		emp.setLastName("Naam");
		emp.setEmpAddress(address);

		SessionFactory sf = new Configuration().configure("hibernate02.cfg.xml").buildSessionFactory();

		Session ss = sf.openSession();

		Transaction tx = ss.beginTransaction();

		ss.save(emp);

		tx.commit();

		ss.close();

	}

}
