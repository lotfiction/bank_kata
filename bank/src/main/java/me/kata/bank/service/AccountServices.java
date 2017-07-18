package me.kata.bank.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import me.kata.bank.model.Account;
import me.kata.bank.model.Statement;

public class AccountServices {
	
	private Integer nextAccountNumber = 1;
	private Map<Integer, Account> bankAccounts = new HashMap<>();
	
	/**
	 * Create a new account and manage account numbers.
	 * 
	 * @return a new account with a new number
	 */
	public Account createAccount() {
		Account newAccount = new Account(nextAccountNumber);
		bankAccounts.put(nextAccountNumber, newAccount);
		nextAccountNumber++;
		return newAccount;
	}
	
	/**
	 * Find an account by his number.
	 * 
	 * @param accountNumber : the number of account to find
	 * @return the found account or null
	 */
	public Account findAccountByNumber(int accountNumber) {
		return bankAccounts.get(Integer.valueOf(accountNumber));
	}
	
	/**
	 * Deposit amount on the account balance and add the operation statement.
	 * 
	 * @param amount : the amount to deposit
	 * @param account : the account concerned
	 */
	public void deposit(double amount, Account account) {
		double newBalance = account.getBalance() + amount;
		account.setBalance(newBalance);
		
		Statement statement = new Statement();
		statement.setAmount(amount);
		statement.setDate(new Date());
		statement.setBalance(newBalance);
		account.getStatements().add(statement);
	}
	
	/**
	 * Withdrawal amount from the account balance and add the operation statement.
	 * 
	 * @param amount : the amount to withdrawal
	 * @param account : the account concerned
	 */
	public void withdrawal(double amount, Account account) {
		if(amount <= account.getBalance()) {
			double newBalance = account.getBalance() - amount;
			account.setBalance(newBalance);
			
			Statement statement = new Statement();
			statement.setAmount(-amount);
			statement.setDate(new Date());
			statement.setBalance(newBalance);
			account.getStatements().add(statement);
		}
	}
	
	/**
	 * Print all the statements of an account.
	 * 
	 * @param account
	 */
	public void printStatements(Account account) {
		Printable header = () -> System.out.println("Date		Operation	Amount		New balance	");
		header.print();
		for(Statement statement : account.getStatements()) {
			statement.print();
		}
	}
}
