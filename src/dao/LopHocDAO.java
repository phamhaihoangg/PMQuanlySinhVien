/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LopHoc;
import utility.DataBaseConnection;

/**
 *
 * @author HaiHoang
 */
public class LopHocDAO {
    public List<LopHoc> getAll() {
        Connection conn = DataBaseConnection.getConnection();
        List<LopHoc> lst = new ArrayList<>();
        try 
        {
            
            
            CallableStatement cs = conn.prepareCall("{CALL proc_getAllLH}");
            ResultSet rs = cs.executeQuery();
            LopHoc lh;
            while (rs.next()) {
                lh = new LopHoc();
                lh.setId(rs.getInt("id"));
                lh.setTen_lop_hoc(rs.getString("ten_lop_hoc"));
                lh.setKhoa_hoc_ID(rs.getInt("khoa_hoc_ID"));
                lh.setGiao_vien_ID(rs.getInt("giao_vien_ID"));
                lh.setTen_khoa_hoc(rs.getString("ten_khoa_hoc"));
                lh.setTen_giao_vien(rs.getString("ten_giao_vien"));
                lst.add(lh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }
    
    public LopHoc getById(int id) {
        Connection conn = DataBaseConnection.getConnection();
        LopHoc lh = null;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_getLHById(?)}");
            cs.setInt(1,id);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                lh = new LopHoc();
                lh.setId(rs.getInt("id"));
                lh.setTen_lop_hoc(rs.getNString("ten_lop_hoc"));
                lh.setKhoa_hoc_ID(rs.getInt("khoa_hoc_ID"));
                lh.setGiao_vien_ID(rs.getInt("giao_vien_ID"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lh;
    }
    
    public boolean insert(LopHoc lh) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_createLH(?,?,?)}");
            cs.setString(1, lh.getTen_lop_hoc());
            cs.setInt(2, lh.getKhoa_hoc_ID());
            cs.setInt(3, lh.getGiao_vien_ID());
            int result = cs.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
    public boolean update(LopHoc lh) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_updateLH(?,?,?,?)}");
            cs.setInt(1, lh.getId());
            cs.setString(2, lh.getTen_lop_hoc());
            cs.setInt(3, lh.getKhoa_hoc_ID());
            cs.setInt(4, lh.getGiao_vien_ID());
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
            CallableStatement cs = conn.prepareCall("{CALL proc_deleteLH(?)}");
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
         public List<LopHoc> Search(String name) {
        Connection conn = DataBaseConnection.getConnection();
        List<LopHoc> lst = new ArrayList<>();
        try {

            CallableStatement cs = conn.prepareCall("{CALL proc_SearchLH(?)}");
            cs.setString(1, name);
            
            ResultSet rs = cs.executeQuery();
            LopHoc lh;
            while (rs.next()) {
                lh = new LopHoc();
                lh.setId(rs.getInt("id"));
                lh.setTen_lop_hoc(rs.getString("ten_lop_hoc"));
                lh.setKhoa_hoc_ID(rs.getInt("khoa_hoc_ID"));
                lh.setGiao_vien_ID(rs.getInt("giao_vien_ID"));
                lh.setTen_khoa_hoc(rs.getString("ten_khoa_hoc"));
                lh.setTen_giao_vien(rs.getString("ten_giao_vien"));
                lst.add(lh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    } 
    public static void main(String[] args) {
        new LopHocDAO().getById(1);
        new LopHocDAO().delete(4);
    }
}
