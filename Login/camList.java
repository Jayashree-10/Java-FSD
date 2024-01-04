package Login;

public class camList{

	public static void view(){
		
		System.out.println("List of All Available Camera: ");
		
				
		if(roleOfCamera.cameraList.isEmpty()) {
			
			System.out.println("No Cameras available at the moment");
           

		}
		
		else {
			System.out.printf("%-10s %-10s %-10s %-10s %-10s\n","CAMERA ID", "BRAND", "MODEL", "PRICE", "STATUS");
                     
          
           
            for(roleOfCamera camera:roleOfCamera.cameraList) {
            	System.out.printf("%-10s %-10s %-10s %-10.2f %-10s\n",camera.getCameraId(), camera.getBrand(), camera.getModel(),
                        camera.getPricePerDay(), camera.isRented() ? "Rented" : "Available");

            }
		
	}

	}

	 
	
}

