package com.org.model.service;

import java.util.List;
import java.util.stream.Collectors;

import com.org.exceptions.AccountDoesNotExistException;
import com.org.model.beans.Account;
import com.org.model.dao.AccountDao;
import com.org.model.util.ObjectFactory;

public class AccountServiceImpl implements AccountService {

	
	private AccountDao accountDao = null;
	public AccountServiceImpl() {
		accountDao = ObjectFactory.getAccountDaoInstance();
	}
	
	
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDao.createAccount(account);
	}

	@Override
	public double getBalance(int accountNumber) {
		// TODO Auto-generated method stub
		return accountDao.getAccount(accountNumber).getBalance();
	}

	@Override
	public void transfer(int sourceAccount, int destincationAccount, double amount) throws AccountDoesNotExistException {
		// TODO Auto-generated method stub
		int withdraw_acc=0;
		int deposit_acc=0;
		List<Account> accounts = accountDao.getAccounts();
		Account withdraw = null,deposit = null;
		for (Account account : accounts)
		{
			if(account.getAccountNumber()==sourceAccount)
			{
				withdraw_acc=1;
				withdraw = account;
			}
			if(account.getAccountNumber()==destincationAccount)
			{
				deposit_acc=1;
				deposit = account;
			}
		}
		if(withdraw_acc!=1) 
		{
			throw new AccountDoesNotExistException("Withdrawal Account Doesn't Exist !!");
		}
		else if(deposit_acc!=1) 
		{
			throw new AccountDoesNotExistException("Deposit Account Doesn't Exist !!");
		}
		
		else
		{
			if(withdraw.getBalance()<amount) 
			{
				System.out.println("Insufficient bAccount Balance !!!!");
			}
			else 
			{
				double withdraw_bal=accountDao.updateBalance(sourceAccount, withdraw.getBalance()-amount).getBalance();
				double deposit_bal=accountDao.updateBalance(destincationAccount, deposit.getBalance()+amount).getBalance();
				System.out.println("Withrawer Account Balance =>"+withdraw_bal);
				System.out.println("Depositer Account Balance =>"+deposit_bal);
			}
		}

	}

	@Override
	public List<Account> getAccountsSortedByName() {
		List<Account> accounts = accountDao.getAccounts();
		List<Account> sortedAccount = accounts.stream()
		.sorted((account1, account2) -> account1.getCustomerName().compareTo(account2.getCustomerName()))
		.collect(Collectors.toList());
		
		return sortedAccount;
	}

	@Override
	public List<Account> getAccountsSortedByAccountNumber() {
		// TODO Auto-generated method stub
		List<Account> accounts = accountDao.getAccounts();
		List<Account> sortedAccount = accounts.stream()
		.sorted((account1, account2) -> account1.getAccountNumber()-account2.getAccountNumber())
		.collect(Collectors.toList());
		
		return sortedAccount;
	}

}
