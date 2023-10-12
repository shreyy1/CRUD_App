package jdbcpackage;

import java.sql.*;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//CRUD Application GFG
		
//		1.Step Connect to the SQL DB
		Class.forName("com.mysql.cj.jdbc.Driver");//Name of the mysqlDriver
		Scanner sc=new Scanner(System.in);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","shreyas@mySQL");

//		2.Establish COnnection
		Statement st = con.createStatement();
		
		boolean flag=true;
		while(flag) {
			System.out.println("Enter the choice");	
			System.out.println("1.View the scoretable");
			System.out.println("2.Insert Values to scoretable");
			System.out.println("3.Update to scoretable");
			System.out.println("4.Delete from scoretable");
			System.out.println("5.Exit");
			
			int choice = sc.nextInt();
		
			System.out.println("----------------------------------------------------");
			
			switch( choice ) {
			case 1:
				viewTable(st);
				break;
			case 2:
				insertTable(st,sc);
				break;
			case 3:
				updateTable(st,sc);
				 break;
			
			case 4:
				deleteTable(st,sc);
				break;
				
			default:
				flag=false;
				System.out.println("Exited");
				break;	
					
			}
   }

}
	public static void viewTable(Statement st)throws Exception{
		String sql="SELECT * FROM scoretable;";
		
		ResultSet rs=st.executeQuery(sql);
		System.out.println("ID\t | Name\t |Runs\t |Balls\t");
		
		while(rs.next()) {
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t");
		
		}
	}
	public static void insertTable(Statement st,Scanner sc)throws Exception{
		//Insert
		System.out.println("Enter the ID");
		int id = sc.nextInt();
		System.out.println("Enter the Name of the Player");
		String name = sc.next();
		System.out.println("Enter the Runs Scored");
		int runs = sc.nextInt();
		System.out.println("Enter how many balls?");
		int balls = sc.nextInt();
		
		String insert="INSERT INTO scoretable VALUE(" + id + ",'" +name+ "' ,"+ runs +","+ balls + ");";
			int rows = st.executeUpdate(insert);
		System.out.println(rows+" Rows Inserted");
		System.out.println("----------------------------------------------------");
	}
	public static void updateTable(Statement st,Scanner sc)throws Exception{
		//Update
		System.out.println("Enter the ID");
		int id = sc.nextInt();
		System.out.println("Enter the Runs Scored");
		int runs = sc.nextInt();
		System.out.println("Enter how many balls?");
		int balls = sc.nextInt();
		 
		 String updatequery = "UPDATE scoretable SET runs = " + runs + ", balls = " + balls + " WHERE id = " + id + ";";

		
		 int rows =st.executeUpdate(updatequery);
		 System.out.println(rows+"Rows benn updaated");
		 System.out.println("----------------------------------------------------");
	}
	public static void deleteTable(Statement st,Scanner sc)throws Exception{
		//Delete
		System.out.println("Enter the id of the player to delete:");
		int id=sc.nextInt();
		String deletequery = "DELETE FROM scoretable WHERE id=id";
		int rows = st.executeUpdate(deletequery);
		System.out.println(rows+" Rows Deleted!");
		
	}
	
	
}
