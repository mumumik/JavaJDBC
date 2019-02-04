import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
public class JavaJDBC {

	public static void main(String[] args) throws SQLException, NumberFormatException, IOException {
		  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		
		do{ 
			System.out.println("CRUD Test :");
			System.out.println("1.Create");
			System.out.println("2.Read");
			System.out.println("3.Update");
			System.out.println("4.Delete");
			System.out.println("Press 'n' to exit");
			System.out.println("Choose Menu: ");  
			String s=br.readLine();  
			if(s.startsWith("n")){  
				break;  
			}
			switch(s) {
			case "1":
				Crud.insertData();
				break;
			case "2":
				Crud.readData();
				break;
			case "3":
				Crud.updateData();
				break;
			case "4":
				Crud.deleteData();
				break;
			}
		}while(true);
	}

}
