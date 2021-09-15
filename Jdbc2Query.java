package summer21jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc2Query {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
		Statement st = con.createStatement();

		// ornek1:bolumler tablosundaki tüm kayıtları listeleyen bir sorgu yazınız

		ResultSet tablo1 = st.executeQuery("SELECT*FROM bolumler");

		while (tablo1.next()) {
			System.out.println(tablo1.getInt(1) + "- " + tablo1.getString(2) + "--> " + tablo1.getString(3));
		}
		System.out.println("----------------------------------------------------------------------");
		//ornek2 satıs ve muhasebe bolumlerinde calisan personelin isimlerini ve maaslarini,maas ters siirali olarak listeleyiniz		

		ResultSet tablo2 = st.executeQuery(
				"SELECT personel_isim,maas " + " FROM personel" + " WHERE bolum_id IN (10,30)" + " ORDER BY maas DESC");
		while (tablo2.next()) {
			System.out.println(tablo2.getString(1) + "    \t" + tablo2.getInt(2));
		}
		System.out.println("===------------------------------------------------------------------===");
		/*
		 * ORNEK3: Tüm bolumlerde calisan personelin isimlerini, bolum isimlerini ve
		 * maaslarini, bolum ve maas sirali listeleyiniz. NOT: calisani olmasa bile
		 * bolum ismi gosterilmelidir.
		 */
		ResultSet rs3 = st.executeQuery("SELECT bolum_isim,personel_isim,maas "
				+ " FROM bolumler b"
				+ " LEFT JOIN personel p"
				+ " ON b.bolum_id=p.bolum_id"
				+ " ORDER BY bolum_isim,maas");
		while (rs3.next()) {
			System.out.println(rs3.getString(1)+"    \t"+rs3.getString(2)+"     \t"+rs3.getInt(3));
		}

		System.out.println("=====================================");

		/*=======================================================================
		  ORNEK4: Maasi en yuksek 10 kisinin bolumunu,adini ve maasini listeyiniz
		========================================================================*/
		/*ResultSet rs4=st.executeQuery("SELECT bolum_isim,personel_isim,maas"
				+ " FROM personel p"
				+ " FULL JOIN bolumler b"
				+ " ON b.bolum_id=p.bolum_id"
				+ "ORDER BY maas DESC"
				+ " FETCH NEXT 10 ROWS ONLY");
		while (rs4.next()) {
			System.out.println(rs4.getString(1)+" "+rs4.getString(2)+" "+rs4.getInt(3));
		}*/
		
con.close();
st.close();
tablo1.close();
tablo2.close();
rs3.close();

		
	}

}
