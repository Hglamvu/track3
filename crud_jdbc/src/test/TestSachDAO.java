package test;

import java.util.ArrayList;

import dao.SachDAO;
import model.Sach;

public class TestSachDAO {
	public static void main(String [] args) {
		//test insert
		Sach sach1 = new Sach("LTP", "Lap trinh Python", 75000, 2022);
		Sach sach2 = new Sach("LTJS", "Lap trinh JavaScript", 50000, 2020);
		SachDAO.getInstance().insert(sach2);
		
		
		//test update
//		Sach sach2 = new Sach("LTJS", "Lap trinh JavaScript", 150000, 2025);
//		SachDAO.getInstance().update(sach2);
		
		
		//test delete
//		Sach sach2 = new Sach("LTJS", "Lap trinh JavaScript", 150000, 2025);
//		SachDAO.getInstance().delete(sach2);
		
		//test select all 
//		ArrayList<Sach> list = SachDAO.getInstance().selectAll();
//		for(Sach sach: list) {
//			System.out.println(list.toString());
//		}
		
		//test select by id 
//		Sach find = new Sach();
//		find.setId("LTC");
//		Sach sach2 = SachDAO.getInstance().selectById(find);
//		System.out.println(sach2);
		
		//test select by condition
//		ArrayList<Sach> list = SachDAO.getInstance().selectByCondition("giaBan>70000");
//		for(Sach sach: list) {
//			System.out.println(list.toString());
		
	}
}
