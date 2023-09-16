package in.com.dity.check;

import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import in.com.rays.auction.AuctionItem;
import in.com.rays.auction.Bid;

public class TransitivePersistence {

	public static void main(String[] args) {

		Bid bid = new Bid();
		bid.setId(5);
		bid.setAmount(5000);
		bid.setTimeStamp("AAAA");

		SessionFactory sf = new Configuration().configure("hibernate01.cfg.xml").buildSessionFactory();

		Session ss = sf.openSession();

		Transaction tx = ss.beginTransaction();

		AuctionItem item = (AuctionItem) ss.get(AuctionItem.class, 1);
		Set set = item.getBids();

		set.add(bid);

		tx.commit();

		ss.close();
	}

}
