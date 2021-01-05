/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author HaiHoang
 */
public class Diem {
    private int id;
    private LocalDate ngay_thi;
    private int diem;
    private Boolean trang_thai;
    private String ghi_chu;
    private int hoc_vien_ID;
    private int mon_hoc_ID;
    private String ten_mon_hoc;
    private String ten_hoc_vien;
    private String ma_hoc_vien;

    public Diem() {
    }

    public Diem(int id, LocalDate ngay_thi, int diem, Boolean trang_thai, String ghi_chu, int hoc_vien_ID, int mon_hoc_ID, String ten_mon_hoc, String ten_hoc_vien, String ma_hoc_vien) {
        this.id = id;
        this.ngay_thi = ngay_thi;
        this.diem = diem;
        this.trang_thai = trang_thai;
        this.ghi_chu = ghi_chu;
        this.hoc_vien_ID = hoc_vien_ID;
        this.mon_hoc_ID = mon_hoc_ID;
        this.ten_mon_hoc = ten_mon_hoc;
        this.ten_hoc_vien = ten_hoc_vien;
        this.ma_hoc_vien = ma_hoc_vien;
    }

    public Diem(LocalDate ngay_thi, int diem, Boolean trang_thai, String ghi_chu, int hoc_vien_ID, int mon_hoc_ID, String ten_mon_hoc, String ten_hoc_vien, String ma_hoc_vien) {
        this.ngay_thi = ngay_thi;
        this.diem = diem;
        this.trang_thai = trang_thai;
        this.ghi_chu = ghi_chu;
        this.hoc_vien_ID = hoc_vien_ID;
        this.mon_hoc_ID = mon_hoc_ID;
        this.ten_mon_hoc = ten_mon_hoc;
        this.ten_hoc_vien = ten_hoc_vien;
        this.ma_hoc_vien = ma_hoc_vien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getNgay_thi() {
        return ngay_thi;
    }

    public void setNgay_thi(LocalDate ngay_thi) {
        this.ngay_thi = ngay_thi;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public Boolean getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(Boolean trang_thai) {
        this.trang_thai = trang_thai;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }

    public int getHoc_vien_ID() {
        return hoc_vien_ID;
    }

    public void setHoc_vien_ID(int hoc_vien_ID) {
        this.hoc_vien_ID = hoc_vien_ID;
    }

    public int getMon_hoc_ID() {
        return mon_hoc_ID;
    }

    public void setMon_hoc_ID(int mon_hoc_ID) {
        this.mon_hoc_ID = mon_hoc_ID;
    }

    public String getTen_mon_hoc() {
        return ten_mon_hoc;
    }

    public void setTen_mon_hoc(String ten_mon_hoc) {
        this.ten_mon_hoc = ten_mon_hoc;
    }

    public String getTen_hoc_vien() {
        return ten_hoc_vien;
    }

    public void setTen_hoc_vien(String ten_hoc_vien) {
        this.ten_hoc_vien = ten_hoc_vien;
    }

    public String getMa_hoc_vien() {
        return ma_hoc_vien;
    }

    public void setMa_hoc_vien(String ma_hoc_vien) {
        this.ma_hoc_vien = ma_hoc_vien;
    }

    
}
