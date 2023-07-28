package Entity;


public class CTPhieuMuon {
    String MaPhieuMuon;
    String MaSach;
    String TrangThai;
    int SoLuong;
    String GhiChu;

    public CTPhieuMuon() {
    }

    public CTPhieuMuon(String MaPhieuMuon, String MaSach, String TrangThai, int SoLuong, String GhiChu) {
        this.MaPhieuMuon = MaPhieuMuon;
        this.MaSach = MaSach;
        this.TrangThai = TrangThai;
        this.SoLuong = SoLuong;
        this.GhiChu = GhiChu;
    }

    public String getMaPhieuMuon() {
        return MaPhieuMuon;
    }

    public void setMaPhieuMuon(String MaPhieuMuon) {
        this.MaPhieuMuon = MaPhieuMuon;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
}