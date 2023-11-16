package com.ilp.service;

import java.util.Scanner;


import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.SavingsMaxAccount;

public class ManageAccount {

	public static void accountManagement(Customer customer) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the customer Code:");
		String customerCode = scanner.nextLine();
		System.out.println(customer.getCustomerName() + " has the following accounts:");
		for (Account account : customer.getAccountList()) {
			System.out.println(
					(customer.getAccountList().indexOf(account) + 1) + "." + account.getProduct().getProductName());
		}
		System.out.println("Enter your choice:");
		int accountChoice = scanner.nextInt();
		Account selectedAccount = customer.getAccountList().get(accountChoice - 1);
		char continueToAccountManagement = 'y';
		do {
			System.out.println("Choose the Service you want to use :");
			System.out.println("\n1.Deposit\t2.Withdraw\t3.Display Balance");
			int manageAccountChoice = scanner.nextInt();
			switch (manageAccountChoice) {
			case 1:
				ManageAccount.depositMoney(selectedAccount);
				break;
			case 2:
				ManageAccount.WithdrawMoney(selectedAccount);
				break;
			case 3:
				AccountConfiguration.displayAccounts(customer);
				break;
			}

			System.out.println("Do you want to continue to Account Management(y/n)");
			continueToAccountManagement = scanner.next().charAt(0);

		} while (continueToAccountManagement == 'y');
	}

	private static void WithdrawMoney(Account selectedAccount) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the amount to be Withdraw:");
		double withdrawAmount = scanner.nextDouble();
		if (selectedAccount.getProduct() instanceof SavingsMaxAccount) {
			SavingsMaxAccount savingsMaxAccount = (SavingsMaxAccount) selectedAccount.getProduct();
			double minBalance = savingsMaxAccount.getMinimumBalance();
			if (selectedAccount.getAccountBalance() >= withdrawAmount + minBalance) {
				selectedAccount.setAccountBalance(selectedAccount.getAccountBalance() - withdrawAmount);
			} else {
				System.out.println("Cannot withdraw.Minimum Balance should be " + minBalance + "");
			}
		} else {
			selectedAccount.setAccountBalance(selectedAccount.getAccountBalance() - withdrawAmount);
		}
	}

	private static void depositMoney(Account selectedAccount) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		double depositAmount;
		System.out.println("Enter the amount to be deposited:");
		depositAmount = scanner.nextDouble();
		if (selectedAccount.getProduct() instanceof LoanAccount) {
			System.out.println("Which way you want to deposit money? ");
			System.out.println("1.Over the counter 2.Cheque");
			int depositChoice = scanner.nextInt();
			if (depositChoice == 2) {
				LoanAccount loanAccount = (LoanAccount) selectedAccount.getProduct();
				double chequeDeposit = loanAccount.getChequeDeposit();
				depositAmount -= depositAmount * chequeDeposit;
				double updatedBalance = (selectedAccount.getAccountBalance() + depositAmount);
				selectedAccount.setAccountBalance(updatedBalance);
			}
		} else {
			double updatedBalance = (selectedAccount.getAccountBalance() + depositAmount);
			selectedAccount.setAccountBalance(updatedBalance);
		}
	}

}
