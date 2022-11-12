package tw.dou.jdbclab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class JDBC01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		通用Code概念，換DB時只要換掉DB的Connector即可。

//		載入DB的驅動。		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver OK");
			
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
//		連線DB。
		try {
			
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1",prop);
			
//			操作DB,使用Statement(要選java.sql的)。
			Statement stmt = conn.createStatement();
			
			stmt.execute("CREATE DATABASE javalab");
			stmt.execute("USE javalab");
			stmt.execute("CREATE TABLE store(number char(1),name varchar(20),adress varchar(255))");
			stmt.executeUpdate("INSERT INTO store(number,name,adress) VALUE ('1','Dou','Taiwan')");		
			
			
			System.out.println("Conn OK");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		
		
		
	}

}
