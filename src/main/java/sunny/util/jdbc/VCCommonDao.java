package sunny.util.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class VCCommonDao {
	
	private static String URL="jdbc:mysql://192.168.157.128:3306/allen";
	
	private static String USERNAME="root";
	
	private static String PASSWORD="root";
	
	private static Connection con;
	
	private static Statement st;
	
	public Statement getInstance() throws Exception{
		return getInstance(URL,USERNAME,PASSWORD);
	}

	public Statement getInstance(String uRL2, String uSERNAME2, String pASSWORD2) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
	    con=DriverManager.getConnection(uRL2, uSERNAME2, pASSWORD2);
	    st=con.createStatement();
		return st;
	}
	
	public void close() throws SQLException{
		st.close();
		con.close();
	}
}
