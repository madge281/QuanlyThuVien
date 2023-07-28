package DAO;

import Entity.CTPhieuMuon;
import Entity.PhieuMuon;
import Utils.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CTPhieuMuonDao {
    
    public static List<CTPhieuMuon> ctpm = new ArrayList<>();
    
    public int add(CTPhieuMuon ctpm){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "INSERT INTO CTPhieuMuon(MaPhieuMuon,MaSach,TrangThai,SoLuong,GhiChu)"
                    + "values(?,?,?,?,?)";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, ctpm.getMaPhieuMuon());
            sttm.setString(2, ctpm.getMaSach());
            sttm.setString(3, ctpm.getTrangThai());
            sttm.setInt(4, ctpm.getSoLuong());
            sttm.setString(5, ctpm.getGhiChu());
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
    
    public List<CTPhieuMuon> SelectAll(){
        List<CTPhieuMuon> ls = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM CTPhieuMuon";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()){
                CTPhieuMuon ctpm = new CTPhieuMuon();
                ctpm.setMaPhieuMuon(rs.getString(1));
                ctpm.setMaSach(rs.getString(2));
                ctpm.setTrangThai(rs.getString(3));
                ctpm.setSoLuong(rs.getInt(4));
                ctpm.setGhiChu(rs.getString(5));
                ls.add(ctpm);
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
    
    
    public int update(CTPhieuMuon ctpm){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "UPDATE CTPhieuMuon set MaSach = ?,TrangThai = ?,SoLuong = ?,GhiChu = ? where MaPhieuMuon = ?";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(5, ctpm.getMaPhieuMuon());
            sttm.setString(1, ctpm.getMaSach());
            sttm.setString(2, ctpm.getTrangThai());
            sttm.setInt(3, ctpm.getSoLuong());
            sttm.setString(4, ctpm.getGhiChu());
            
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
    
    public int updatepm(PhieuMuon pm){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update PhieuMuon set MaSach = ? where MaPhieuMuon = ?";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(2, pm.getMaPhieuMuon());
            sttm.setString(1, pm.getMaSach());
            if (sttm.executeUpdate() > 0) {
                System.out.println("Update Thành Công!");
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
    
    public int Delete(String MaPhieuMuon){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "DELETE FROM CTPhieuMuon where MaPhieuMuon =?";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, MaPhieuMuon);
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
    
    public CTPhieuMuon SelectbyID(String maSV){
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        CTPhieuMuon ctpm = new CTPhieuMuon();
        try {
            String sSQL="SELECT * FROM CTPhieuMuon where MaPhieuMuon = ?";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maSV);
            rs = sttm.executeQuery();
            while(rs.next()){
                ctpm.setMaPhieuMuon(rs.getString(1));
                ctpm.setMaSach(rs.getString(2));
                ctpm.setTrangThai(rs.getString(3));
                ctpm.setSoLuong(rs.getInt(4));
                ctpm.setGhiChu(rs.getString(5));
                return ctpm;
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
    
    public List<CTPhieuMuon> selectBySql(String sql, Object... args) {
        List<CTPhieuMuon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                CTPhieuMuon ctpm = new CTPhieuMuon();
                ctpm.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                ctpm.setMaSach(rs.getString("MaSach"));
                ctpm.setTrangThai(rs.getString("trangThai"));
                ctpm.setSoLuong(rs.getInt("SoLuong"));
                ctpm.setGhiChu(rs.getString("GhiChu"));
                list.add(ctpm);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
