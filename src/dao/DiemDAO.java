/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Diem;
import utility.DataBaseConnection;

/**
 *
 * @author HaiHoang
 */
public class DiemDAO {
    public List<Diem> getAll() {
        Connection conn = DataBaseConnection.getConnection();
        List<Diem> lst = new ArrayList<>();
        try 
        {
            
            
            CallableStatement cs = conn.prepareCall("{CALL proc_getAllDiem}");
            ResultSet rs = cs.executeQuery();
            Diem d;
            while (rs.next()) {
                d = new Diem();
                d.setId(rs.getInt("id"));
                d.setNgay_thi(rs.getDate("ngay_thi").toLocalDate());
                d.setDiem(rs.getInt("diem"));
                d.setTrang_thai(rs.getBoolean("trang_thai"));
                d.setGhi_chu(rs.getString("ghi_chu"));
                d.setHoc_vien_ID(rs.getInt("hoc_vien_ID"));
                d.setMon_hoc_ID(rs.getInt("mon_hoc_ID"));                
                d.setTen_mon_hoc(rs.getString("ten_mon_hoc"));
                d.setTen_hoc_vien(rs.getString("ten_hoc_vien"));
                d.setMa_hoc_vien(rs.getString("ma_hoc_vien"));
                lst.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }
    
    public Diem getById(int id) {
        Connection conn = DataBaseConnection.getConnection();
        Diem d = null;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_getDiemById(?)}");
            cs.setInt(1,id);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                d = new Diem();
                d.setId(rs.getInt("id"));
                d.setNgay_thi(rs.getDate("ngay_thi").toLocalDate());
                d.setDiem(rs.getInt("diem"));
                d.setTrang_thai(rs.getBoolean("trang_thai"));
                d.setGhi_chu(rs.getString("ghi_chu"));
                d.setHoc_vien_ID(rs.getInt("hoc_vien_ID"));
                d.setMon_hoc_ID(rs.getInt("mon_hoc_ID"));  
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return d;
    }
    
    public boolean insert(Diem d) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_createDiem(?,?,?,?,?,?)}");

            cs.setDate(1,Date.valueOf(d.getNgay_thi()) );
            cs.setInt(2, d.getDiem());
            cs.setBoolean(3, d.getTrang_thai());
            cs.setNString(4, d.getGhi_chu());
            cs.setInt(5, d.getHoc_vien_ID());
            cs.setInt(6, d.getMon_hoc_ID());
            int result = cs.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
    public boolean update(Diem d) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_updateDiem(?,?,?,?,?,?,?)}");
            cs.setInt(1, d.getId());
            cs.setDate(2, Date.valueOf(d.getNgay_thi()));
            cs.setInt(3, d.getDiem());
            cs.setBoolean(4, d.getTrang_thai());
            cs.setNString(5, d.getGhi_chu());
            cs.setInt(6, d.getHoc_vien_ID());
            cs.setInt(7, d.getMon_hoc_ID());
            int result = cs.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    public boolean delete(int id) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try  {
            CallableStatement cs = conn.prepareCall("{CALL proc_deleteDiem(?)}");
            cs.setInt(1, id);

            int result = cs.executeUpdate();


            if (result > 0) {
                flag = true;
            } else {
                System.out.println("msg");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    public List<Diem> Search(String msv) {
        Connection conn = DataBaseConnection.getConnection();
        List<Diem> lst = new ArrayList<>();
        try {

            CallableStatement cs = conn.prepareCall("{CALL proc_SearchDiem(?)}");
            cs.setString(1, msv);
            
            ResultSet rs = cs.executeQuery();
            Diem d;
            while (rs.next()) {
                d = new Diem();
                d.setId(rs.getInt("id"));
                d.setNgay_thi(rs.getDate("ngay_thi").toLocalDate());
                d.setDiem(rs.getInt("diem"));
                d.setTrang_thai(rs.getBoolean("trang_thai"));
                d.setGhi_chu(rs.getString("ghi_chu"));
                d.setHoc_vien_ID(rs.getInt("hoc_vien_ID"));
                d.setMon_hoc_ID(rs.getInt("mon_hoc_ID"));                
                d.setTen_mon_hoc(rs.getString("ten_mon_hoc"));
                d.setTen_hoc_vien(rs.getString("ten_hoc_vien"));
                d.setMa_hoc_vien(rs.getString("ma_hoc_vien"));
                lst.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    } 
    public static void main(String[] args) {
        new DiemDAO().getById(1);
        new DiemDAO().delete(4);
    }
}
