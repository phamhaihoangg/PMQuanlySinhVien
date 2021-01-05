/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author HaiHoang
 */
public class GiaoVien {
    private int id;
    private String ten_giao_vien;
    private String so_dien_thoai;
    private String email;
    private String password;
    private String dia_chi;
    private LocalDate ngay_sinh;
    private int trang_thai;
    private int quyen_ID;
    private String ten_quyen;

    public GiaoVien(int id, String ten_giao_vien, String so_dien_thoai, String email, String password, String dia_chi, LocalDate ngay_sinh, int trang_thai, int quyen_ID, String ten_quyen) {
        this.id = id;
        this.ten_giao_vien = ten_giao_vien;
        this.so_dien_thoai = so_dien_thoai;
        this.email = email;
        this.password = password;
        this.dia_chi = dia_chi;
        this.ngay_sinh = ngay_sinh;
        this.trang_thai = trang_thai;
        this.quyen_ID = quyen_ID;
        this.ten_quyen = ten_quyen;
    }

    public GiaoVien(String ten_giao_vien, String so_dien_thoai, String email, String password, String dia_chi, LocalDate ngay_sinh, int trang_thai, int quyen_ID, String ten_quyen) {
        this.ten_giao_vien = ten_giao_vien;
        this.so_dien_thoai = so_dien_thoai;
        this.email = email;
        this.password = password;
        this.dia_chi = dia_chi;
        this.ngay_sinh = ngay_sinh;
        this.trang_thai = trang_thai;
        this.quyen_ID = quyen_ID;
        this.ten_quyen = ten_quyen;
    }



    public GiaoVien() {
        
    }

    public String getTen_quyen() {
        return ten_quyen;
    }

    public void setTen_quyen(String ten_quyen) {
        this.ten_quyen = ten_quyen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen_giao_vien() {
        return ten_giao_vien;
    }

    public void setTen_giao_vien(String ten_giao_vien) {
        this.ten_giao_vien = ten_giao_vien;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public LocalDate getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(LocalDate ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }

    public int getQuyen_ID() {
        return quyen_ID;
    }

    public void setQuyen_ID(int quyen_ID) {
        this.quyen_ID = quyen_ID;
    }

    @Override
    public String toString() {
        return ten_giao_vien;
    }
    
    
}
