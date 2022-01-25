package casestudy1;
public class Person {
	
	private String name;
	private String dateOfBirth;
	private String gender;
	private String mobileNumber;
	private String bloodGroup;
	
	//Creating a non parameterized constructor
	Person()
	{
		
	}
	//Getting the value of name
	public String getName() {
		return name;
	}
	//Setting the value of name
	public void setName(String name) {
		this.name = name;
	}
	//Getting the value of dateOfBirth
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	//Setting the value of dateOfBirth
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	//Getting the value of gender
	public String getGender() {
		return gender;
	}
	//Setting the value of gender
	public void setGender(String gender) {
		this.gender = gender;
	}
	//Getting the value of mobileNumber
	public String getMobileNumber() {
		return mobileNumber;
	}
	//Setting the value of mobileNumber
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	//getting the value of bloodGroup
	public String getBloodGroup() {
		return bloodGroup;
	}
	//setting the value of bloodGroup
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	//function which will display the details
	public void displayDonationDetails()
	{
		System.out.println("Name : "+name);
		System.out.println("Date Of Birth : "+dateOfBirth);
		System.out.println("Gender : "+gender);
		System.out.println("Mobile Number : "+mobileNumber);
		System.out.println("Blood Group : "+bloodGroup);
	}
	
}
