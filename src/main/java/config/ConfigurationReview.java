/**
 * DB 接続設定
 */

package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationReview {
	
	public Connection con;
	private static final String USERNAME = "root";
	private static final String PWD = "Mysqlroot10";

	public ConfigurationReview() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");	//library chate tr	
	}
	
	public static Connection getCon() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reviews",USERNAME,PWD);	//jdbc ny yr hmr ko chate chin tk database name ko htae
		return con;
	}

}
