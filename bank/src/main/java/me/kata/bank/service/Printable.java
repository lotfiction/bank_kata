package me.kata.bank.service;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface Printable {
	
	public static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	public DecimalFormat amountFormat = new DecimalFormat("#.00");

	public default String dateToString(Date date) {
		return date != null ? dateFormat.format(date) : "";
	}
	
	public default String amountToString(double amount) {
		return amountFormat.format(amount);
	}
	
	public void print();
}
