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
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhoaHoc;
import utility.DataBaseConnection;

/**
 *
 * @author HaiHoang
 */
public class KhoaHocDAO {
    public List<KhoaHoc> getAll() {
        Connection conn = DataBaseConnection.getConnection();
        List<KhoaHoc> lst = new ArrayList<>();
        try 
        {
            
            
            CallableStatement cs = conn.prepareCall("{CALL proc_getAllKH}");
            ResultSet rs = cs.executeQuery();
            KhoaHoc kh;
            while (rs.next()) {
                kh = new KhoaHoc();
                kh.setId(rs.getInt("id"));
                kh.setTen_khoa_hoc(rs.getNString("ten_khoa_hoc"));
                kh.setNgay_bat_dau(rs.getDate("ngay_bat_dau").toLocalDate());
                kh.setNgay_ket_thuc(rs.getDate("ngay_ket_thuc").toLocalDate());

                lst.add(kh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }
    
    public KhoaHoc getById(int id) {
        Connection conn = DataBaseConnection.getConnection();
        KhoaHoc kh = null;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_getKHById(?)}");
            cs.setInt(1,id);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                kh = new KhoaHoc();
                kh.setId(rs.getInt("id"));
                kh.setTen_khoa_hoc(rs.getNString("ten_khoa_hoc"));
                kh.setNgay_bat_dau(rs.getDate("ngay_bat_dau").toLocalDate());
                kh.setNgay_ket_thuc(rs.getDate("ngay_ket_thuc").toLocalDate());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return kh;
    }
    
    public boolean insert(KhoaHoc kh) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_createKH(?,?,?)}");
            cs.setNString(1, kh.getTen_khoa_hoc());
            cs.setDate(2, Date.valueOf(kh.getNgay_bat_dau()));
            cs.setDate(3, Date.valueOf(kh.getNgay_ket_thuc()));
            int result = cs.executeUpdate();

            

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
    public boolean update(KhoaHoc kh) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_updateKH(?,?,?,?)}");
            cs.setInt(1, kh.getId());
            cs.setNString(1, kh.getTen_khoa_hoc());
            cs.setDate(2, Date.valueOf(kh.getNgay_bat_dau()));
            cs.setDate(3, Date.valueOf(kh.getNgay_ket_thuc()));
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
            CallableStatement cs = conn.prepareCall("{CALL proc_deleteKH(?)}");
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
     public List<KhoaHoc> Search(String name) {
        Connection conn = DataBaseConnection.getConnection();
        List<KhoaHoc> lst = new ArrayList<>();
        try {

            CallableStatement cs = conn.prepareCall("{CALL proc_SearchKH(?)}");
            cs.setString(1, name);
            
            ResultSet rs = cs.executeQuery();
            KhoaHoc kh;
            while (rs.next()) {
                kh = new KhoaHoc();
                kh.setId(rs.getInt("id"));
                kh.setTen_khoa_hoc(rs.getNString("ten_khoa_hoc"));
                kh.setNgay_bat_dau(rs.getDate("ngay_bat_dau").toLocalDate());
                kh.setNgay_ket_thuc(rs.getDate("ngay_ket_thuc").toLocalDate());

                lst.add(kh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }
    public static void main(String[] args) {
        new KhoaHocDAO().getById(1);
        new KhoaHocDAO().delete(4);
    }
}
