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
public class KhoaHoc {
     private int id;
     private String ten_khoa_hoc;
     private LocalDate ngay_bat_dau;
     private LocalDate ngay_ket_thuc;

    public KhoaHoc(int id, String ten_khoa_hoc, LocalDate ngay_bat_dau, LocalDate ngay_ket_thuc) {
        this.id = id;
        this.ten_khoa_hoc = ten_khoa_hoc;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public KhoaHoc(String ten_khoa_hoc, LocalDate ngay_bat_dau, LocalDate ngay_ket_thuc) {
        this.ten_khoa_hoc = ten_khoa_hoc;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public KhoaHoc() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen_khoa_hoc() {
        return ten_khoa_hoc;
    }

    public void setTen_khoa_hoc(String ten_khoa_hoc) {
        this.ten_khoa_hoc = ten_khoa_hoc;
    }

    public LocalDate getNgay_bat_dau() {
        return ngay_bat_dau;
    }

    public void setNgay_bat_dau(LocalDate ngay_bat_dau) {
        this.ngay_bat_dau = ngay_bat_dau;
    }

    public LocalDate getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }

    public void setNgay_ket_thuc(LocalDate ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    @Override
    public String toString() {
        return ten_khoa_hoc;
    }
     
     
     
}
