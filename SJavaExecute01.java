package summer21jdbc;
import java.sql.*;
public class SJavaExecute01 {
	/*
	Not 1: DDL İfadeleri için(CREATE TABLE, DROP TABLE, ALTER TABLE) execute() yöntemini kullanın.
	Not 2: execute() yöntemi "boolean" değerini döndürür
	Not 3: execute() yöntemi, ResultSet nesnesini döndürürse true döndürür, aksi takdirde false döndürür
	Yani, DDL İfadeleri ile execute() yöntemini kullandığınızda false alırsınız.
	DQL İfadeleri ile execute() yöntemini kullandığınızda, doğruyu elde edeceksiniz.
	*/
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
		Statement st=con.createStatement();
		
		

	}

}
