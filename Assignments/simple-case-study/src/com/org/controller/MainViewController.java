package com.org.controller;

import java.util.List;
import java.util.Scanner;

import com.org.exceptions.AccountDoesNotExistException;
import com.org.model.beans.Account;
import com.org.model.service.AccountService;
import com.org.model.util.ObjectFactory;

public class MainViewController {

	public static void main(String[] args) throws AccountDoesNotExistException {
		int option = 0;
		Scanner scanner = new Scanner(System.in);
		AccountService service = ObjectFactory.getAccountServiceInstance();
		do {
			System.out.println("1: Create Account \n2: Check Balance");
			System.out.println("3: Transfer Amount \n4: Sort Accounts by name \n5: Sort Accounts by account number \n6: Delete Account"
					+ "\n0: Exit");
			option = scanner.nextInt();
			List<Account> list = null;
			switch(option) {
			case 1: 
				System.out.println("Enter name ==>");
				Account account = new Account(scanner.next());
				Account createdAccount = service.createAccount(account);
				System.out.println(createdAccount);
				break;
				
			case 2: 
				System.out.println("Enter account number ==>");
				try 
				{
					double balance=service.getBalance(scanner.nextInt());
					System.out.println("Account Balance ==>"+balance);
				}
				catch(NullPointerException e)
				{
					System.out.println("Account not found");
				}
				break; 

			case 3: 
				System.out.println("Enter withdrawal account number ==>");
				int withdraw_acc = scanner.nextInt();
				System.out.println("Enter depositing account number ==>");
				int deposit_acc = scanner.nextInt();
				System.out.println("Enter amount to transfer ==>");
				double amount = scanner.nextInt();
				service.transfer(withdraw_acc, deposit_acc, amount);
				break; 
			
			case 4: 
				list = service.getAccountsSortedByName(); // HttpSession -> setAttribute("key", list) -> ${ }
				list.forEach(acc -> System.out.println(acc));
				break;
				
			case 5:
				list = service.getAccountsSortedByAccountNumber();
				list.forEach(acc -> System.out.println(acc));
				break;
			}
		} while(option != 0);
		
		scanner.close();
	}

}

