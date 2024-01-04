package Login;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Login.wallet;

public class roleOfCamera {
    public int cameraId;
	public String Brand;
	public String Model;
	public double PricePerDay;
	public boolean isRented;

   
	public roleOfCamera(int cameraId,String brand, String model, double pricePerDay) {
		super();
		this.cameraId=cameraId;
		Brand = brand;
		Model = model;
		PricePerDay = pricePerDay;
		this.isRented = false;
	}

	public static List<roleOfCamera> cameraList = new ArrayList<>();
	
   public static void InitializeList() {
	   cameraList.add(new roleOfCamera(1,"Canon", "EOS-R10", 6000));
	   cameraList.add(new roleOfCamera(2,"Sony", "ALPHA", 9000));
	   cameraList.add(new roleOfCamera(3,"DSLR","360", 10000));
	   cameraList.add(new roleOfCamera(4,"Panasonic","Lumix-BS1H", 7000));
	   cameraList.add(new roleOfCamera(5,"Sony","A7C", 8000));
	   cameraList.add(new roleOfCamera(6,"Nikon","Z5", 3000));
	   cameraList.add(new roleOfCamera(7,"Sony","A6600", 5000));
	   cameraList.add(new roleOfCamera(8,"Kodak","PIXPRo", 7000));
   }
   
   

	public int getCameraId() {
	return cameraId;
}


public void setCameraId(int cameraId) {
	this.cameraId = cameraId;
}


	public String getBrand() {
		return Brand;
	}


	public String getModel() {
		return Model;
	}


	public double getPricePerDay() {
		return PricePerDay;
	}


	public boolean isRented() {
		return isRented;
	}



	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}





	@Override
	public String toString() {
		return "roleOfCamera [Brand=" + Brand + ", Model=" + Model + ", PricePerDay=" + PricePerDay + ", isRented="
				+ isRented + "]";
	}



	public static void remove(int cameraId) {
		// TODO Auto-generated method stub
			
        if(cameraId>0 && cameraId<cameraList.size()) {
        	cameraList.remove(cameraId);
        	System.out.println("Camera successfully removed from the list.");
        }
        else {
        	System.out.println("CameraId not found");
        }
	}

	public static void displayAllCameras() {
		// TODO Auto-generated method stub
		
		if(cameraList.isEmpty()) {
			System.out.println("Your Camera list is empty");
		}
		else {
			System.out.printf("%-10s %-10s %-10s %-10s %-10s\n","CAMERA ID", "BRAND", "MODEL", "PRICE", "STATUS");
			
			int id=2;
            for(roleOfCamera camera:cameraList) {
            	System.out.printf("%-10s %-10s %-10s %-10.1f %-10s\n",id++, camera.getBrand(), camera.getModel(),
                        camera.getPricePerDay(), camera.isRented() ? "Rented" : "Available");

            }

		}
		
	}


	public static  void addCamera() {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);

		
		System.out.println("Enter the camera brand: ");
		String brand=scan.next();

		System.out.println("Enter the camera model: ");
		String model=scan.next();

		System.out.println("Enter Price/day (INR): ");
		double PricePerDay=scan.nextDouble();

		roleOfCamera temp=cameraList.get(cameraList.size()-1);
		int newCamId=temp.getCameraId()+1;
		roleOfCamera newCamera=new roleOfCamera(newCamId,brand,model,PricePerDay);
		cameraList.add(newCamera);
		
	
        System.out.println("Your camera has been successfully added to the list.");
	}

	
	public static void rentCamera() {
		Scanner sc=new Scanner(System.in);
		
		displayAllCameras();
		
		if(cameraList.isEmpty()) {
			System.out.println("Now,No camera available for rent");
			return;
		}
		
	System.out.println("Enter the camera id you want to rent");
	
	int cameraId=sc.nextInt();
	
	if(cameraId>=0 && cameraId<cameraList.size()) {
		roleOfCamera camera=cameraList.get(cameraId);
		
		if(camera.isRented()) {
			System.out.println("Already rented");
		}
		
		else {
			if(wallet.getBalance()>camera.getPricePerDay()) {
				
				wallet.withdraw(camera.getPricePerDay());
				camera.setRented(true);
				
				String output="Your Transaction for camera"+camera.getBrand() +" "+camera.getModel()+" With RENT INR." +camera.getPricePerDay()+"HAS SUCCESSFULLY COMPLETED";
				System.out.println(output);
			}
			else {
				System.out.println("Insufficient wallet balance,please refill your wallet");
			}
		}
	}
	
	else {
		System.out.println("Invalid Camera id");
	}
	
	}
	
	

}
