package com.fs.entity;

import java.util.Date;

public class TouristFromProvince extends Tourist{
	
	private String TinhThanh;
    private String PhuongTien;
    
	public TouristFromProvince(String iD, String hoTen, Date ngaySinh, String soDienThoai, Boolean nhuCauMuaVe,
			byte soMuiVacXin, Boolean xacNhanAmTinh, String tinhThanh, String phuongTien) {
		super(iD, hoTen, ngaySinh, soDienThoai, nhuCauMuaVe, soMuiVacXin, xacNhanAmTinh);
		TinhThanh = tinhThanh;
		PhuongTien = phuongTien;
	}

	public String getTinhThanh() {
		return TinhThanh;
	}

	public void setTinhThanh(String tinhThanh) {
		TinhThanh = tinhThanh;
	}

	public String getPhuongTien() {
		return PhuongTien;
	}

	public void setPhuongTien(String phuongTien) {
		PhuongTien = phuongTien;
	}

	@Override
	public void ShowInfo() {
        System.out.println("Tinh thanh: " + TinhThanh);
        System.out.println("Phuong tien: " + PhuongTien);
	}

	@Override
	public String toString() {
		return "TouristFromProvince [TinhThanh=" + TinhThanh + ", PhuongTien=" + PhuongTien + "]";
	}
    
	
    
}
