package me.kata.bank;

import me.kata.bank.model.Account;
import me.kata.bank.service.AccountServices;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		AccountServices accountServices = new AccountServices();
		
		Account account = accountServices.createAccount();
		
		accountServices.deposit(1000, account);
		accountServices.deposit(2000, account);
		accountServices.withdrawal(250, account);
		accountServices.deposit(500, account);
		accountServices.withdrawal(800, account);
		
		accountServices.printStatements(account);
	}
}
