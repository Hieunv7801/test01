package com.fs.entity;

import java.util.Date;

public class TouristFromForeign extends Tourist{
	
	private String quocGia;
	private String maChuyenBay;
	
	public TouristFromForeign(String iD, String hoTen, Date ngaySinh, String soDienThoai, Boolean nhuCauMuaVe,
			byte soMuiVacXin, Boolean xacNhanAmTinh, String quocGia, String maChuyenBay) {
		super(iD, hoTen, ngaySinh, soDienThoai, nhuCauMuaVe, soMuiVacXin, xacNhanAmTinh);
		this.quocGia = quocGia;
		this.maChuyenBay = maChuyenBay;
	}

	public String getQuocGia() {
		return quocGia;
	}

	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}

	public String getMaChuyenBay() {
		return maChuyenBay;
	}

	public void setMaChuyenBay(String maChuyenBay) {
		this.maChuyenBay = maChuyenBay;
	}

	@Override
	public void ShowInfo() {
		System.out.println("Quoc Gia: " +quocGia);
        System.out.println("Ma chuyen bay: " +maChuyenBay);
	}

	@Override
	public String toString() {
		return "TouristFromForeign [quocGia=" + quocGia + ", maChuyenBay=" + maChuyenBay + "]";
	}
	
	
	
}
