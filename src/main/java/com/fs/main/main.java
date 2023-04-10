package com.fs.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.fs.funtion.TouristManagementSystem;
import com.fs.funtion.UpdateTouristInfo;
import com.fs.funtion.function;
import com.opencsv.exceptions.CsvValidationException;

public class main {
	public static void main(String[] args) throws CsvValidationException, IOException, SQLException {
		int luachon = 0;
		do {
			System.out.println("----------Hệ thống quản lí Sở du lịch Đà Nẵng--------------");
			System.out.println("----        Mời bạn chọn chức năng                     ----");
			System.out.println("----    1. Insert dữ liệu từ csv vào DB                ----");
			System.out.println("----    2. Liệt kê thông tin khách đến TP DN           ----");
			System.out.println("----    3. Sắp xếp danh sách theo thứ tự tăng          ----");
			System.out.println("----    4. Hiển thị số lượng khách có nhu cầu mua vé   ----");
			System.out.println("----    5. Cập nhật thông tin XacNhanAmTinh            ----");
			System.out.println("----    6. Cập nhật thông tin SoMuiVacXin              ----");
			System.out.println("----    7. Xóa những khách không đủ ĐK                 ----");
			System.out.println("----    0. Thoát khỏi chương trình                     ----");
			System.out.println("-----------------------------------------------------------");
			Scanner sc = new Scanner(System.in);
			luachon = sc.nextInt();
			sc.nextLine();
			if(luachon == 1) {
				function.insertDateFromCSVToDB();
			}else if(luachon == 2) {
				TouristManagementSystem tou = new TouristManagementSystem();
				tou.displayAllTourists();
			}else if(luachon == 3) {
				
			}else if(luachon == 4) {
				function fs = new function();
				fs.SoLuongNhuCauDacVe();
			}else if(luachon == 5) {
				UpdateTouristInfo.updateNegativeTestResult();
			}else if(luachon == 6) {
				UpdateTouristInfo.updateVaccineCount();
			}else if(luachon == 7) {
				UpdateTouristInfo.deleteUnqualifiedTourists();
			}
		} while (luachon != 0);
		
	}
}
