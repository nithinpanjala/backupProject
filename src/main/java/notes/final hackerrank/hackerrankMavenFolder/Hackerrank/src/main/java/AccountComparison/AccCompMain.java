package AccountComparison;

import java.util.Scanner;

import AccountComparison.Solution.Account;

public class AccCompMain {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("enter first account details");
		System.out.println("Enter no of regular movies :");
		int no_reg1 = scan.nextInt();
		System.out.println("Enter no of exclusive movies :");
		int no_exclusive1 = scan.nextInt();
		System.out.println("Enter Owner name :");

		String ownerName1 = scan.next();
		System.out.println("enter second account details");
		System.out.println("Enter no of regular movies :");
		int no_reg2 = scan.nextInt();
		System.out.println("Enter no of exclusive movies :");
		int no_exclusive2 = scan.nextInt();
		System.out.println("Enter Owner name :");
		String ownerName2 = scan.next();

		Account account1 = new Account(ownerName1, no_reg1, no_exclusive1);

		Account account2 = new Account(ownerName2, no_reg2, no_exclusive2);

		System.out.println("mothly cost");
		System.out.println(account1);
		System.out.println(account1.compareTo(account2));

		scan.close();

	}

}
