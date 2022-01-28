package casestudySingleInheritance;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		//Creating an object of the child class
		Donor ob = new Donor();
		
		System.out.println("Enter the name :");
		ob.setName(sc.nextLine());
		
		System.out.println("Enter Date of Birth :");
		ob.setDateOfBirth(sc.nextLine());
		
		System.out.println("Enter Gender :");
		ob.setGender(sc.nextLine());
		
		System.out.println("Enter Mobile Number :");
		ob.setMobileNumber(sc.nextLine());
		
		System.out.println("Enter Blood Group :");
		ob.setBloodGroup(sc.nextLine());
		
		System.out.println("Enter Blood Bank Name :");
		ob.setBloodBankName(sc.nextLine());
		
		System.out.println("Enter Donor Type :");
		ob.setDonorType(sc.nextLine());
		
		System.out.println("Enter Donation Date :");
		ob.setDonationDate(sc.nextLine());
		
		System.out.println();
		//Displaying all the details in the format described in the case study
		ob.displayDonationDetails();
	}

}
