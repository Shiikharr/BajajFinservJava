package casestudySingleInheritance;
public class Donor extends Person {
	
	//Creating a non parameterized constructor
	Donor()
	{
	}
	
	private String bloodBankName;
	private String donorType;
	private String donationDate;
	
	//Getting the value of bloodBankName
	public String getBloodBankName() {
		return bloodBankName;
	}

	//Setting the value of bloodBankName
	public void setBloodBankName(String bloodBankName) {
		this.bloodBankName = bloodBankName;
	}

	//Getting the value of donorType
	public String getDonorType() {
		return donorType;
	}

	//Setting the value of donorType
	public void setDonorType(String donorType) {
		this.donorType = donorType;
	}

	//Getting the value of donationDate
	public String getDonationDate() {
		return donationDate;
	}

	//Setting the value of donationDate
	public void setDonationDate(String donationDate) {
		this.donationDate = donationDate;
	}
	
	// This method will first access the displayDonationDetails() methods from the parent
	// class which is class Person by using the super keyword,
	// after that it will access the rest of the function.
	public void displayDonationDetails()
	{
		System.out.println("Donation Details:\n");
		super.displayDonationDetails();
		
		System.out.println("Blood Bank Name : "+bloodBankName);
		System.out.println("Donor Type : "+donorType);
		System.out.println("Donation Date : "+donationDate);
	}

	
}
