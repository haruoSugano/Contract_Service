package model.service;

public class TaxPayPal implements TaxService {

	private static final double FEE_PERCENTAGE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01;
	
	@Override
	public double taxFee(double amount) {//2% de juros add 
		return amount * FEE_PERCENTAGE;
	}
	@Override
	public double Interest(double amount, int month) {//1% de juros add
		return amount * MONTHLY_INTEREST * month;
	}
	
	
}
