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
					System.out.println("Enter Address");					
					ob.setAddress(sc1.nextLine());
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
					System.out.println("==================");
					System.out.println("Enter your Email:");
					System.out.println("==================");
					String uemail = sc2.nextLine();
					System.out.println("====================");
					System.out.println("Enter your password:");
					System.out.println("====================");
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
											System.out.println("=======================================");
											System.out.println("Select a product by entering it's PID: ");
											System.out.println("=======================================");
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
											Scanner sc4 = new Scanner(System.in);
											System.out.println("======================================");
											System.out.println("Press 1 to buy a specific item.");
											System.out.println("Press 2 to buy all items in the cart.");
											System.out.println("======================================");
											Scanner sc5 = new Scanner(System.in);
											int b = sc5.nextInt();
											switch(b)
											{
											case 1:
												System.out.println("=======================================");
												System.out.println("Enter the product name you wish to buy:");
												System.out.println("=======================================");
												Scanner sc6 = new Scanner(System.in);
												String buyingProduct = sc6.nextLine();
												pd3.buyItemFromCart(u1.name, buyingProduct);
												System.out.println("you successfully bought "+buyingProduct+" item/s");
												System.out.println("Cart after buying.");
												pd3.displayCart(u1.name);
												break;
											case 2:
												pd3.buyAllItems(u1.name);
												System.out.println("====================================================");
												System.out.println("Congratulations you bought everything from the cart.");
												System.out.println("====================================================");
												pd3.displayCart(u1.name);
												break;
											default:
												System.out.println("Invalid choice");
												break;
											}
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
					//creating object of adminDAO to perform tasks by the admin
					AdminDAO a1 = new AdminDAO();
					Scanner sc7 = new Scanner(System.in);
					System.out.println("==================");
					System.out.println("Enter your Admin name:");
					System.out.println("==================");
					String aname = sc7.nextLine();
					System.out.println("====================");
					System.out.println("Enter your password:");
					System.out.println("====================");
					String apass = sc7.nextLine();
					try
					{
						a1.connect();
						if(apass.equals(a1.AuthAdmin(aname)))
						{
							System.out.println("====================Welcome Admin: "+aname+"====================");
							System.out.println("Press 1 to Add a product");
							System.out.println("Press 2 to View products");
							System.out.println("Press 3 to Delete a product");
							System.out.println("Press 4 to Display Users");
							System.out.println("Press 5 to add a user");
							System.out.println("Press 6 to Remove a user");
							System.out.println("Press 0 to Exit");
							System.out.println("=====================================================");
							int k=sc.nextInt();
							do
							{
								switch(k)
								{
									case 1:
										Scanner sc8 = new Scanner(System.in);
										System.out.println("Enter the Product Name:");
										String prod_name = sc8.nextLine();
										System.out.println("Enter the Product Price");
										String prod_price = sc8.nextLine();
										//adding the product into the database
										a1.addAProduct(prod_name, prod_price);
										break;
									case 2:
										ProductsDAO pd4= new ProductsDAO();
										pd4.connect();
										System.out.println("Your Products are: ");
										pd4.displayProducts();
										break;
									case 3:
										Scanner sc9 = new Scanner(System.in);
										ProductsDAO pd5 = new ProductsDAO();
										System.out.println("Enter the name of the product to be deleted: ");
										String prodd_name = sc9.nextLine();
										a1.delAProduct(prodd_name);
										System.out.println("Current Product list after deletion of "+prodd_name+" : ");
										pd5.connect();
										pd5.displayProducts();
										break;
									case 4:
										System.out.println("The Users are: ");
										a1.displayUsers();
										break;
									case 5:
										UsersDAO u2 = new UsersDAO();
										Scanner sc10 = new Scanner(System.in);
										Users ob2 = new Users();
										System.out.println("Enter Name");
										ob2.setName(sc10.nextLine());
										System.out.println("Enter Password");
										ob2.setPassword(sc10.nextLine());
										System.out.println("Enter Email");
										ob2.setEmail(sc10.nextLine());
										System.out.println("Enter Address");					
										ob2.setAddress(sc10.nextLine());
										try {
											u2.connect();
											u2.registerUser(ob2);
											System.out.println("User Registered Successfully. Hello "+ob2.name);
											} catch (Exception e) {
												System.out.println(e+" :Exception thrown in adding user.");;
											}	
										break;
									case 6:
										Scanner sc11 = new Scanner(System.in);
										System.out.println("Enter the name of the User to be deleted: ");
										String user_name = sc11.nextLine();
										a1.delAUser(user_name);
										System.out.println("User deleted successfully.");
										System.out.println("The Users are: ");
										a1.displayUsers();
										break;
									default:
										System.out.println("Invalid Choice.");
										break;
								}
								System.out.println("=====================================================");
								System.out.println("Press 1 to Add a product");
								System.out.println("Press 2 to View products");
								System.out.println("Press 3 to Delete a product");
								System.out.println("Press 4 to Display Users");
								System.out.println("Press 5 to add a user");
								System.out.println("Press 6 to Remove a user");
								System.out.println("Press 0 to Exit");
								System.out.println("=====================================================");
								int j=sc.nextInt();
								k=j;
							}while(k!=0);
						}
						else
						{
							System.out.println("Invalid Admin name/password");
						}
					}
					catch(Exception e)
					{
						System.out.println(e + " Exception cause in authorizing");
					}
					
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
