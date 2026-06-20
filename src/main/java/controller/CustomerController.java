/**
 * DB とやり取りする
 */

package controller;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConfigurationReview;
import model.Customer;
import model.UserLogin;

public class CustomerController {
	Connection con;

	public CustomerController() throws SQLException {
		super();
		con = ConfigurationReview.getCon(); // database chate lite tr
	}

	public List<Customer> getALL() throws SQLException {

		String getCustomer = "select * from customer";
		PreparedStatement stmt = con.prepareStatement(getCustomer);

		ResultSet set = stmt.executeQuery();

		List<Customer> customer = new ArrayList<>();

		while (set.next()) {
//			Customer cus = convertDataToCustomer(set);
//			customer.add(cus);
			customer.add(convertDataToCustomer(set));
		}
		return customer;
	}

	public void getById(int id) throws SQLException {		// shop nk change
		String getCustomer = "select * from customer where userId=?";
		PreparedStatement stmt = con.prepareStatement(getCustomer);
		stmt.setInt(1, id);
		ResultSet set = stmt.executeQuery();
		if (set.next()) { // set -> Customer
			Customer cus = convertDataToCustomer(set);

			System.out.println(cus);
		} else {
			System.out.println("Invalid Id");
		}
	}
	
	public Customer save(Customer customer) throws SQLException {
	    String saveCustomer = "insert into customer (gmail,phone,dob,pwd,username) values (?,?,?,?,?)";
	    PreparedStatement stmt = con.prepareStatement(saveCustomer);
	    stmt.setString(1, customer.getGmail());
	    stmt.setLong(2, customer.getPhone());
	    stmt.setObject(3, customer.getDob());
	    stmt.setString(4, customer.getPwd());
	    stmt.setString(5, customer.getUsername());

	    int row = stmt.executeUpdate();
	    if (row < 1) {
	        System.out.println("Insert can't done.");
	        System.exit(0);
	    }

	    // Insert したデータを取得
	    String getCustomer = "select * from customer where gmail=? and phone=?";
	    stmt = con.prepareStatement(getCustomer);
	    stmt.setString(1, customer.getGmail());
	    stmt.setLong(2, customer.getPhone());

	    ResultSet set = stmt.executeQuery();

	    if (set.next()) {
	        //　ここで Customer に変換して返す
	        return convertDataToCustomer(set);
	    }
	    return null; // 通常ここには来ないが保険
	}

	public Customer checkUser(UserLogin user) throws SQLException {
		// TODO Auto-generated method stub
		String checkUser = "select * from customer where gmail=? and pwd=?";
		PreparedStatement stmt = con.prepareStatement(checkUser);
		stmt.setString(1, user.getGmail());
		stmt.setString(2, user.getPwd());
		ResultSet set = stmt.executeQuery();
		if (set.next()) { // set -> Customer
			Customer cc = convertDataToCustomer(set);
			return cc;
		} else {
			return null;
		}

	}

	public Customer updatePwd(String pwd_reset, Customer cc) throws SQLException {
		if (getByGmail(cc.getGmail()) != null) {

			String updatePwd = "update customer set pwd=? where gmail=?";
			PreparedStatement stmt = con.prepareStatement(updatePwd);
			stmt.setString(1, pwd_reset);
			stmt.setString(2, cc.getGmail());
			int row = stmt.executeUpdate();
			if (row > 0) {
				return getByGmail(cc.getGmail());
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public String deleteUser(Customer cc) throws SQLException {
		if (getByGmail(cc.getGmail()) != null) {
			String deleteAcc = "DELETE FROM customer WHERE gmail=?";
			PreparedStatement stmt = con.prepareStatement(deleteAcc);
			stmt.setString(1, cc.getGmail());
			int row = stmt.executeUpdate();
			return (row > 0) ? "Deleted" : "can not delete this accout";
		} else {
			return null;
		}
	}

	public Customer convertDataToCustomer(ResultSet set) throws SQLException {
		Customer customer = new Customer();
		customer.setUserId(set.getInt(1));
		customer.setGmail(set.getString(2));
		customer.setPhone(set.getInt(3));
		customer.setDob(((Date) set.getObject(4)).toLocalDate());
		customer.setPwd(set.getString(5));
		customer.setUser_name(set.getString(6));
		return customer;
	}

	public Customer getByGmail(String gmail) throws SQLException {
		String getCustomer = "select * from customer where gmail = ?";
		PreparedStatement stmt = con.prepareStatement(getCustomer);
		stmt.setString(1, gmail);

		ResultSet set = stmt.executeQuery();
		if (set.next()) { // set -> Customer
			return convertDataToCustomer(set);
		} else {
			return null;
		}
	}

}
