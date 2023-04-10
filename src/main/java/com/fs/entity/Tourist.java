package com.fs.entity;

import java.util.Date;

public abstract class Tourist {
	private String ID;
    private String HoTen;
    private Date NgaySinh;
    private String SoDienThoai;
    private Boolean NhuCauMuaVe;
    private byte SoMuiVacXin;
    private Boolean XacNhanAmTinh;
    
	public Tourist(String iD, String hoTen, Date ngaySinh, String soDienThoai, Boolean nhuCauMuaVe, byte soMuiVacXin,
			Boolean xacNhanAmTinh) {
		ID = iD;
		HoTen = hoTen;
		NgaySinh = ngaySinh;
		SoDienThoai = soDienThoai;
		NhuCauMuaVe = nhuCauMuaVe;
		SoMuiVacXin = soMuiVacXin;
		XacNhanAmTinh = xacNhanAmTinh;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return SoDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}

	public Boolean getNhuCauMuaVe() {
		return NhuCauMuaVe;
	}

	public void setNhuCauMuaVe(Boolean nhuCauMuaVe) {
		NhuCauMuaVe = nhuCauMuaVe;
	}

	public byte getSoMuiVacXin() {
		return SoMuiVacXin;
	}

	public void setSoMuiVacXin(byte soMuiVacXin) {
		SoMuiVacXin = soMuiVacXin;
	}

	public Boolean getXacNhanAmTinh() {
		return XacNhanAmTinh;
	}

	public void setXacNhanAmTinh(Boolean xacNhanAmTinh) {
		XacNhanAmTinh = xacNhanAmTinh;
	}
    
	public abstract void ShowInfo();

	@Override
	public String toString() {
		return "Tourist [ID=" + ID + ", HoTen=" + HoTen + ", NgaySinh=" + NgaySinh + ", SoDienThoai=" + SoDienThoai
				+ ", NhuCauMuaVe=" + NhuCauMuaVe + ", SoMuiVacXin=" + SoMuiVacXin + ", XacNhanAmTinh=" + XacNhanAmTinh
				+ "]";
	}
	
	
}
