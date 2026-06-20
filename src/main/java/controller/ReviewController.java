package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConfigurationReview;
import model.Review;

public class ReviewController {
	Connection con;

	public ReviewController() throws SQLException {
		con = ConfigurationReview.getCon();	// database chate lite tr
	}
	
	public List<Review> getByIds(Review review) throws SQLException {
		String getByIds = "select * from review where userId=? and shopid=?";
		PreparedStatement stmt = con.prepareStatement(getByIds);
		stmt.setInt(1, review.getUser_id());
	    stmt.setInt(2, review.getShop_id());
		ResultSet set = stmt.executeQuery();
		
		List<Review> reviews = new ArrayList<>();
		while (set.next()) {
			Review re = new Review();
			re.setId(set.getInt(1));
			re.setUser_id(set.getInt(2));
			re.setShop_id(set.getInt(3));
			re.setComment(set.getString(4));
			reviews.add(re);

		}
		return reviews;
	}
	
	public List<Review> save(Review review) throws SQLException {
		String saveReview = "insert into review (userId,shopid,comment) values (?,?,?)";
	    PreparedStatement stmt = con.prepareStatement(saveReview);
	    stmt.setInt(1, review.getUser_id());
	    stmt.setInt(2, review.getShop_id());
	    stmt.setString(3, review.getComment());

	    int row = stmt.executeUpdate();
	    if (row < 1) {
	        System.out.println("Insert can't done.");
	        System.exit(0);
	    }
	    
	    return getByIds(review);
	}
	
	

}
