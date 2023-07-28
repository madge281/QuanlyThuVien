package DAO;

import Utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDao {
    public List<Integer> selectYears() {
        String sql = "SELECT DISTINCT DAY(NgayMuon) DAY FROM PhieuMuon ORDER BY DAY DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Object[]> getTopMuon() {
        String sql = "{CALL sp_TopMuon}";
        String[] cols = {"MaDG", "HoTen", "SoLanMuon", "SoLanTraMuon"};
        return getListOfArray(sql, cols);
    }
    public List<Object[]> getTopSach() {
        String sql = "{CALL sp_TopSach}";
        String[] cols = {"MaSach", "TenSach", "TacGia", "Da Thue"};
        return getListOfArray(sql, cols);
    }
     public List<Object[]> getDoanhThu(Integer nam) {
        String sql = "{CALL sp_DoanhThu(?)}";
        String[] cols = {"TenSach","MaSach", "DoanhThu", "ThapNhat", "CaoNhat", "TrungBinh"};
        return getListOfArray(sql, cols, nam);
    }
}
