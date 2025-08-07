package com.foodapp.AfterLogin.customer;

import java.util.Scanner;

public class CustomerMenu {
	Scanner scanner;

	public CustomerMenu(Scanner scanner) {
		this.scanner = scanner;
	}

	public void customerMenu(int userId) {
		int check = 0;
		while (check == 0) {
			System.out.println("\n---------Customer Menu---------");
			System.out.println("1. Food List");
			System.out.println("2. Cart");
			System.out.println("3. Edit profile");
			System.out.println("4. Logout");
			int choice = 0;
			while (true) {
				System.out.print("Enter Your choice : ");
				if (scanner.hasNextInt()) {
					choice = scanner.nextInt();
					break;
				} else {
					System.out.println("Enter Integer only!!");
					scanner.next();
				}
			}

			switch (choice) {
			case 1:
				System.out.println("food list");
				break;

			case 2:
				System.out.println("cart");
				break;

			case 3:
				System.out.println("edit profile");
				break;

			case 4:
				System.out.println("Successfully logged out!");
				check = 1;
				break;
			default:
				System.out.println("Enter Correct option!1");

			}
		}
	}
}
