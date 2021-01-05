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
public class MonHoc {
    private int id;
    private String ten_mon_hoc;
    private int tin_chi;
    private int hoc_phi;
    private Boolean trang_thai;

    public MonHoc(int id, String ten_mon_hoc, int tin_chi, int hoc_phi, Boolean trang_thai) {
        this.id = id;
        this.ten_mon_hoc = ten_mon_hoc;
        this.tin_chi = tin_chi;
        this.hoc_phi = hoc_phi;
        this.trang_thai = trang_thai;
    }

    public MonHoc(String ten_mon_hoc, int tin_chi, int hoc_phi, Boolean trang_thai) {
        this.ten_mon_hoc = ten_mon_hoc;
        this.tin_chi = tin_chi;
        this.hoc_phi = hoc_phi;
        this.trang_thai = trang_thai;
    }

    public MonHoc() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen_mon_hoc() {
        return ten_mon_hoc;
    }

    public void setTen_mon_hoc(String ten_mon_hoc) {
        this.ten_mon_hoc = ten_mon_hoc;
    }

    public int getTin_chi() {
        return tin_chi;
    }

    public void setTin_chi(int tin_chi) {
        this.tin_chi = tin_chi;
    }

    public int getHoc_phi() {
        return hoc_phi;
    }

    public void setHoc_phi(int hoc_phi) {
        this.hoc_phi = (int) hoc_phi;
    }

    public Boolean getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(Boolean trang_thai) {
        this.trang_thai = trang_thai;
    }

    @Override
    public String toString() {
        return "MonHoc{" + "id=" + id + ", ten_mon_hoc=" + ten_mon_hoc + ", tin_chi=" + tin_chi + ", hoc_phi=" + hoc_phi + ", trang_thai=" + trang_thai + '}';
    }
    
    
}
