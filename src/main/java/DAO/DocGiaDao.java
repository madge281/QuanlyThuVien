package DAO;

import java.util.ArrayList;
import java.util.List;
import Entity.DocGia;
import Utils.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DocGiaDao {
    public static List<DocGia> dg = new ArrayList<>();
    
    public int add(DocGia dg){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "Insert into DocGia(MaDG,HoTen,GioiTinh,SDT,CCCD,SoLanMuon,SoLanTraMuon)"
                    + "values(?,?,?,?,?,?,?)";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, dg.getMaDG());
            sttm.setString(2, dg.getHoTen());
            sttm.setBoolean(3, dg.isGioiTinh());
            sttm.setString(4, dg.getSDT());
            sttm.setString(5, dg.getCCCD());
            sttm.setString(6, dg.getSoLanMuon());
            sttm.setString(7, dg.getSoLanTraMuon());
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
    
    public List<DocGia> getAllDocGia(){
        List<DocGia> ls = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "Select * from DocGia";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()){
                DocGia dg = new DocGia();
                dg.setMaDG(rs.getString(1));
                dg.setHoTen(rs.getString(2));
                dg.setGioiTinh(rs.getBoolean(3));
                dg.setSDT(rs.getString(4));
                dg.setCCCD(rs.getString(5));
                dg.setSoLanMuon(rs.getString(6));
                dg.setSoLanTraMuon(rs.getString(7));
                ls.add(dg);
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
    
    public int delDocGiaByID(String maSV){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "Delete DocGia where MaDG=?";
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
    
    public int updateDocGiaByID(DocGia dg){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update DocGia set HoTen = ?,GioiTinh=?,SDT = ?,CCCD = ?,SoLanMuon = ?,SoLanTraMuon = ? where MaDG = ?";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(7, dg.getMaDG());
            sttm.setString(1, dg.getHoTen());
            sttm.setBoolean(2, dg.isGioiTinh());
            sttm.setString(3, dg.getSDT());
            sttm.setString(4, dg.getCCCD());
            sttm.setString(5, dg.getSoLanMuon());
            sttm.setString(6, dg.getSoLanTraMuon());
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
    
    
    public DocGia getDocGiaByID(String maSV){
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        DocGia dg = new DocGia();
        try {
            String sSQL="select * from DocGia where MaDG=?";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maSV);
            rs = sttm.executeQuery();
            while(rs.next()){
                dg.setMaDG(rs.getString(1));
                dg.setHoTen(rs.getString(2));
                dg.setGioiTinh(rs.getBoolean(3));
                dg.setSDT(rs.getString(4));
                dg.setCCCD(rs.getString(5));
                dg.setSoLanMuon(rs.getString(6));
                dg.setSoLanTraMuon(rs.getString(7));
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
    
    final String SELECT_BY_ID_SQL = "SELECT * FROM DocGia where MaDG = ?";
    public DocGia selectById(String id) {
        List<DocGia> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    

    public List<DocGia> selectBySql(String sql, Object... args) {
        List<DocGia> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                DocGia entity = new DocGia();
                entity.setMaDG(rs.getString("MaDG"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setSDT(rs.getString("SDT"));
                entity.setCCCD(rs.getString("CCCD"));
                entity.setSoLanMuon(rs.getString("SoLanMuon"));
                entity.setSoLanTraMuon(rs.getString("SoLanTraMuon"));
                list.add(entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
