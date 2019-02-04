import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Crud {
	
	public static void insertData(){
		try {
			/*Oracle Connection
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:db11g","sys as sysdba","123");
			*/  
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tesjavamysql","root","");  
			PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?)");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter id:");  
			int id=Integer.parseInt(br.readLine());  
			System.out.println("enter name:");  
			String name=br.readLine();  
			System.out.println("enter age:");  
			int age=Integer.parseInt(br.readLine());  
			  
			ps.setInt(1,id);  
			ps.setString(2,name);  
			ps.setInt(3,age);  
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");
			con.close();
		}catch(Exception e){System.out.println(e);}
		  
	}
	
	public static void readData(){
		try{
			/*Oracle Connection
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:db11g","sys as sysdba","123");
			*/
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tesjavamysql","root","");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from emp");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}catch(Exception e){ System.out.println(e);}
	}
	
	public static void updateData() throws NumberFormatException, IOException{
		  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter id:");  
		int id=Integer.parseInt(br.readLine());  
		System.out.println("enter name:");  
		String name=br.readLine();  
		  
		try {
			/*Oracle Connection
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:db11g","sys as sysdba","123");
			*/
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tesjavamysql","root","");  
			PreparedStatement ps=con.prepareStatement("update emp set name=? where id=?");
			ps.setString(1,name);  
			ps.setInt(2,id);
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");
		}catch(Exception e) {System.out.println(e);}
	}
	
	public static void deleteData() throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter id:");  
		int id=Integer.parseInt(br.readLine());  
		  
		try {
			/*Oracle Connection
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:db11g","sys as sysdba","123");
			*/
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tesjavamysql","root","");  
			PreparedStatement ps=con.prepareStatement("delete from emp where id=?");  		
			ps.setInt(1,id);
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");
		}catch(Exception e) {System.out.println(e);}  
	}
}
