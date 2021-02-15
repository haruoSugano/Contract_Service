package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ServicePayment;
import model.service.TaxPayPal;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter Contract date: ");
		System.out.print("Number contract: ");
		int number = sc.nextInt();
		System.out.print("Enter Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Total value: ");
		double totalValue = sc.nextDouble();

		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Enter the amount of installment: ");
		int month = sc.nextInt();
		
		ServicePayment service = new ServicePayment(month, new TaxPayPal());
		service.processContract(contract, month);
		
		System.out.println("Installments: ");
		for(Installment x : contract.getInstallments()) {
			System.out.println(x);
		}

	}

}
