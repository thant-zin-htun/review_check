package view;

import java.util.Scanner;

import model.Shop;

public class ShopView {
	
	Scanner sc = new Scanner(System.in);
	
	public Shop acceptShopInformation() {
		Shop shop = new Shop();
		System.out.print("Enter Shop Name:");
		shop.setShopname(sc.nextLine());
		System.out.print("Enter Shop Address:");
		shop.setAddress(sc.nextLine());
		return shop;
		
		
		 
	}
	
	// comfirm to delete shop
	public boolean confirmDeleteShop() {
		System.out.print("Do you want to delete your shop? (y/n)");
		char ch = sc.nextLine().charAt(0);
		return ch == 'y';
	}
	
	public static String deleteShop() {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Enter shop name to delete: ");
	    return sc.nextLine();
	}


}
