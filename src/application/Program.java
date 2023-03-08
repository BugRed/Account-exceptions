package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.WithdrawException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Holder: ");
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();

		Account acc = new Account(number, holder, balance, withdrawLimit);

		System.out.println(" ");
		System.out.print("Enter amount for withdraw: ");
		double withdraw = sc.nextDouble();

		try {
			
			acc.withdraw(withdraw);
			System.out.print("New Balance: " + acc.getBalance());
			
		} catch (WithdrawException e) {

			System.out.println("Withdraw error: " + e.getMessage());

		} catch (RuntimeException e) {
			
			System.out.println("Unexpected error");

		}

		sc.close();

	}

}
