package me.kata.bank.model;

import java.util.Date;

import me.kata.bank.service.Printable;

public class Statement implements Printable {
	
	private static final String DEPOSIT = "Deposit   ";
	private static final String WITHDRAWAL = "Withdrawal";
	
	private double amount;	//amount of the operation
	private Date date;		//date of the operation
	private double balance;	//balance after operation
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public void print() {
		StringBuilder line = new StringBuilder("");
		line.append(dateToString(date));//Date
		line.append("	" + (amount >= 0 ? DEPOSIT : WITHDRAWAL));//Operation
		line.append("	" + amountToString(Math.abs(amount)) + "	");//Amount
		line.append("	" + amountToString(balance) + "	");//New balance
		System.out.println(line.toString());
	}

}
