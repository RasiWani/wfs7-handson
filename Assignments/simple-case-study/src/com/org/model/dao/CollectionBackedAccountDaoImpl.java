package com.org.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.org.model.beans.Account;

public class CollectionBackedAccountDaoImpl implements AccountDao {

	private static List<Account> database = new ArrayList<>();
	@Override
	public Account createAccount(Account account) {
		database.add(account);
		return account;
	}

	@Override
	public Account updateBalance(int accountNumber, double amount) {
		// TODO Auto-generated method stub
		List<Account> temp_data = database.stream().filter(item -> item.getAccountNumber()==accountNumber).collect(Collectors.toList());
		for (Account account : temp_data) 
		{
			account.setBalance(amount);
			return account;
		}
		return null;
	}

	@Override
	public Account getAccount(int accountNumber) {
		// TODO Auto-generated method stub
		List<Account> temp_data =database.stream().filter(item -> item.getAccountNumber()==accountNumber).collect(Collectors.toList());
		for(Account acc:temp_data)
		{
			return acc;
		}
		return null;
	}

	@Override
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return database;
	}

//	@Override
//	public Account debit(int accountNumber, double amount) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Account credit(int accountNumber, double amount) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void deleteAccount(int accountNumber) {
//		// TODO Auto-generated method stub
//		
//	}

}
