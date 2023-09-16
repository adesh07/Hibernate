package in.com.rays.auction;

import java.util.Set;

public class AuctionItem {

	private int id;
	private String description;
	private Set bids;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getBids() {
		return bids;
	}

	public void setBids(Set bids) {
		this.bids = bids;
	}

}
