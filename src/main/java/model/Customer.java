/**
 * 顧客データの入れ物
 */

package model;

import java.time.LocalDate;
import java.util.Random;

public class Customer {
	private int userId;
	private String gmail;
	private long phone;
	private LocalDate dob;
	private String pwd;
	private String username;
	
	public Customer() {
		super();
	}

	public Customer(int userId, String gmail, long phone, LocalDate dob, String pwd, String username) {
		super();
		this.userId = userId;
		this.gmail = gmail;
		this.phone = phone;
		this.dob = dob;
		this.pwd = pwd;
		this.username = username;
	}

	public Customer(String gmail, long phone, LocalDate dob, String pwd) {
		super();
		this.gmail = gmail;
		this.phone = phone;
		this.dob = dob;
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", gmail=" + gmail + ", phone=" + phone + ", dob=" + dob + ", pwd=" + pwd
				+ ", username=" + username + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUser_name() {
		Random random = new Random();
		String name = "";
		
		for(int i=0; i <6;i++) {
			int num = random.nextInt(2);
			if(num ==0)
				name = random.nextInt(10)+name;
			else name = (char) (random.nextInt(26)+97)+name;
		}
		this.username = name;
	}

	public void setUser_name(String username) {
		this.username = username;
	}
	

}
