package DAO;

import Entity.Sach;
import Utils.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SachDao {
    public static List<Sach> s = new ArrayList<>();
    
    public int add(Sach s){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert into Sach(MaSach,TenSach,TacGia,SoLuong,GiaTien,SLChuaThue,Anh)"
                    + "values(?,?,?,?,?,?,?)";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, s.getMaSach());
            sttm.setString(2, s.getTenSach());
            sttm.setString(3, s.getTacGia());
            sttm.setInt(4, s.getSoluong());
            sttm.setString(5, s.getGiaTien());
            sttm.setInt(6, s.getSoLuongChuaThue());
            sttm.setString(7, s.getAnh());
            if (sttm.executeUpdate() > 0) {
                System.out.println("Add oke");
                return 1;
            }
        } catch (Exception e) {

            System.out.println("Error"+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return -1;
    }
    
    public int adddemo(Sach s){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert into Sachdemo(MaSach,TacGia,SoLuong,GiaTien,SLChuaThue,Anh)"
                    + "values(?,?,?,?,?,?)";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, s.getMaSach());
            sttm.setString(2, s.getTacGia());
            sttm.setInt(3, s.getSoluong());
            sttm.setString(4, s.getGiaTien());
            sttm.setInt(5, s.getSoLuongChuaThue());
            sttm.setString(6, s.getAnh());
            if (sttm.executeUpdate() > 0) {
                System.out.println("Add oke");
                return 1;
            }
        } catch (Exception e) {

            System.out.println("Error"+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return -1;
    }
    
    public List<Sach> getAllSach(){
        List<Sach> ls = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "Select * from Sach";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()){
                Sach s = new Sach();
                    s.setMaSach(rs.getString(1));
                    s.setTenSach(rs.getString(2));
                    s.setTacGia(rs.getString(3));
                    s.setSoluong(rs.getInt(4));
                    s.setGiaTien(rs.getString(5));
                    s.setSoLuongChuaThue(rs.getInt(6));
                    //s.setAnh(rs.getString(7));
                ls.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error:"+e.toString());
        }finally{
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return ls;
    }
    
    public Sach getSinhVienByID(String maSV){
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        Sach dg = new Sach();
        try {
            String sSQL="select * from Sach where MaSach=?";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maSV);
            rs = sttm.executeQuery();
            while(rs.next()){
                dg.setMaSach(rs.getString(1));
                dg.setTenSach(rs.getString(2));
                dg.setTacGia(rs.getString(3));
                dg.setSoluong(rs.getInt(4));
                dg.setGiaTien(rs.getString(5));
                dg.setSoLuongChuaThue(rs.getInt(6));
                dg.setAnh(rs.getString(7));
                return dg;
            }
        } catch (Exception e) {
        }finally{
            try {
                conn.close();
                rs.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    
    public int updateSinhVienByID(Sach s){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update Sach set TenSach=?,TacGia=?,SoLuong=?,GiaTien=?,SLChuaThue=?,Anh=? where MaSach = ?";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            
            sttm.setString(7, s.getMaSach());
            sttm.setString(1, s.getTenSach());
            sttm.setString(2, s.getTacGia());
            sttm.setInt(3, s.getSoluong());
            sttm.setString(4, s.getGiaTien());
            sttm.setInt(5, s.getSoLuongChuaThue());
            sttm.setString(6, s.getAnh());
            if (sttm.executeUpdate() > 0) {
                System.out.println("Update oke");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return -1;
    }
    
    public int updateSachdemo(Sach s){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update Sachdemo set TacGia=?,SoLuong=?,GiaTien=?,SLChuaThue=?,Anh=? where MaSach = ?";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            
            sttm.setString(6, s.getMaSach());
            sttm.setString(1, s.getTacGia());
            sttm.setInt(2, s.getSoluong());
            sttm.setString(3, s.getGiaTien());
            sttm.setInt(4, s.getSoLuongChuaThue());
            sttm.setString(5, s.getAnh());
            if (sttm.executeUpdate() > 0) {
                System.out.println("Update oke");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return -1;
    }
    
    public int delSinhVienByID(String maSV){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "Delete Sach where MaSach=?";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maSV);
            if (sttm.executeUpdate() > 0) {
                System.out.println("Delete oke");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return -1;
    }
    
    public int delSachdemo(String maSV){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "Delete Sachdemo where MaSach=?";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maSV);
            if (sttm.executeUpdate() > 0) {
                System.out.println("Delete oke");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return -1;
    }
    
    final String SELECT_BY_ID_SQL = "SELECT * FROM Sach where MaSach = ?";
    public Sach selectById(String id) {
        List<Sach> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public List<Sach> selectBySql(String sql, Object... args) {
        List<Sach> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Sach entity = new Sach();
                entity.setMaSach(rs.getString("MaSach"));
                entity.setTenSach(rs.getString("TenSach"));
                entity.setTacGia(rs.getString("TacGia"));
                entity.setSoluong(rs.getInt("SoLuong"));
                entity.setGiaTien(rs.getString("GiaTien"));
                entity.setSoLuongChuaThue(rs.getInt("SLChuaThue"));
                entity.setAnh(rs.getString("Anh"));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
