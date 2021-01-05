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
import model.Quyen;
import utility.DataBaseConnection;

/**
 *
 * @author HaiHoang
 */
public class QuyenDAO {
    public List<Quyen> getAll() {
        Connection conn = DataBaseConnection.getConnection();
        List<Quyen> lst = new ArrayList<>();
        try 
        {
            
            
            CallableStatement cs = conn.prepareCall("{CALL proc_getAllQuyen}");
            ResultSet rs = cs.executeQuery();
            Quyen q;
            while (rs.next()) {
                q = new Quyen();
                q.setId(rs.getInt("id"));
                q.setTen_quyen(rs.getNString("ten_quyen"));
                
                lst.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }
    
    public Quyen getById(int id) {
        Connection conn = DataBaseConnection.getConnection();
        Quyen q = null;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_getQuyenById(?)}");
            cs.setInt(1,id);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                q = new Quyen();
                q.setId(rs.getInt("id"));
                q.setTen_quyen(rs.getNString("ten_quyen"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return q;
    }
    
    public boolean insert(Quyen q) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_createQuyen(?,?,?)}");
            cs.setInt(1, q.getId());
            cs.setNString(2, q.getTen_quyen());
            cs.registerOutParameter(3, Types.NVARCHAR);
            int result = cs.executeUpdate();

            String msg = cs.getNString("msg");
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
    public boolean update(Quyen q) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try {
            CallableStatement cs = conn.prepareCall("{CALL proc_updateQuyen(?,?,?)}");
            cs.setInt(1, q.getId());
            cs.setNString(2, q.getTen_quyen());
            cs.registerOutParameter(3, Types.NVARCHAR);
            int result = cs.executeUpdate();
            String msg = cs.getNString("msg");
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
    public boolean delete(int id) {
        Connection conn = DataBaseConnection.getConnection();
        boolean flag = false;
        try  {
            CallableStatement cs = conn.prepareCall("{CALL proc_deleteQuyen(?)}");
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
     
    public static void main(String[] args) {
        new QuyenDAO().getById(1);
        new QuyenDAO().delete(4);
    }
}
