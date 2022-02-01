package Casestudy2OOpsJDBC;
import java.sql.*;

public class UsersDAO 
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
	
	public void registerUser(Users u)throws Exception
	{
		try 
		{
			String query = "insert into users(name, password, email, address) values(?,?,?,?)";
			PreparedStatement pst= con.prepareStatement(query);
			pst.setString(1, u.name);
			pst.setString(2, u.password);
			pst.setString(3, u.email);
			pst.setString(4, u.address);
			int count = pst.executeUpdate();
			System.out.println(count+" row/s affected");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public String AuthUser(String email)throws Exception
	{
		String query = "select password from users where email='"+email+"'";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String pass = rs.getString(1);
			return pass;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Users getUser(String emaill)throws Exception
	{
		String query = "select name,password,address from users where email='"+emaill+"'";
		try {
			Users u = new Users();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			u.name = rs.getString(1);
			u.password = rs.getString(2);
			u.email = emaill;
			u.address = rs.getString(3);
			return u;
		
		}
		catch(Exception e)
		{
			System.out.println("getUser caused exception");
		}
		return null;
	}
	public String getTotalPrice(String buyer_name)throws Exception
	{
		try
		{
			String query = "select sum(price) from cart where buyer_name = '"+buyer_name+"'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			return rs.getString(1);
		}
		catch(Exception e)
		{
			System.out.println("Exception caused by getTotalPrice");
		}
		return null;
	}
	public String getPriceOfEnteredItem(String buying_product)
	{
		try
		{
			String query = "select price from cart where product_name = '"+buying_product+"'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			return rs.getString(1);
		}
		catch(Exception e)
		{
			System.out.println("Exception caused by getPriceOfEnteredItem");
		}
		return null;
	}
	public String getShippingAddress(String name)throws Exception
	{
		try 
		{
			String query = "select address from users where name = '"+name+"'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			return rs.getString(1);
		}catch(Exception e)
		{
			System.out.println("Exception caused by getShippingAddress");
		}
		return null;
	}
}
