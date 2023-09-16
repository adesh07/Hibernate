package in.com.dity.check;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.rays.auction.AuctionItem;

public class DirtyCheck {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate01.cfg.xml").buildSessionFactory();

		Session ss = sf.openSession();

		Transaction tx = ss.beginTransaction();

		AuctionItem item = (AuctionItem) ss.get(AuctionItem.class, 1);
		item.setDescription("Taj Mahal");

		ss.save(item);

		tx.commit();

		ss.close();

	}

}
