package DAO;

import Entity.NhanVien;
import Utils.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDao {
    public static List<NhanVien> nv = new ArrayList<>();
    public int add(NhanVien nv){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "INSERT INTO NhanVien(MaNV,MatKhau,TenNV,ChucVu)"
                    + "values(?,?,?,?)";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, nv.getMaNV());
            sttm.setString(2, nv.getMatKhau());
            sttm.setString(3, nv.getTenNV());
            sttm.setBoolean(4, nv.isChucVu());
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
    
    public List<NhanVien> SelectAll(){
        List<NhanVien> ls = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM NhanVien";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()){
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setMatKhau(rs.getString(2));
                nv.setTenNV(rs.getString(3));
                nv.setChucVu(rs.getBoolean(4));
                
                ls.add(nv);
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
    
    public int update(NhanVien nv){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "UPDATE NhanVien set MatKhau = ?,TenNV = ?,ChucVu = ? where MaNV = ?";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(4, nv.getMaNV());
            sttm.setString(1, nv.getMatKhau());
            sttm.setString(2, nv.getTenNV());
            sttm.setBoolean(3, nv.isChucVu());
            
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
    
    public int Delete(String maSV){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "DELETE FROM NhanVien where MaNV =?";
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
    

    
    public NhanVien SelectbyID(String maSV){
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        NhanVien nv = new NhanVien();
        try {
            String sSQL="SELECT * FROM NhanVien where MaNV = ?";
            conn = JdbcHelper.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maSV);
            rs = sttm.executeQuery();
            while(rs.next()){
                nv.setMaNV(rs.getString(1));
                nv.setMatKhau(rs.getString(2));
                nv.setMatKhau(rs.getString(3));
                nv.setChucVu(rs.getBoolean(4));
                return nv;
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
    
    final String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien where MaNV = ?";
    public NhanVien selectById(String id) {
        List<NhanVien> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
//    public NhanVien selectId(String id) {
//        List<NhanVien> list = selectBySql(SELECT_BY_ID_SQL, id);
//        if (list.isEmpty()) {
//            return null;
//        }
//        return list.get(0);
//    }
    
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setChucVu(rs.getBoolean("ChucVu"));
                list.add(nv);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
