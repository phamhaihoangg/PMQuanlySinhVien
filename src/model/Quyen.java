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
public class Quyen {
    private int id;
    private String ten_quyen;

    public Quyen(int id, String ten_quyen) {
        this.id = id;
        this.ten_quyen = ten_quyen;
    }

    public Quyen() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen_quyen() {
        return ten_quyen;
    }

    public void setTen_quyen(String ten_quyen) {
        this.ten_quyen = ten_quyen;
    }

    @Override
    public String toString() {
        return ten_quyen;
    }
    
    
}
