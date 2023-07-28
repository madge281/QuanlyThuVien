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


public class PhieuMuonDao {
    public static List<PhieuMuon> pm = new ArrayList<>();
    
    public int add(PhieuMuon pm){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert into PhieuMuon(MaPhieuMuon,MaSach,TenSach,MaDG,MaNV,NgayMuon,NgayTra)"
                    + "values(?,?,?,?,?,?,?)";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, pm.getMaPhieuMuon());
            sttm.setString(2, pm.getMaSach());
            sttm.setString(3, pm.getTenSach());
            sttm.setString(4, pm.getMaDG());
            sttm.setString(5, pm.getMaNV());
            sttm.setString(6, pm.getNgayMuon());
            sttm.setString(7, pm.getNgayTra());
            if (sttm.executeUpdate() > 0) {
                System.out.println("Thêm Mới Thành Công!");
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
    
    public int addct(CTPhieuMuon ctpm){
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
    
    public List<PhieuMuon> getAllPhieuMuon(){
        List<PhieuMuon> ls = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "Select * from PhieuMuon";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()){
                PhieuMuon pm = new PhieuMuon();
                    pm.setMaPhieuMuon(rs.getString(1));
                    pm.setMaSach(rs.getString(2));
                    pm.setTenSach(rs.getString(3));
                    pm.setMaDG(rs.getString(4));
                    pm.setMaNV(rs.getString(5));
                    pm.setNgayMuon(rs.getString(6));
                    pm.setNgayTra(rs.getString(7));
                ls.add(pm);
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
    
    public PhieuMuon getPhieuMuonByID(String MaPhieuMuon){
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        PhieuMuon pm = new PhieuMuon();
        try {
            String sSQL="select * from PhieuMuon where MaPhieuMuon=?";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, MaPhieuMuon);
            rs = sttm.executeQuery();
            while(rs.next()){
                pm.setMaPhieuMuon(rs.getString(1));
                pm.setMaSach(rs.getString(2));
                pm.setTenSach(rs.getString(3));
                pm.setMaDG(rs.getString(4));
                pm.setMaNV(rs.getString(5));
                pm.setNgayMuon(rs.getString(6));
                pm.setNgayTra(rs.getString(7));
                return pm;
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
    
    public int updateMaPhieuMuonByID(PhieuMuon pm){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update PhieuMuon set MaSach=?,TenSach=?,MaDG=?,MaNV=?,NgayMuon=?, NgayTra=? where MaPhieuMuon = ?";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            
            sttm.setString(7, pm.getMaPhieuMuon());
            sttm.setString(1, pm.getMaSach());
            sttm.setString(2, pm.getTenSach());
            sttm.setString(3, pm.getMaDG());
            sttm.setString(4, pm.getMaNV());
            sttm.setString(5, pm.getNgayMuon());
            sttm.setString(6, pm.getNgayTra());
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
    
    public int updateCT(CTPhieuMuon ctpm){
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
    
    public int delMaPhieuMuonByID(String MaPhieuMuon){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "Delete PhieuMuon where MaPhieuMuon=?";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, MaPhieuMuon);
            if (sttm.executeUpdate() > 0) {
                System.out.println("Delete Thành Công!");
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
//    final String SELECT_BY_ID_SQL = "SELECT * FROM PhieuMuon where MaPhieuMuon = ?";
//    public PhieuMuon selectById(String id) {
//        List<PhieuMuon> list = selectBySql(SELECT_BY_ID_SQL, id);
//        if (list.isEmpty()) {
//            return null;
//        }
//        return list.get(0);
//    }
//    
//    public List<PhieuMuon> selectBySql(String sql, Object... args) {
//        List<PhieuMuon> list = new ArrayList<>();
//        try {
//            ResultSet rs = JdbcHelper.query(sql, args);
//            while (rs.next()) {
//                PhieuMuon entity = new PhieuMuon();
//                entity.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
//                entity.setMaSach(rs.getString("MaSach"));
//                entity.setTenSach(rs.getString("TenSach"));
//                entity.setMaDG(rs.getString("MaDG"));
//                entity.setMaNV(rs.getString("MaNV"));
//                entity.setNgayMuon(rs.getString("NgayMuon"));
//                entity.getNgayTra(rs.getString("NgayTra"));
//                list.add(entity);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return list;
//    }
        
}
