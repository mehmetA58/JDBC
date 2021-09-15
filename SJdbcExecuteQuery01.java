package summer21jdbc;

//1. adım:telefona sahip olmak yani SQL package i import etmek..
import java.sql.*;

public class SJdbcExecuteQuery01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 2.adim:gsm operatörüne sahip olmak yani;Oracle Sürücüsüne Kaydolun

		Class.forName("oracle.jdbc.driver.OracleDriver");// -->seç throws ClassNotF...

		//3.adim:arkadaşlarını ara yani;database ile bağlantı kur.
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");

		//4.adim ifade oluşturun
		Statement st = con.createStatement();

		//5.adim:arkadaşlarınla konuşma başla yani bir sorgu oluştur.
		
		//1.Example
		String q1 = "SELECT * FROM  sirketler";
		ResultSet r1 = st.executeQuery(q1);
		//6.adim:sonuca göre bazı işlemler yapın
		while (r1.next()) {
			System.out.println(r1.getInt(1)+" - "+r1.getString(2));
		}
		
		//2.Example
		String q2="SELECT * FROM sirketler WHERE sirket_id<102";
		
		ResultSet r2= st.executeQuery(q2);
		while (r2.next()) {
			System.out.println(r2.getString("sirket_isim"));//id'si 102den kücük sirketlerin
														//isimlerini getirir.
		}
		
	/*	//3.Examples:select third company_id and company_name after sorting descending
		String q3="SELECT sirket_id,sirket_isim "
				+ "FROM sirketler "
				+ "ORDER BY sirket_id DESC,  "
				+ "OFFSET 2 ROWS "
				+ "FETCH NEXT 1 ROWS ONLY";
		ResultSet r3=st.executeQuery(q3);
		while (r3.next()) {
			System.out.println(r3.getInt("sirket_id")+" -> "+r3.getString("sirket_isim"));
		}*/
		//4.Example:Select the company whose id is the second lowest
		//4.Örnek: Kimliği ikinci en düşük olan şirketi seçin--çok sorulan interview sorusu
		System.out.println("---------------------------------------------------------------------------------");
		String q4="SELECT bolum_id FROM personel ORDER BY bolum_id";
		
		ResultSet r4= st.executeQuery(q4);
		while (r4.next()) {
			System.out.println(r4.getInt("personel_id"));
		
		
		
		
		
		
		
		
		
		
		//7.adim:konuşmayı bitir yani Database bağlantısını close et.
		con.close();
		st.close();
		r1.close();
		r2.close();
		r4.close();

	}

}
}
