package summer21jdbc;

import java.sql.*;

public class Jdbc3DDL {
	/*
	 * her sorguda öncekileri yoruma al hata vermesin A) CREATE TABLE, DROP TABLE,
	 * ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet) dondurmeyen
	 * metotlar kullanilmalidir.(executeQuery kullanamayız) Bunun icin JDBC'de 2
	 * alternatif bulunmaktadir. 1) execute() metodu 2) excuteUpdate() metodu.
	 * 
	 * B) - execute() metodu hertur SQL ifadesiyle kullanilabilen genel bir
	 * komuttur. - execute(), Boolean bir deger dondurur. DDL islemlerin false
	 * dondururken, DML islemlerinde true deger dondurur. - Ozellikle, hangi tip SQL
	 * ifadesinin kullanilmasinin gerektiginin belli olmadigi durumlarda tercih
	 * edilmektedir.
	 * 
	 * C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin
	 * kullanilir. - bu islemlerde islemden etkilenen satir sayisini dondurur. -
	 * Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.
	 */

	@SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");

		Statement st = con.createStatement();
//ORNEK1:isciler adinda bir tablo olusturunuz id NUMBER(3),
//birim VARCHAR2(10), maas NUMBER(5)

//		st.executeQuery("CREATE TABLE isciler(" +
//		         " id NUMBER(3)," +
//		         " birim VARCHAR(10)," +
//		         " maas NUMBER(5))");
//		System.out.println("isciler tablosu olusturuldu");

		// isciler tablosunu kalici olarak siliniz...
//		st.executeUpdate("DROP TABLE isciler PURGE");
//		System.out.println("isciler table silindi");

//ORNEK3:isciler tablosuna yeni bir sutun {isim Varchar2(20)} ekleyiniz. 
		// st.executeUpdate("ALTER TABLE isciler ADD isim VARCHAR2(20)");

		// ORNEK4:isciler tablosundaki maas sutunu siliniz
//	st.execute("ALTER TABLE isciler DROP COLUMN maas");
//	System.out.println("maas sutunu silindi...");

//		// ORNEK6:isciler tablosunun adini calisanlar olarak degistiriniz.
//		st.execute("ALTER TABLE isciler RENAME TO calisanlar");
//		System.out.println("islem yine tamam");
		
		
		st.executeQuery("CREATE TABLE my_companies(" +
		         " company_id NUMBER(3)," +
		         " company_name VARCHAR2(10))");
		System.out.println("isciler tablosu olusturuldu");


	}

}
