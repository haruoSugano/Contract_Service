package model.service;

import java.util.Calendar;
import java.util.Date;
import model.entities.Contract;
import model.entities.Installment;

public class ServicePayment {
	
	private TaxService taxService;//inversao de controle
	
	public ServicePayment(Integer month, TaxService taxService) {//Injecao de independencia
		this.taxService = taxService;
	}
	
	public void processContract (Contract contract, Integer month) {
		double basicQuota = contract.getTotalValue()/month;//divide a parcela ex: entrada de 600
		//basicQuota == 200
		for(int i = 1; i <= month; i++) {
			Date date = addMonths(contract.getDate(), i);//Add i meses, acrescentado a parcela
			double updateQuota = basicQuota + taxService.Interest(basicQuota, i);//taxa atualizada  juros add a cada mes  1%
			//updateQuota == 202
			double fullQuota = updateQuota + taxService.taxFee(updateQuota);// taxa de juros fixa de 2%
			//fullQuota == 206.04
			contract.addInstalment(new Installment(date,fullQuota));
		}
	}
	
	private Date addMonths(Date date, int month) {//Funcao auxiliar add meses a uma data
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);//apartir do calendario "date" 
		cal.add(Calendar.MONTH, month);// add month(n) meses a uma data
		return cal.getTime();
	}
	
}
