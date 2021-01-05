/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HaiHoang
 */
public class LopHoc {
    private int id;
    private String ten_lop_hoc;
    private int khoa_hoc_ID;
    private int giao_vien_ID;
    private String ten_khoa_hoc;
    private String ten_giao_vien;

    public LopHoc(int id, String ten_lop_hoc, int khoa_hoc_ID, int giao_vien_ID, String ten_khoa_hoc, String ten_giao_vien) {
        this.id = id;
        this.ten_lop_hoc = ten_lop_hoc;
        this.khoa_hoc_ID = khoa_hoc_ID;
        this.giao_vien_ID = giao_vien_ID;
        this.ten_khoa_hoc = ten_khoa_hoc;
        this.ten_giao_vien = ten_giao_vien;
    }

    public LopHoc(String ten_lop_hoc, int khoa_hoc_ID, int giao_vien_ID, String ten_khoa_hoc, String ten_giao_vien) {
        this.ten_lop_hoc = ten_lop_hoc;
        this.khoa_hoc_ID = khoa_hoc_ID;
        this.giao_vien_ID = giao_vien_ID;
        this.ten_khoa_hoc = ten_khoa_hoc;
        this.ten_giao_vien = ten_giao_vien;
    }

    public String getTen_khoa_hoc() {
        return ten_khoa_hoc;
    }

    public void setTen_khoa_hoc(String ten_khoa_hoc) {
        this.ten_khoa_hoc = ten_khoa_hoc;
    }

    public String getTen_giao_vien() {
        return ten_giao_vien;
    }

    public void setTen_giao_vien(String ten_giao_vien) {
        this.ten_giao_vien = ten_giao_vien;
    }



    public LopHoc() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen_lop_hoc() {
        return ten_lop_hoc;
    }

    public void setTen_lop_hoc(String ten_lop_hoc) {
        this.ten_lop_hoc = ten_lop_hoc;
    }

    public int getKhoa_hoc_ID() {
        return khoa_hoc_ID;
    }

    public void setKhoa_hoc_ID(int khoa_hoc_ID) {
        this.khoa_hoc_ID = khoa_hoc_ID;
    }

    public int getGiao_vien_ID() {
        return giao_vien_ID;
    }

    public void setGiao_vien_ID(int giao_vien_ID) {
        this.giao_vien_ID = giao_vien_ID;
    }

    @Override
    public String toString() {
        return ten_lop_hoc;
    }
    
    
}
