package GUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DataBase.MyConnection;

public class MyFunction {

	public static int CountData(String tablename) {
		int total = 0;
		Connection con = MyConnection.getConnection();
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM "+tablename);
			
			
			while(rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return total;
	}
}
