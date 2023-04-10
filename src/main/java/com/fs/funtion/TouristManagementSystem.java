package com.fs.funtion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.fs.entity.Tourist;

public class TouristManagementSystem {

	private ArrayList<Tourist> tourists;

	public TouristManagementSystem() {
		tourists = new ArrayList<>();
	}

	public void addTourist(Tourist tourist) {
		tourists.add(tourist);
	}

	public void displayAllTourists() {
	    // Sắp xếp danh sách khách du lịch theo thứ tự tăng dần của ID
	    Collections.sort(tourists, new Comparator<Tourist>() {
	        @Override
	        public int compare(Tourist t1, Tourist t2) {
	            return t1.getID().compareTo(t2.getID());
	        }
	    });
	    
	    // Hiển thị danh sách khách du lịch lên console
	    for (Tourist tourist : tourists) {
	        System.out.println("Kết quả săp xếp: "+tourist.toString());
	    }
	}







}
