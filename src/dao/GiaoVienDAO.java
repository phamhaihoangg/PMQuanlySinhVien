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
import java.sql.SQLType;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GiaoVien;
import utility.DataBaseConnection;

/**
 *
 * @author HaiHoang
 */
public class GiaoVienDAO {

    public List<GiaoVien> getAll() {
        Connection conn = DataBaseConnection.getConnection();
        List<GiaoVien> lst = new ArrayList<>();
        try {

            CallableStatement cs = conn.prepareCall("{CALL proc_getAllGV}");
            ResultSet rs = cs.executeQuery();
            GiaoVien gv;
            while (rs.next()) {
                gv = new GiaoVien();
                gv.setId(rs.getInt("id"));
                gv.setTen_giao_vien(rs.getString("ten_giao_vien"));
                gv.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                gv.setEmail(rs.getString("email"));
                gv.setPassword(rs.getString("password"));
                gv.setDia_chi(rs.getString("dia_chi"));
                gv.setNgay_sinh(rs.getDate("ngay_sinh").toLocalDate());
                gv.setTrang_thai(rs.getInt("trang_thai"));
                gv.setQuyen_ID(rs.getInt("quyen_ID"));
                gv.setTen_quyen(rs.getString("Ten_quyen"));
                lst.add(gv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }

    public GiaoVien getById(int id) {
        Connection conn = DataBaseConnection.getConnection();
        GiaoVien gv = null;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_getGVById(?)}");
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                gv = new GiaoVien();
                gv.setId(rs.getInt("id"));
                gv.setTen_giao_vien(rs.getNString("ten_giao_vien"));
                gv.setSo_dien_thoai(rs.getNString("so_dien_thoai"));
                gv.setEmail(rs.getNString("email"));
                gv.setPassword(rs.getNString("password"));
                gv.setDia_chi(rs.getNString("dia_chi"));
                gv.setNgay_sinh(rs.getDate("ngay_sinh").toLocalDate());
                gv.setTrang_thai(rs.getInt("trang_thai"));
                gv.setQuyen_ID(rs.getInt("quyen_ID"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return gv;
    }

    public boolean insert(GiaoVien gv) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_createGV(?,?,?,?,?,?,?,?)}");
            cs.setNString(1, gv.getTen_giao_vien());
            cs.setNString(2, gv.getSo_dien_thoai());
            cs.setNString(3, gv.getEmail());
            cs.setNString(4, gv.getPassword());
            cs.setNString(5, gv.getDia_chi());
            cs.setDate(6, Date.valueOf(gv.getNgay_sinh()));
            cs.setInt(7, gv.getTrang_thai());
            cs.setInt(8, gv.getQuyen_ID());

            int result = cs.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean update(GiaoVien gv) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_updateGV(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, gv.getId());
            cs.setNString(2, gv.getTen_giao_vien());
            cs.setNString(3, gv.getSo_dien_thoai());
            cs.setNString(4, gv.getEmail());
            cs.setNString(5, gv.getPassword());
            cs.setNString(6, gv.getDia_chi());
            cs.setDate(7, Date.valueOf(gv.getNgay_sinh()));
            cs.setInt(8, gv.getTrang_thai());
            cs.setInt(9, gv.getQuyen_ID());
            int result = cs.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delete(int id) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_deleteGV(?)}");
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

    public int login(String user,String pass) {
       int id=0;
        try {
            Connection conn = DataBaseConnection.getConnection();
            
            
            
            CallableStatement cs = conn.prepareCall("{CALL proc_login(?,?,?)}");
            cs.setString(1, user);
            cs.setString(2, pass);
            cs.registerOutParameter(3,java.sql.Types.INTEGER);
            
            cs.execute();
             id = cs.getInt(3);
             System.out.println("id"+id );
            
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return id;
    }
     public List<GiaoVien> Search(String name) {
        Connection conn = DataBaseConnection.getConnection();
        List<GiaoVien> lst = new ArrayList<>();
        try {

            CallableStatement cs = conn.prepareCall("{CALL proc_SearchGV(?)}");
            cs.setString(1, name);
            
            ResultSet rs = cs.executeQuery();
            GiaoVien gv;
            while (rs.next()) {
                gv = new GiaoVien();
                gv.setId(rs.getInt("id"));
                gv.setTen_giao_vien(rs.getString("ten_giao_vien"));
                gv.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                gv.setEmail(rs.getString("email"));
                gv.setPassword(rs.getString("password"));
                gv.setDia_chi(rs.getString("dia_chi"));
                gv.setNgay_sinh(rs.getDate("ngay_sinh").toLocalDate());
                gv.setTrang_thai(rs.getInt("trang_thai"));
                gv.setQuyen_ID(rs.getInt("quyen_ID"));
                gv.setTen_quyen(rs.getString("Ten_quyen"));
                lst.add(gv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }

    public static void main(String[] args) {
        new GiaoVienDAO().getById(1);
        new GiaoVienDAO().delete(4);
    }
}
