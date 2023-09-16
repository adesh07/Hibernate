package in.com.rays.model;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import in.com.rays.userDTO.UserDTO;

public class UserModel {

	public void add(UserDTO dto) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();

		session.close();
	}

	public void update(UserDTO dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session ss = sf.openSession();

		Transaction tx = ss.beginTransaction();

		ss.update(dto);

		tx.commit();

		ss.close();

	}

	public void delete(UserDTO dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session ss = sf.openSession();

		Transaction tx = ss.beginTransaction();

		ss.delete(dto);

		tx.commit();

		ss.close();

	}

	public UserDTO authenticate(String loginId, String password) {

		UserDTO dto = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session ss = sf.openSession();

		Transaction tx = ss.beginTransaction();

		Query q = ss.createQuery("from UserDTO where loginId=? and password=?");

		q.setString(0, loginId);
		q.setString(1, password);

		List list = q.list();

		if (list.size() > 0) {

			dto = (UserDTO) list.get(0);

		}
		tx.commit();

		ss.close();

		return dto;

	}

	public UserDTO findByPk(int id) {

		UserDTO dto = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session ss = sf.openSession();

		Transaction tx = ss.beginTransaction();

		dto = (UserDTO) ss.get(UserDTO.class, id);

		tx.commit();

		ss.close();

		return dto;
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session ss = sf.openSession();

		Criteria criteria = ss.createCriteria(UserDTO.class);

		if (dto != null) {

			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.eq("firstName", dto.getFirstName()));
			}
			if (dto.getDob() != null && dto.getDob().getTime() > 0) {
				criteria.add(Restrictions.eq("dob", dto.getDob()));
			}
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		List list = criteria.list();

		return list;
	}

}
