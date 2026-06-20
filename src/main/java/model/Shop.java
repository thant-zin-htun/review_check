/**
 * お店のデータの入れ物
 */

package model;

public class Shop {

	private int shopId;
	private String shopName;
	private String address;

	public Shop() {
		super();
	}

	public Shop(String shopName, String address) {
		super();
		this.shopName = shopName;
		this.address = address;
	}

	public Shop(int shopId, String shopName, String address) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.address = address;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopname() {
		return shopName;
	}

	public void setShopname(String shopname) {
		this.shopName = shopname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopname=" + shopName + ", address=" + address + "]";
	}
}
