/**
 * ログイン用データの入れ物
 */

package model;

public class UserLogin {
	private String pwd;
	private String gmail;
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserLogin(String gmail,String pwd) {
		super();
		this.pwd = pwd;
		this.gmail = gmail;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	@Override
	public String toString() {
		return "UserLogin [pwd=" + pwd + ", gmail=" + gmail + "]";
	}
	
}
