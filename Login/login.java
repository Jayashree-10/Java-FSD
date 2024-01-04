package Login;


import java.util.Scanner;

import exception.loginException;



public class login {

		public static void main(String[] args) throws loginException {
		// TODO Auto-generated method stub

	    System.out.println("*********************************");
		System.out.println("| Welcome to Rent My Camera Shop |");
		System.out.println();
		System.out.println("|    Please Login to continue   |");
		System.out.println("*********************************");
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter your username: ");
		String username=sc.next();

		System.out.println("Enter your Password: ");
		String password=sc.next();
		
		if(username.equals("Admin") && password.equals("admin@123")) {
            roleOfCamera.InitializeList();
            
            System.out.println("Developed by Jayashree");
			mainMenu();
		}
		else {
		    System.out.println("- - - - - - - - - - - - - - -");
			System.out.println("| Invalid login credentials |");
			System.out.println("- - - - - - - - - - - - - - -");
			//throw new LoginException();
		}
	
		}
		
		public static void subMenu() {
			System.out.println(" ############## ");
			System.out.println("\n  1.ADD  \n  2.REMOVE  \n  3.VIEW MY CAMERA  \n  4.GO TO PREVIOUS MENU ");
			System.out.println(" ############## ");

			Scanner sc=new Scanner(System.in);
		
			int choice=sc.nextInt();
			//nested switch
			switch(choice) {
				case 1://add

					roleOfCamera.addCamera();
					subMenu();
					break;
					
					
				case 2: //remove
					roleOfCamera.displayAllCameras();
					System.out.println("Enter Camera id to delete");
				    int id=sc.nextInt();
				    roleOfCamera.remove(id);	
				    subMenu();
				    break;
				    
				    case 3://view my camera
				    	roleOfCamera.displayAllCameras();
						subMenu();
			    	
				    	break;
				    case 4://go back to previous menu
				    	 mainMenu();
				    	break;
				    	 }
			

			
			
		}
		
		
		
		
		public static void mainMenu() {
			System.out.println("- - - - - - - - - - - - - - ");
			System.out.println("\n 1.MY CAMERA \n 2.MY WALLET  \n 3.VIEW ALL CAMERA \n 4.RENT A CAMERA \n 5.EXIT");
			System.out.println("Enter your option from 1-5:");
			System.out.println("- - - - - - - - - - - - - -");
			Scanner sc=new Scanner(System.in);
			int option=sc.nextInt();

			switch(option) {

			case 1: 
				
				subMenu();
				break;
				
			
			case 2:

				wallet.manageWallet();
		    	 mainMenu();

				
				break;
				
			case 3:
				
				camList.view();
		    	 mainMenu();

				break;
			
				
			case 4:
				roleOfCamera.rentCamera();
		    	 mainMenu();

				break;
				
			case 5:
				System.out.println("Thank you!!");
				System.exit(0);
				
			
            default:
            	System.out.println("Invalid option choosen");
            	System.out.println("choose a range between 1-5");
            	mainMenu();
	
			}
		
	}




}

