/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.MonHoc;
import utility.DataBaseConnection;

/**
 *
 * @author HaiHoang
 */
public class MonHocDAO {
     public List<MonHoc> getAll() {
        Connection conn = DataBaseConnection.getConnection();
        List<MonHoc> lst = new ArrayList<>();
        try 
        {
            
            
            CallableStatement cs = conn.prepareCall("{CALL proc_getAllMH}");
            ResultSet rs = cs.executeQuery();
            MonHoc mh;
            while (rs.next()) {
                mh = new MonHoc();
                mh.setId(rs.getInt("id"));
                mh.setTen_mon_hoc(rs.getNString("ten_mon_hoc"));
                mh.setTin_chi(rs.getInt("tin_chi"));
                mh.setHoc_phi(rs.getInt("hoc_phi"));
                mh.setTrang_thai(rs.getBoolean("trang_thai"));

                lst.add(mh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }
    
    public MonHoc getById(int id) {
        Connection conn = DataBaseConnection.getConnection();
        MonHoc mh = null;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_getMHById(?)}");
            cs.setInt(1,id);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                mh = new MonHoc();
                mh.setId(rs.getInt("id"));
                mh.setTen_mon_hoc(rs.getNString("ten_mon_hoc"));
                mh.setTin_chi(rs.getInt("tin_chi"));
                mh.setHoc_phi(rs.getInt("hoc_phi"));
                mh.setTrang_thai(rs.getBoolean("trang_thai"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mh;
    }
    
    public boolean insert(MonHoc mh) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_createMH(?,?,?,?)}");
            cs.setString(1, mh.getTen_mon_hoc());
            cs.setInt(2, Integer.valueOf(mh.getTin_chi()));
           cs.setInt(3, Integer.valueOf(mh.getHoc_phi()));
            cs.setBoolean(4, mh.getTrang_thai());
           
            int result = cs.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
    public boolean update(MonHoc mh) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_updateMH(?,?,?,?,?)}");
            cs.setInt(1, mh.getId());
            cs.setString(2, mh.getTen_mon_hoc());
            cs.setInt(3, Integer.valueOf(mh.getTin_chi()));
            cs.setInt(4, Integer.valueOf(mh.getHoc_phi()));
            cs.setBoolean(5, mh.getTrang_thai());
            
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
            CallableStatement cs = conn.prepareCall("{CALL proc_deleteMH(?)}");
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
     public List<MonHoc> Search(String name) {
        Connection conn = DataBaseConnection.getConnection();
        List<MonHoc> lst = new ArrayList<>();
        try {

            CallableStatement cs = conn.prepareCall("{CALL proc_SearchMH(?)}");
            cs.setString(1, name);
            
            ResultSet rs = cs.executeQuery();
            MonHoc mh;
            while (rs.next()) {
                mh = new MonHoc();
                mh.setId(rs.getInt("id"));
                mh.setTen_mon_hoc(rs.getNString("ten_mon_hoc"));
                mh.setTin_chi(rs.getInt("tin_chi"));
                mh.setHoc_phi(rs.getInt("hoc_phi"));
                mh.setTrang_thai(rs.getBoolean("trang_thai"));

                lst.add(mh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }
    public static void main(String[] args) {
        new MonHocDAO().getById(1);
        new MonHocDAO().delete(4);
    }
}
