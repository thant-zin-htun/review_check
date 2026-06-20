package model;

public class Review {
	private int id;
	private int user_id;
	private int shop_id;
	private String comment;
	

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Review(int user_id, int shop_id, String comment) {
		super();
		this.user_id = user_id;
		this.shop_id = shop_id;
		this.comment = comment;
	}
	
	public Review(int id, int user_id, int shop_id, String comment) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.shop_id = shop_id;
		this.comment = comment;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getShop_id() {
		return shop_id;
	}

	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}

	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", user_id=" + user_id + ", shop_id=" + shop_id + ", comment=" + comment + "]";
	}
	

}
