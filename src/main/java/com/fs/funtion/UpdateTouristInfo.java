package com.fs.funtion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.fs.db.DBConnect;

public class UpdateTouristInfo {
	// Thay đổi thông tin Xác nhận âm tính của khách du lịch
    public static void updateNegativeTestResult() {
        try {
        	Connection conn = DBConnect.getConnection();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập ID của khách du lịch cần cập nhật thông tin Xác nhận âm tính:");
            String touristID = scanner.nextLine();
            
            // Kiểm tra xem khách du lịch có tồn tại trong database không
            PreparedStatement stmtCheck = conn.prepareStatement("SELECT * FROM Tourist WHERE ID = ?");
            stmtCheck.setString(1, touristID);
            ResultSet rs = stmtCheck.executeQuery();
            if (!rs.next()) {
                System.out.println("ID " + touristID + " không tồn tại trong hệ thống!");
                return;
            }
            
            // Cập nhật thông tin Xác nhận âm tính cho khách du lịch
            PreparedStatement stmtUpdate = conn.prepareStatement("UPDATE tourist SET XacNhanAmTinh = ? WHERE ID = ?");
            stmtUpdate.setBoolean(1, true);
            stmtUpdate.setString(2, touristID);
            int rowsAffected = stmtUpdate.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cập nhật thông tin Xác nhận âm tính cho khách du lịch có ID " + touristID + " thành công!");
            } else {
                System.out.println("Không thể cập nhật thông tin Xác nhận âm tính cho khách du lịch có ID " + touristID);
            }
        } catch (SQLException e) {
            System.out.println("Program have an unexpected error occurred !!!");
            e.printStackTrace();
        }
    }
    public static void updateVaccineCount() {
        try {
        	Connection conn = DBConnect.getConnection();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập ID của khách du lịch cần cập nhật thông tin Số mũi vaccine:");
            String touristID = scanner.nextLine();
            
            // Kiểm tra xem khách du lịch có tồn tại trong database không
            PreparedStatement stmtCheck = conn.prepareStatement("SELECT * FROM Tourist WHERE ID = ?");
            stmtCheck.setString(1, touristID);
            ResultSet rs = stmtCheck.executeQuery();
            if (!rs.next()) {
                System.out.println("ID " + touristID + " không tồn tại trong hệ thống!");
                return;
            }
            
            // Cập nhật thông tin Số mũi vaccine cho khách du lịch
            System.out.println("Nhập số mũi vaccine mới của khách du lịch có ID " + touristID + ":");
            int vaccineCount = scanner.nextInt();
            PreparedStatement stmtUpdate = conn.prepareStatement("UPDATE tourist SET SoMuiVacXin = ? WHERE ID = ?");
            stmtUpdate.setInt(1, vaccineCount);
            stmtUpdate.setString(2, touristID);
            int rowsAffected = stmtUpdate.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cập nhật thông tin Số mũi vaccine của khách du lịch có ID " + touristID + " thành công!");
            } else {
                System.out.println("Không thể cập nhật thông tin Số mũi vaccine của khách du lịch có ID " + touristID + ".");
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.getMessage());
        }
    }
 // Xóa thông tin khách du lịch không thỏa mãn điều kiện ra khỏi database
    public static void deleteUnqualifiedTourists() {
        try {
        	Connection conn = DBConnect.getConnection();
            Statement stmt = conn.createStatement();

            // Lấy tất cả các khách du lịch trong database
            ResultSet rs = stmt.executeQuery("SELECT * FROM Tourist");

            // Duyệt qua từng khách du lịch và kiểm tra điều kiện
            while (rs.next()) {
                boolean xacNhanAmTinh = rs.getBoolean("XacNhanAmTinh");
                int soMuiVacXin = rs.getInt("SoMuiVacXin");

                if (!xacNhanAmTinh || soMuiVacXin < 2) {
                    // Xóa thông tin khách du lịch không thỏa mãn điều kiện ra khỏi database
                    int touristID = rs.getInt("ID");
                    stmt.executeUpdate("DELETE FROM Tourist WHERE ID = " + touristID);
                    System.out.println("Đã xóa thông tin khách du lịch có ID " + touristID + " ra khỏi database.");
                }
            }

            // Đóng kết nối
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
