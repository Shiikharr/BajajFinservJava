package Casestudy2OOpsJDBC;
import java.util.*;
import java.sql.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("====================Welcome To Online shopping====================");
		System.out.println("Press 1 to Register as new user.");
		System.out.println("Press 2 to Login as User");
		System.out.println("Press 3 to Login as Admin");
		System.out.println("==================================================================");
		int choice = sc.nextInt();
		
		do
		{
			switch(choice)
			{
				case 1://Registration of the user.
					Scanner sc1 = new Scanner(System.in);
					Users ob = new Users();
					System.out.println("Enter Name");
					ob.setName(sc1.nextLine());
					System.out.println("Enter Password");
					ob.setPassword(sc1.nextLine());
					System.out.println("Enter Email");
					ob.setEmail(sc1.nextLine());
					System.out.println("Enter Address");					ob.setAddress(sc1.nextLine());
					UsersDAO ud = new UsersDAO();
				try {
					ud.connect();
					ud.registerUser(ob);
					System.out.println("User Registered Successfully. Hello "+ob.name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
					break;
					
					
				case 2:
					UsersDAO d1 = new UsersDAO();
					Scanner sc2 = new Scanner(System.in);
					System.out.println("Enter your Email:");
					String uemail = sc2.nextLine();
					System.out.println("Enter your password:");
					String upass = sc2.nextLine();
					
					try 
					{
						d1.connect();
						
						if(upass.equals(d1.AuthUser(uemail)))
						{
							Users u1 = d1.getUser(uemail);
							System.out.println("====================Welcome "+u1.name+"=====================");
							System.out.println("Press 1 to View Products");
							System.out.println("Press 2 to Add product in cart");
							System.out.println("Press 3 to View Cart");
							System.out.println("Press 0 to Exit");
							System.out.println("===========================================================");
							int i=sc.nextInt();
							do
								{
									switch(i)
									{
										case 1:
											ProductsDAO pd1 = new ProductsDAO();
											pd1.connect();
											pd1.displayProducts();
											break;
										case 2:
											ProductsDAO pd2 = new ProductsDAO();
											System.out.println("Select a product by entering it's PID: ");
											Scanner sc3 = new Scanner(System.in);
											int pid = sc.nextInt();
											pd2.connect();
											//getting the product details and storing it in product object
											Product p1 = pd2.getProduct(pid);
											//Creating the cart object
											Cart c1 = new Cart(u1.name, p1.pname, p1.Pprice);
											//entering the values of cart object into the database;
											pd2.addToCart(c1);
											break;
										case 3:
											System.out.println("This is your cart: ");
											ProductsDAO pd3 = new ProductsDAO();
											pd3.connect();
											pd3.displayCart(u1.name);
											break;
										default:
											System.out.println("Invalid choice");
											break;
									}
									System.out.println("====================================================");
									System.out.println("Press 1 to View Products");
									System.out.println("Press 2 to Add product in cart");
									System.out.println("Press 3 to View Cart");
									System.out.println("Press 0 to Exit");
									System.out.println("====================================================");
									int j=sc.nextInt();
									i=j;
							}while(i!=0);
					}
					else
						System.out.println("Invalid email/password.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
					
				case 3:
					System.out.println("====================Welcome Admin====================");
					System.out.println("Press 1 to Add a product");
					System.out.println("Press 2 to delete a product");
					System.out.println("Press 3 to update a product");
					System.out.println("Press 4 to remove a user");
					System.out.println("Press 5 to add a user");
					System.out.println("=====================================================");
					int k=sc.nextInt();
					do
					{
						switch(k)
						{
							case 1:
								System.out.println("Add product");
								break;
							case 2:
								System.out.println("Delete products");
								break;
							case 3:
								System.out.println("Update Cart");
								break;
							case 4:
								System.out.println("Remove user");
								break;
							case 5:
								System.out.println("Add user");
								break;
							default:
								System.out.println("Remove user");
								break;
						}
						System.out.println("=====================================================");
						System.out.println("Press 1 to Add a product");
						System.out.println("Press 2 to delete a product");
						System.out.println("Press 3 to update a product");
						System.out.println("Press 4 to remove a user");
						System.out.println("Press 5 to add a user");
						System.out.println("=====================================================");
						int j=sc.nextInt();
						k=j;
					}while(k!=0);
					break;
					default:
						System.out.println("Invalid option");
			}
			System.out.println("====================Welcome To Online shopping====================");
			System.out.println("Press 1 to Register as new user.");
			System.out.println("Press 2 to Login as User");
			System.out.println("Press 3 to Login as Admin");
			System.out.println("Press 0 to Exit");
			System.out.println("==================================================================");
			int x=sc.nextInt();
			choice = x;
		}while(choice!=0);
		
		System.out.println("====================Thankyou for shopping==========================");
	}

}
