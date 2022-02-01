package Casestudy2OOpsJDBC;

import java.sql.*;

public class ProductsDAO 
{
	Connection con = null;
	
	//To establish the connection with the database.
	public void connect()throws Exception
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudy", "root", "shik40100");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public void displayProducts()throws Exception
	{
		String query = "select * from products";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())
			{
				System.out.println("PID: "+rs.getInt(1)+"\tProduct: "+rs.getString(2)+"\tPrice: "+rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Product getProduct(int pid)throws Exception
	{
		String query = "select product, price from products where pid = '"+pid+"'";
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			Product p = new Product();
			p.pname = rs.getString(1);
			p.Pprice = rs.getString(2);
			return p;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public void addToCart(Cart c)
	{
		String query = "insert into cart(buyer_name, product_name, price) values(?,?,?)";
		try
		{
			PreparedStatement pt = con.prepareStatement(query);
			pt.setString(1, c.buyer_name);
			pt.setString(2, c.product_name);
			pt.setString(3, c.product_price);
			pt.executeUpdate();
			System.out.println("Product added to cart successfully.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void displayCart(String name)throws Exception
	{
		String query = "select * from cart where buyer_name = '"+name+"'";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			String userData = "";
			System.out.println("PID\tBuyer_name\tProduct_name\tPrice");
			while(rs.next())
			{
				userData = rs.getInt(1)+ "\t" + rs.getString(2)+ "\t\t" + rs.getString(3) + "\tRs." + rs.getString(4);
				System.out.println(userData);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void buyItemFromCart(String buyName, String productName)throws Exception
	{
		try{
			String query = "delete from cart where buyer_name = '"+buyName+"' and product_name = '"+productName+"'";
			Statement st = con.createStatement();
			st.executeUpdate(query);
			}
		catch(Exception e)
		{
			System.out.println("buyItemFromCart caused exception.");
		}
	}
	public void buyAllItems(String buyName)throws Exception
	{
		try{
			String query = "delete from cart where buyer_name = '"+buyName+"'";
			Statement st = con.createStatement();
			st.executeUpdate(query);
			}
		catch(Exception e)
		{
			System.out.println("buyAllItems caused exception."+e);
		}
	}
}
