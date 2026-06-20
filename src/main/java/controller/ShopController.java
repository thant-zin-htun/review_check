/**
 * DB とやり取りする
 */

package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConfigurationReview;
import model.Customer;
import model.Shop;

public class ShopController {
	Connection con;

	public ShopController() throws SQLException {
		super();
		con = ConfigurationReview.getCon(); // connect with database
	}

	// 全件取得
	public List<Shop> getAll() throws SQLException {
		String getShop = "SELECT * FROM shop";
		PreparedStatement stmt = con.prepareStatement(getShop);
		ResultSet set = stmt.executeQuery();
		

		List<Shop> shops = new ArrayList<>();

		while (set.next()) {
			shops.add(convertDataToShop(set));
		}
		return shops;
	}

	// ID で検索
	public Shop getById(int id) throws SQLException {		// shop nk change 
		String getShop = "SELECT * FROM shop WHERE shopid=?";
		PreparedStatement stmt = con.prepareStatement(getShop);
		stmt.setInt(1, id);

		ResultSet set = stmt.executeQuery();
		if (set.next()) {
			Shop shop = convertDataToShop(set);
			return shop;		// early return
		}
		return null;
	}

	// 新規登録
	public Shop save(Shop shop) throws SQLException {		// shop nk change
		String saveShop = "INSERT INTO shop (shopname, address) VALUES (?, ?)";
		PreparedStatement stmt = con.prepareStatement(saveShop);
		stmt.setString(1, shop.getShopname());
		stmt.setString(2, shop.getAddress());

		int row = stmt.executeUpdate();
		if (row < 1) {
			System.out.println("Insert failed.");
			System.exit(0);
		}
		// Insert したデータを取得
	    String getShop = "select * from shop where shopname=? and address=?";
	    stmt = con.prepareStatement(getShop);
	    stmt.setString(1, shop.getShopname());
	    stmt.setString(2, shop.getAddress());

	    ResultSet set = stmt.executeQuery();

	    if (set.next()) {
	        //　ここで Shop に変換して返す
	        return convertDataToShop(set);
	    }
	    return null; // 通常ここには来ないが保険
	}
	
	// 更新（Update）
	public Shop update(Shop shop) throws SQLException {
	    String updateShop = "UPDATE shop SET shopname=?, address=? WHERE shopid=?";
	    PreparedStatement stmt = con.prepareStatement(updateShop);
	    stmt.setString(1, shop.getShopname());
	    stmt.setString(2, shop.getAddress());
	    stmt.setInt(3, shop.getShopId());

	    int row = stmt.executeUpdate();
	    if (row < 1) {
	        System.out.println("Update failed.");
	    }

	    // 更新後のデータを取得して返す
	    return getById(shop.getShopId());
	}
	
	public String deleteShop(Shop shop) throws SQLException {
		if (getByName(shop.getShopname()) != null) {
			String deleteShop = "DELETE FROM shop WHERE shopname=?";
			PreparedStatement stmt = con.prepareStatement(deleteShop);
			stmt.setString(1, shop.getShopname());
			int row = stmt.executeUpdate();
			return (row > 0) ? "Deleted" : "can not delete this shop";
		} else {
			return null;
		}
	}
	
	public Shop getByName(String shopname) throws SQLException {
		String getShop = "select * from shop where shopname = ?";
		PreparedStatement stmt = con.prepareStatement(getShop);
		stmt.setString(1, shopname);

		ResultSet set = stmt.executeQuery();
		if (set.next()) { // set -> Shop
			return convertDataToShop(set);
		} else {
			return null;
		}
	}



	// ResultSet → Shop オブジェクト変換
	private Shop convertDataToShop(ResultSet set) throws SQLException {
		Shop shop = new Shop();
		shop.setShopId(set.getInt("shopid"));
		shop.setShopname(set.getString("shopname"));
		shop.setAddress(set.getString("address"));
		return shop;
	}
}
