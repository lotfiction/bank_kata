package me.kata.bank;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import me.kata.bank.model.Account;
import me.kata.bank.model.Statement;
import me.kata.bank.service.AccountServices;

public class AccountServicesTest {
	
	private static AccountServices accountServices = new AccountServices();
	
	@BeforeClass
	public static void beforeTest() {
		System.out.println("AccountServices tests start");
		accountServices.createAccount();//add the first account (with number = 1)
	}
	
	@AfterClass
	public static void afterTest() {
		System.out.println("AccountServices tests end.");
	}
	
	@Test
	public void createAccountTest() {
		Account account = accountServices.createAccount();
		Assert.assertNotNull(account);
		Assert.assertEquals(2, account.getNumber());
		Assert.assertEquals(0d, account.getBalance(), 0d);
		Assert.assertTrue(account.getStatements().isEmpty());
	}
	
	@Test
	public void findAccountTest() {
		Account account = accountServices.findAccountByNumber(10);
		Assert.assertNull("Account does not exist yet", account);
		
		account = accountServices.findAccountByNumber(1);
		Assert.assertNotNull(account);
	}
	
	@Test
	public void depositTest() {
		double depositAmount = 10;
		
		Account account = accountServices.findAccountByNumber(1);
		
		Assert.assertEquals(0d, account.getBalance(), 0d);
		Assert.assertTrue(account.getStatements().isEmpty());
		
		accountServices.deposit(depositAmount, account);
		
		Assert.assertEquals(depositAmount, account.getBalance(), 0d);
		Assert.assertFalse(account.getStatements().isEmpty());
		Assert.assertTrue(account.getStatements().size() == 1);
		
		Statement statement = account.getStatements().get(0);
		Assert.assertNotNull(statement);
		Assert.assertNotNull(statement.getDate());
		Assert.assertEquals(statement.getAmount(), account.getBalance(), 0d);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Assert.assertEquals(statement.dateToString(statement.getDate()), dateFormat.format(new Date()));
		Assert.assertEquals(statement.dateToString(null), "");
		
		DecimalFormat amountFormat = new DecimalFormat("#.00");
		Assert.assertEquals(statement.amountToString(statement.getAmount()), amountFormat.format(depositAmount));
	}
	
	@Test
	public void withdrawalTest() {
		AccountServices accountServices = new AccountServices();
		Account account = accountServices.createAccount();
		
		accountServices.deposit(20, account);
		Assert.assertEquals(account.getBalance(), 20, 0);
		
		accountServices.withdrawal(10, account);
		Assert.assertEquals(account.getBalance(), 20 - 10, 0);
	}

}
