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
public class HocVien {
    private int id;
    private String ma_hoc_vien;
    private String ten_hoc_vien;
    private String so_dien_thoai;
    private String email;
    private String dia_chia;
    private LocalDate ngay_sinh;
    private Boolean gioi_tinh;
    private Boolean trang_thai;
    private int lop_hoc_ID;
    private String ten_lop_hoc;

    public HocVien(int id, String ma_hoc_vien, String ten_hoc_vien, String so_dien_thoai, String email, String dia_chia, LocalDate ngay_sinh, Boolean gioi_tinh, Boolean trang_thai, int lop_hoc_ID, String ten_lop_hoc) {
        this.id = id;
        this.ma_hoc_vien = ma_hoc_vien;
        this.ten_hoc_vien = ten_hoc_vien;
        this.so_dien_thoai = so_dien_thoai;
        this.email = email;
        this.dia_chia = dia_chia;
        this.ngay_sinh = ngay_sinh;
        this.gioi_tinh = gioi_tinh;
        this.trang_thai = trang_thai;
        this.lop_hoc_ID = lop_hoc_ID;
        this.ten_lop_hoc = ten_lop_hoc;
    }

    public HocVien(String ma_hoc_vien, String ten_hoc_vien, String so_dien_thoai, String email, String dia_chia, LocalDate ngay_sinh, Boolean gioi_tinh, Boolean trang_thai, int lop_hoc_ID, String ten_lop_hoc) {
        this.ma_hoc_vien = ma_hoc_vien;
        this.ten_hoc_vien = ten_hoc_vien;
        this.so_dien_thoai = so_dien_thoai;
        this.email = email;
        this.dia_chia = dia_chia;
        this.ngay_sinh = ngay_sinh;
        this.gioi_tinh = gioi_tinh;
        this.trang_thai = trang_thai;
        this.lop_hoc_ID = lop_hoc_ID;
        this.ten_lop_hoc = ten_lop_hoc;
    }





    public HocVien() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa_hoc_vien() {
        return ma_hoc_vien;
    }

    public void setMa_hoc_vien(String ma_hoc_vien) {
        this.ma_hoc_vien = ma_hoc_vien;
    }

    public String getTen_hoc_vien() {
        return ten_hoc_vien;
    }

    public void setTen_hoc_vien(String ten_hoc_vien) {
        this.ten_hoc_vien = ten_hoc_vien;
    }

    public String getSo_dien_thoai() {
        return so_dien_thoai;
    }

    public void setSo_dien_thoai(String so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDia_chia() {
        return dia_chia;
    }

    public void setDia_chia(String dia_chia) {
        this.dia_chia = dia_chia;
    }

    public LocalDate getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(LocalDate ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public Boolean getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(Boolean gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public Boolean getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(Boolean trang_thai) {
        this.trang_thai = trang_thai;
    }

    public int getLop_hoc_ID() {
        return lop_hoc_ID;
    }

    public void setLop_hoc_ID(int lop_hoc_ID) {
        this.lop_hoc_ID = lop_hoc_ID;
    }

    public String getTen_lop_hoc() {
        return ten_lop_hoc;
    }

    public void setTen_lop_hoc(String ten_lop_hoc) {
        this.ten_lop_hoc = ten_lop_hoc;
    }
    
    @Override
    public String toString() {
        return ten_lop_hoc;
    }
    
    
}
