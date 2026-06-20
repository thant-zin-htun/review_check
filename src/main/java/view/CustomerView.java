/**
 * ユーザーから入力を受け取る
 */

package view;

import java.time.LocalDate;
import java.util.Scanner;

import model.Customer;
import model.UserLogin;

public class CustomerView {
	
	Scanner sc = new Scanner(System.in);
	
	public Customer acceptCustomerInformation() {
		Customer customer = new Customer();
		System.out.print("Enter gmail/email: ");
		customer.setGmail(sc.nextLine());
		System.out.print("Enter Phone: ");
		customer.setPhone(Long.parseLong(sc.nextLine()));
		System.out.print("Enter dob: ");
		customer.setDob(LocalDate.parse(sc.nextLine()));
		System.out.print("Enter pwd: ");
		customer.setPwd(sc.nextLine());
		customer.setUser_name();
		return customer;
		
		
	}
	
	public UserLogin login() {
		System.out.print("Enter gmail: ");
		String gmail = sc.nextLine();
		System.out.print("Enter password: ");
		String pwd = sc.nextLine();
		return new UserLogin(gmail,pwd);
	}
	
	public String askChange(Customer cc) {
		System.out.println("Password reset (y/n)");
		char ch = sc.nextLine().charAt(0);
		if(ch == 'y' || ch == 'Y') {
			System.out.println("Enter old password: ");
			String old = sc.nextLine();
			
			if(cc == null || !cc.getPwd().equals(old)) {
				System.out.println("Invalid pwd");
				System.exit(0);
			}
			System.out.print("Enter new password: ");
			String newpwd = sc.nextLine();
			System.out.print("Enter confirm password: ");
			String confirmpwd = sc.nextLine();
			if(!newpwd.equals(confirmpwd)) {
				System.out.println("New password is invalid");
				System.exit(0);
			}
			return  newpwd;
		}
		return "Thank You";
	}
	public boolean deleteAcc() {
		System.out.print("Do you want to delete your account? (y/n)");
		char ch = sc.nextLine().charAt(0);
		return ch == 'y';
	}
}
