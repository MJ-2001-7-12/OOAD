package com.ilp.service;

import java.util.ArrayList;

import java.util.Scanner;

import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Services;

public class ProductConfiguration {

	public static Services createServices() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("What Service you want to add:");
		System.out.println("\nCash Withdrawal,Cash Deposit,ATM WIthdrawal,Internet Banking,Online Banking\n");
		System.out.println("Enter Service Code");
		String serviceCode = scanner.nextLine();
		System.out.println("Enter Service Name");
		String serviceName = scanner.nextLine();
		System.out.println("Enter transaction rate");
		double rate = scanner.nextDouble();
		return new Services(serviceCode, serviceName, rate);
	}

	public static Product createProducts(ArrayList<Services> serviceList) {
		// TODO Auto-generated method stub
		ArrayList<Services> serviceListForProduct = new ArrayList<Services>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("What product you want to add:");
		System.out.println("\nSavings Max Account,Current Account,Loan Account\n");

		System.out.println("Enter Product Code");
		String productCode = scanner.nextLine();
		System.out.println("Enter Product Name");
		String productName = scanner.nextLine();

		char continueToChoose = 'y';
		do {
			System.out.println("choose service you want to add to product(Enter Service Code)");
			for (Services service : serviceList) {
				System.out.println(service.getServiceCode() + ":" + service.getServiceName());
			}
			
			String choiceOfService = scanner.nextLine();
			for (Services service : serviceList) {
				if (service.getServiceCode().equals(choiceOfService)) {
					serviceListForProduct.add(service);
					break;
				}
			}
			System.out.println("Do you want to add another service(y/n)");
			continueToChoose = scanner.next().charAt(0);
		} while (continueToChoose == 'y');
		
		Product product = null;
		if(productName.equalsIgnoreCase("Savings Max Account")) {
			
			product =  new SavingsMaxAccount(productCode, productName, serviceListForProduct);
		}
		else if(productName.equalsIgnoreCase("Current Account")) {

			product = new CurrentAccount(productCode, productName, serviceListForProduct);
		}else if(productName.equalsIgnoreCase("Loan Account")) {

			product =  new LoanAccount(productCode, productName, serviceListForProduct);
		}
		return product; 
	}

}
