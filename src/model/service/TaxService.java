package model.service;

public interface TaxService {

	double taxFee(double amount); //add juros
	double Interest(double amount, int month);//add juros
}
