import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import config.ConfigurationReview;
import controller.CustomerController;
import controller.ReviewController;
import controller.ShopController;
import model.Customer;
import model.Review;
import model.Shop;
import model.UserLogin;
import view.CustomerView;
import view.ShopView;

//interface Greeting{
//	public void greet(String name);//abstract method
//}

//class AA implements Greeting{
//
//	@Override
//	public void greet() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}
//CRUD -> create read update delete

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new ConfigurationReview(); // my sql driver loading
		CustomerController customerController = new CustomerController();
//		customerController.getALL();
//		customerController.getById(2);
//		customerController.getByGmail("cb@gmail.com");
//		CustomerController customerController = new CustomerController();
//
		CustomerView customerView = new CustomerView();
//		Customer obj = customerView.acceptCustomerInformation();
//		customerController.save(obj);
//		
//		System.out.println("Show Customer List: ");
//		List<Customer> customers = customerController.getALL();
//		customers.stream().forEach(cus -> System.out.println(cus));
//		
//		Stream API
//		customers.stream().forEach(cus -> System.out.println(cus));;

		// Login
//		UserLogin user = customerView.login();
//		Customer cc = customerController.checkUser(user);
//		System.out.println((cc == null) ? "Invalid user" : cc); // ternary operator

		// update
//		String pwd_reset = customerView.askChange(cc);
//		if(!pwd_reset.equalsIgnoreCase("Thank You")){
//			Customer cus = customerController.updatePwd(pwd_reset, cc);
//			System.out.println((cus == null)? "Can't reset pwd":cus);
//		}

		// delete
//		boolean isDelete = customerView.deleteAcc();
//		if (isDelete) {
//			String cus = customerController.deleteUser(cc);
//			System.out.println((cus == null) ? "Invalid user" : cus);
//		}
		ShopController shopController = new ShopController();
//		
////		shopController.getById(5);		// scanner nk request
//		
//		ShopView shopview = new ShopView();
////		Shop obj = shopview.acceptShopInformation();
////		shopController.save(obj);		// scanner nk request
////		System.out.println(shopController.save(obj));
//		
////		System.out.println("Show Shop List: ");
////		List<Shop> sh = shopController.getAll();
////		sh.stream().forEach(mise -> System.out.println(mise));		// stream API
//		
//		
//		ShopView shopView = new ShopView();
//		// delete
//		// ① 削除するか確認
//		boolean isDelete = shopView.confirmDeleteShop(); // object 
//		if (isDelete) {
//		    // shopname を入力
//		    String shopname = ShopView.deleteShop();
//		    // Shop オブジェクトを作る
//		    Shop shop = new Shop();
//		    shop.setShopname(shopname);
//		    // Controller の delete を呼ぶ
//		    String result = shopController.deleteShop(shop);
//		    // 結果表示
//		    System.out.println((result == null) ? "Invalid shop" : result);
//		}
		
		ReviewController reviewController = new ReviewController();
		Scanner sc = new Scanner(System.in);
		UserLogin user = customerView.login();
		Customer cc = customerController.checkUser(user);
		
		if(cc == null) {
			System.err.println("Login Fail.");
			System.exit(0);
		}
		
		List<Shop> sh = shopController.getAll();
		sh.stream().forEach(mise -> System.out.println(mise));
		
		System.out.print("Enter ID to give comment:");
		int review_shop = Integer.parseInt(sc.nextLine());
		if(review_shop < 0 || review_shop > sh.size()) {
			System.out.println("Invalid shop ID");
			System.exit(0);
		}
		System.out.print("Enter your comment:");
		String comment = sc.nextLine();
		
		Review review = new Review(cc.getUserId(), review_shop, comment);
		
		List<Review> reviews = reviewController.save(review);
		reviews.stream().forEach(rr -> System.out.println(rr));
	}

}