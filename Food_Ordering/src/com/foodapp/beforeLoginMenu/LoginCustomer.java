package com.foodapp.beforeLoginMenu;

import java.util.Scanner;

import com.foodapp.AfterLogin.customer.CustomerMenu;
import com.foodapp.DBOperation.DataBaseOperation;
import com.foodapp.Validation.Validation;

public class LoginCustomer {
	Scanner scanner;
	public LoginCustomer(Scanner scanner) {
		this.scanner = scanner;
	}
	public void loginUser() {
		scanner.nextLine();
		System.out.println("\n-------Login as Customer--------");
		Validation validate = new Validation(scanner);
		String email = validate.inputEmailForLogin();
		String password = validate.inputPassword();
		
		if(DataBaseOperation.validateUser(email,password)) {
			int userId = DataBaseOperation.userId(email,password);
			CustomerMenu customerMenu = new CustomerMenu(scanner);
			customerMenu.customerMenu(userId);
		}else {
			System.out.println("Invalid Credentials");
		}
	}

}
