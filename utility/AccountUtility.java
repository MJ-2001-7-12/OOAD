package com.ilp.utility;

import java.util.ArrayList;

import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Services;
import com.ilp.service.AccountConfiguration;
import com.ilp.service.ManageAccount;
import com.ilp.service.ProductConfiguration;

public class AccountUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		ArrayList<Services> serviceList = new ArrayList<Services>();
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Account> accountList = new ArrayList<Account>();
		Customer customer = null;
		char goToMainMenu = 'y';
		while (goToMainMenu == 'y') {
			System.out.println("\n*******Welcome to Bank*******");
			System.out.println("1.Create Services \t 2.Create Product   \t 3.Create Accounts   \t");
			System.out.println("4.Manage Accounts \t 5.Display Accounts \t 6.Transaction Bill\t 7.Exit ");
			System.out.println("Enter your choice : ");
			
			int mainMenuChoice = scanner.nextInt();
			switch (mainMenuChoice) {
			case 1:
				serviceList.add(ProductConfiguration.createServices());
				break;
			case 2:
				productList.add(ProductConfiguration.createProducts(serviceList));
				break;
			case 3:
				customer = AccountConfiguration.createCustomer(productList,accountList);
				for (Account account : customer.getAccountList()) {
					System.out.println(account.getProduct().getProductName() + " created for "
							+ customer.getCustomerName() + " with the following services");
					for (Services service : account.getProduct().getServiceList()) {
						System.out.println(service.getServiceCode() + " : " + service.getServiceName());
					}
					System.out.println("\nAccount is active.!!!!!! \n");
				}
				break;
			case 4:
				ManageAccount.accountManagement(customer);
				break;
			case 5:
				AccountConfiguration.displayAccounts(customer);
				break;
			case 6:
				AccountConfiguration.transactionBill(customer);
				break;
			case 7:
				System.exit(0);
			}
			System.out.println("Do you want to continue to main menu(y/n):");
			goToMainMenu = scanner.next().charAt(0);
		}

	}

}
