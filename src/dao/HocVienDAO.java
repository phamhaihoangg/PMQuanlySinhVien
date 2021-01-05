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
import model.HocVien;
import utility.DataBaseConnection;

/**
 *
 * @author HaiHoang
 */
public class HocVienDAO {
    public List<HocVien> getAll() {
        Connection conn = DataBaseConnection.getConnection();
        List<HocVien> lst = new ArrayList<>();
        try 
        {
            
            
            CallableStatement cs = conn.prepareCall("{CALL proc_getAllHV}");
            ResultSet rs = cs.executeQuery();
            HocVien hv;
            while (rs.next()) {
                hv = new HocVien();
                hv.setId(rs.getInt("id"));
                hv.setMa_hoc_vien(rs.getString("ma_hoc_vien"));
                hv.setTen_hoc_vien(rs.getString("ten_hoc_vien"));
                hv.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                hv.setEmail(rs.getString("email"));
                hv.setDia_chia(rs.getString("dia_chia"));
                hv.setNgay_sinh(rs.getDate("ngay_sinh").toLocalDate());
                hv.setGioi_tinh(rs.getBoolean("gioi_tinh"));
                hv.setTrang_thai(rs.getBoolean("trang_thai"));
                hv.setLop_hoc_ID(rs.getInt("lop_hoc_ID"));
                hv.setTen_lop_hoc(rs.getString("ten_lop_hoc"));
                lst.add(hv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }
    
    public HocVien getById(int id) {
        Connection conn = DataBaseConnection.getConnection();
        HocVien hv = null;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_getHVById(?)}");
            cs.setInt(1,id);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                hv = new HocVien();
                hv.setId(rs.getInt("id"));
                hv.setMa_hoc_vien(rs.getNString("ma_hoc_vien"));
                hv.setTen_hoc_vien(rs.getNString("ten_hoc_vien"));
                hv.setSo_dien_thoai(rs.getNString("so_dien_thoai"));
                hv.setEmail(rs.getNString("email"));
                hv.setDia_chia(rs.getNString("dia_chia"));
                hv.setNgay_sinh(rs.getDate("ngay_sinh").toLocalDate());
                hv.setGioi_tinh(rs.getBoolean("gioi_tinh"));
                hv.setTrang_thai(rs.getBoolean("trang_thai"));
                hv.setLop_hoc_ID(rs.getInt("lop_hoc_ID"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hv;
    }
    
    public boolean insert(HocVien hv) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_createHV(?,?,?,?,?,?,?,?,?)}");
            cs.setNString(1, hv.getMa_hoc_vien());
            cs.setNString(2, hv.getTen_hoc_vien());
            cs.setNString(3, hv.getSo_dien_thoai());
            cs.setNString(4, hv.getEmail());
            cs.setNString(5, hv.getDia_chia());
            cs.setDate(6, Date.valueOf(hv.getNgay_sinh()));
            cs.setBoolean(7, hv.getGioi_tinh());
            cs.setBoolean(8, hv.getTrang_thai());
            cs.setInt(9, hv.getLop_hoc_ID());
            int result = cs.executeUpdate();



        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
    public boolean update(HocVien hv) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_updateHV(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1,hv.getId());
            cs.setNString(2, hv.getMa_hoc_vien());
            cs.setNString(3, hv.getTen_hoc_vien());
            cs.setNString(4, hv.getSo_dien_thoai());
            cs.setNString(5, hv.getEmail());
            cs.setNString(6, hv.getDia_chia());
            cs.setDate(7, Date.valueOf(hv.getNgay_sinh()));
            cs.setBoolean(8, hv.getGioi_tinh());
            cs.setBoolean(9, hv.getTrang_thai());
            cs.setInt(10, hv.getLop_hoc_ID());
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
            CallableStatement cs = conn.prepareCall("{CALL proc_deleteHV(?)}");
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
     public List<HocVien> Search(String name) {
        Connection conn = DataBaseConnection.getConnection();
        List<HocVien> lst = new ArrayList<>();
        try {

            CallableStatement cs = conn.prepareCall("{CALL proc_SearchHV(?)}");
            cs.setString(1, name);
            
            ResultSet rs = cs.executeQuery();
            HocVien hv;
            while (rs.next()) {
                hv = new HocVien();
                hv.setId(rs.getInt("id"));
                hv.setMa_hoc_vien(rs.getString("ma_hoc_vien"));
                hv.setTen_hoc_vien(rs.getString("ten_hoc_vien"));
                hv.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                hv.setEmail(rs.getString("email"));
                hv.setDia_chia(rs.getString("dia_chia"));
                hv.setNgay_sinh(rs.getDate("ngay_sinh").toLocalDate());
                hv.setGioi_tinh(rs.getBoolean("gioi_tinh"));
                hv.setTrang_thai(rs.getBoolean("trang_thai"));
                hv.setLop_hoc_ID(rs.getInt("lop_hoc_ID"));
                hv.setTen_lop_hoc(rs.getString("ten_lop_hoc"));
                lst.add(hv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }
    public static void main(String[] args) {
        new HocVienDAO().getById(1);
        new HocVienDAO().delete(4);
    }
}
