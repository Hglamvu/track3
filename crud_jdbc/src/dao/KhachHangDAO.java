package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.KhachHang;
import model.Sach;

public class KhachHangDAO implements DAOInterface<KhachHang> {

	
	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}
	@Override
	public int insert(KhachHang t) {
		int ketQua = 0;
		try {
			//b1
			Connection con = JDBCUtil.getConnection();
			//b2
			Statement st = con.createStatement();
			//b3
			String sql = "INSERT INTO nhasach.khachHang(id, hoVaTen, ngaySinh, diaChi"
						+ " VALUES ('"+ t.getId()+"' , '"+t.getHoVaTen() + "' , '" + t.getNgaySinh()+"' , '" +t.getDiaChi()+"')";
			ketQua = st.executeUpdate(sql);
			//b4
			System.out.println("Da thuc thi: "+ sql);
			System.out.println("Co "+ ketQua+ " bi tac dong vao");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(KhachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(KhachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "Select * from nhasach.khachHang";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				int id = rs.getInt("id");
				String hoVaTen = rs.getString("hoVaTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");
				KhachHang kh = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
				ketQua.add(kh);
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KhachHang> selectByCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}

}

	

