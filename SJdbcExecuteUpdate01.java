package summer21jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SJdbcExecuteUpdate01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
		Statement st=con.createStatement();

		
		//		//1.Example:Insert 104 and Huvaei into sirketler table.
//		String q1="INSERT INTO sirketler VALUES(104,'HUAVEI')";
//		int r1=st.executeUpdate(q1);
//		System.out.println(r1+" row/s inserted");
		
	/*	String q2="SELECT * FROM sirketler";
		ResultSet r2 =st.executeQuery(q2);
		while (r2.next()) {
			System.out.println(r2.getString("sirket_isim"));
		}*/
		//2.Example:Change HUVAEI to Honda 
	/*	String q3="UPDATE sirketler SET sirket_isim='Honda' WHERE sırket_id=104";
		int r3=st.executeUpdate(q3);
		System.out.println(r3+" row/s updated");
		
		String q4="SELECT * FROM sirketler";
		ResultSet r4 =st.executeQuery(q4);
		while (r4.next()) {
			System.out.println(r4.getString("sirket_isim"));
		}*/
		
//		
//		//3.example:delete all record whose company_id is 104
//		String q5="DELETE FROM sirketler WHERE sirket_id=104";
//		int r5=st.executeUpdate(q5);
//		System.out.println(r5+" row/s deleted");
//		
//		String q6="SELECT * FROM sirketler";
//		ResultSet r6 =st.executeQuery(q6);
//		while (r6.next()) {
//			System.out.println(r6.getString("sirket_isim"));
//		}
//		
		
		
	//4.example:how to insert multiple record into a table
		/*
		 Birden çok veri eklemek için aşağıdaki adımları izleyin
			 	1) Bir POJO(Plain Old Java Object) Sınıfı Oluşturun
			 		a) Özel değişkenler oluşturun
			 		b) Tüm alıcıları ve ayarlayıcıları oluşturun
			 		c) Tüm değişkenlerle Constructor oluşturun
			 		d)Craete toString() yöntemi
			 	2) POJO Sınıfı nesnelerinin bir listesini oluşturun
			 	3) For-each döngüsünü kullanarak kayıtları ekleyin
		 
		 */
		List<SMyCompaniesPojo> records=new ArrayList<>();
		records.add(new SMyCompaniesPojo(104, "HUAVEI"));
		records.add(new SMyCompaniesPojo(105, "SAMSUNG"));
		records.add(new SMyCompaniesPojo(106, "LG"));
		
		int counter=0;
		for (SMyCompaniesPojo w : records) {
			
			String q7="INSERT INTO my_companies VALUES("+w.getCompany_id()+",'"+w.getCompany_name()+"')";
			counter=counter+st.executeUpdate(q7);
		}
		
		System.out.println(counter+" rows inserted");

		
		con.close();
		st.close();

	}

}
