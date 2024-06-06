package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;

public class TestJDBCUtil {
	public static void main(String[] args) {
		
		try {
			//b1: tao ket noi 
			Connection connection = JDBCUtil.getConnection();
			
			//b2: Tao ra doi tuong Statement
			Statement st = connection.createStatement();
			
			//b3: thuc thi 1 cau lenh sql
			String sql = "insert into ontap.persons (person_id,last_name,first_name,gender,dob,income)\n"
					+ "values (5,'Vu', 'Le D', 'M', '1997-7-29', 12000000)";
			//b4: Xu ly ket qua 
			int check = st.executeUpdate(sql);
			System.out.println("So dong thay doi: "+check);
			if(check>0) {
				System.out.println("Them du lieu thanh cong!");
			}
			else {
				System.out.println("Them du lieu that bai!");
			}
			//b5: dong ket noi 
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
