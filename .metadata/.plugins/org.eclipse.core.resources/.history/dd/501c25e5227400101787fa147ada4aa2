package com.foodapp.beforeLoginMenu;

import java.util.Scanner;

import com.foodapp.DBOperation.DataBaseOperation;
import com.foodapp.Validation.Validation;
import com.foodapp.entity.User;

public class RegisterCustomer {
	Scanner scanner;

	public RegisterCustomer(Scanner scanner) {
		this.scanner = scanner;
	}

	public User register() {
		System.out.println("\n------ Registration ------");
		scanner.nextLine();
		Validation validate = new Validation(scanner);
		String firstName = validate.correctName("First name");
		String lastName = validate.correctName("Last name");

		String address = validate.inputNonEmpty("Address");

		String email = validate.inputEmail();
		String mobile = validate.inputMobile();
		String password = validate.inputPassword();

		// Create and set the user object
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAddress(address);
		user.setEmailId(email);
		user.setMobileNo(mobile);
		user.setPassword(password);

		System.out.println("✅ Registration successful!");
		return user;
	}

	
}
