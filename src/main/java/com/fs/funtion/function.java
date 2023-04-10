package com.fs.funtion;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.fs.db.DBConnect;
import com.fs.entity.Tourist;
import com.fs.exception.DataNotMatchException;
import com.fs.exception.DateInvalidException;
import com.fs.exception.TouristDuplicateException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class function {

	public static void insertDateFromCSVToDB() throws CsvValidationException, IOException {
		Connection conn = null;
		conn = DBConnect.getConnection();

		String csvFile = "data.csv";
		CSVReader reader = new CSVReader(new FileReader(csvFile));

		String[] nextLine;

		while ((nextLine = reader.readNext()) != null) {
			try {

				String id = nextLine[0];
				String hoTen = nextLine[1];
				String ngaySinhStr = nextLine[2];
				Date ngaySinh = ngaySinhStr.isEmpty() ? null : new SimpleDateFormat("dd/mm/yyy").parse(ngaySinhStr);
				String soDienThoai = nextLine[3];
				Boolean nhuCauMuaVe = nextLine[4].isEmpty() ? null : Boolean.parseBoolean(nextLine[4]);
				int soMuiVacXin = nextLine[5].isEmpty() ? 0 : Integer.parseInt(nextLine[5]);
				Boolean xacNhanAmTinh = nextLine[6].isEmpty() ? null : Boolean.parseBoolean(nextLine[6]);
				String tinhThanh = nextLine[7].isEmpty() ? null : nextLine[7];
				String phuongTien = nextLine[8].isEmpty() ? null : nextLine[8];
				String quocGia = nextLine[9].isEmpty() ? null : nextLine[9];
				String maChuyenBay = nextLine[10].isEmpty() ? null : nextLine[10];

				// Validate ID khách du lịch
				if (!id.startsWith("P") && !id.startsWith("F")) {
					throw new DataNotMatchException("ID khong dung dinh dang!");
				}

				// Check trùng ID
				PreparedStatement checkStatement = conn.prepareStatement("SELECT COUNT(*) FROM Tourist WHERE id = ?");
				checkStatement.setString(1, id);
				ResultSet rs = checkStatement.executeQuery();
				if (rs.next() && rs.getInt(1) > 0) {
					throw new TouristDuplicateException("ID " + id + " da bi trung lap voi truoc do!");
				}

				// Validate ngày sinh
				if (ngaySinh != null && ngaySinh.after(new Date())) {
					throw new DateInvalidException("Ngay sinh khong hop le!");
				}

				PreparedStatement statement = conn
						.prepareStatement("INSERT INTO Tourist VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				statement.setString(1, id);
				statement.setString(2, hoTen);
				statement.setDate(3, ngaySinh != null ? new java.sql.Date(ngaySinh.getTime()) : null);
				statement.setString(4, soDienThoai);
				statement.setBoolean(5, nhuCauMuaVe != null ? nhuCauMuaVe : false);
				statement.setInt(6, soMuiVacXin);
				statement.setBoolean(7, xacNhanAmTinh != null ? xacNhanAmTinh : false);
				statement.setString(8, tinhThanh);
				statement.setString(9, phuongTien);
				statement.setString(10, quocGia);
				statement.setString(11, maChuyenBay);

				statement.executeUpdate();
			} catch (DataNotMatchException e) {
				System.out.println(e.getMessage());
			} catch (TouristDuplicateException e) {
				System.out.println(e.getMessage());
			} catch (DateInvalidException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("Program have an unexpected error occurred !!!");
				e.printStackTrace();
			}
		}
	}

	public void SoLuongNhuCauDacVe() throws SQLException {
		int count = 0;
		String sql = "SELECT NhuCauDatVe FROM tourist";
		try (Connection conn = DBConnect.getConnection();
		     Statement stmt = conn.createStatement();
		     ResultSet rs = stmt.executeQuery(sql)) {
		    while (rs.next()) {
		        boolean hasTicketDemand = rs.getBoolean("NhuCauDatVe");
		        if (hasTicketDemand) {
		            count++;
		        }
		    }
		} catch (SQLException e) {
		    System.out.println("Program have an unexpected error occurred !!!");
		    e.printStackTrace();
		}
		System.out.println("So luong khach du lich co nhu cau mua ve xem bieu dien phao hoa la: " + count);
	}
	public static void showInformation() {
		
	}
}
