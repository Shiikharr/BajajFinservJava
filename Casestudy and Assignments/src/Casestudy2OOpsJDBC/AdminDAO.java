package Casestudy2OOpsJDBC;
import java.sql.*;
public class AdminDAO 
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
			System.out.println(e+" Exception thrown by connect() in AdminDAO");
		}
	}
	public String AuthAdmin(String aname)throws Exception
	{
		String query = "select admin_password from admins where admin_name='"+aname+"'";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String pass = rs.getString(1);
			return pass;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception caused by authAdmin, wrong name");
		}
		return null;
	}
	public void addAProduct(String prod_name, String prod_price)throws Exception
	{
		try {
		String query = "insert into products(product, price) values(?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, prod_name);
		ps.setString(2, prod_price);
		ps.executeUpdate();
		System.out.println("Product added successfully.");
		}
		catch(Exception e)
		{
			System.out.println(e+" Exception caused by addAProduct");
		}
	}
	public void delAProduct(String product_name)throws Exception
	{
		try 
		{
			String query = "delete from products where product = '"+product_name+"'";
			Statement st = con.createStatement();
			st.executeUpdate(query);
		}
		catch(Exception e)
		{
			System.out.println(e+" Exception caused by delAProduct");
		}
	}
	public void displayUsers()throws Exception
	{
		try 
		{
			String query = "select * from users";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				System.out.println("UID: "+rs.getInt(1)+"\tUser Name: "+rs.getString(2)+"\tPassword: "+rs.getString(3));
			}
		}catch(Exception e)
		{
			System.out.println(e+ " Exception caused in displayUsers method.");
		}
	}
	public void delAUser(String user_name)throws Exception
	{
		try 
		{
			String query = "delete from users where name = '"+user_name+"'";
			Statement st = con.createStatement();
			st.executeUpdate(query);
		}
		catch(Exception e)
		{
			System.out.println(e+" Exception caused by delAUser");
		}
	}
}
