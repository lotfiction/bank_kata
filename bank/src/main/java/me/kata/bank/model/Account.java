package me.kata.bank.model;

import java.util.ArrayList;
import java.util.List;

public class Account {

	private int number;
	private double balance;
	private List<Statement> statements;// list of operations of Deposit and Withdrawal

	public Account(int accountNumber) {
		this.number = accountNumber;
		this.balance = Double.valueOf(0d);
		this.statements = new ArrayList<>();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

}
