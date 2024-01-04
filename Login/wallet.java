package Login;

import java.util.Scanner;

import exception.invalidDecision;

public class wallet {

	public static double balance=20000;

	public wallet(double balance) {
		this.balance = balance;
	}

	public static float getBalance(){
		return (float) balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public static void deposit(double amount) {
        balance += amount;
    }
 
    public static boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public static void manageWallet() {
    	
    	Scanner sc=new Scanner(System.in);
    	
    	System.out.println("\n My Wallet\n");
    	System.out.println("Your current wallet balance is INR \n"+wallet.getBalance());
    	
    	
    	System.out.println("Do you want to add more");
    	System.out.println("\n 1.Yes \n 2.No");
    	
    	int decide=sc.nextInt();
    	
    	switch(decide) {
    	case 1:
    		System.out.println("Enter the amount(In INR)");
    		double amount=sc.nextDouble();
    		wallet.deposit(amount);
    		System.out.print("Your wallet balance updated successfully"+"\n"+" Your current balance:INR \n "+wallet.getBalance());
    		break;
    	
    	case 2:
    	
    	break;
    		
    	default: 
    		//throw new InvalidDecision();
    		System.out.println("Invalid Decision");
    	}
   
    }
 
}

