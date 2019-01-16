package sunny.util.test;

import java.sql.ResultSet;
import java.sql.Statement;

import sunny.util.jdbc.VCCommonDao;

public class testSQL {
	
	public static void main(String[] args) throws Exception {
		VCCommonDao common=new VCCommonDao();
		Statement statement=common.getInstance();
		
		
		ResultSet rs=statement.executeQuery("select * from order_");
		
		while(rs.next()){
			System.out.println(rs.getString("code"));
		}
		rs.close();
		common.close();
	}

}
