package summer21jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1) ilgili driver'i yükle
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2)baglanti olustur
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");

		//3)SQL komutlari icin bir statement nesnesi olustur(kumandada kanal ayarlama)
		Statement st=con.createStatement();
		//4)SQL iifadeleri yazabilir calistirabiliriz(kumandada istedigin komuta basma)
		ResultSet isim= st.executeQuery("SELECT personel_isim,maas FROM personel WHERE personel_id=7369");
		//5)sonuclari aldik isledik
		while(isim.next()) {
			System.out.println(isim.getString(1)+" - "+isim.getInt(2));
		}
		//6)olusturulan nesneleri bellekten kaldiralim..
		con.close();
		st.close();
		isim.close();
	}

}
