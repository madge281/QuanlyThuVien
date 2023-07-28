package Entity;


public class PhieuMuon {
    String MaPhieuMuon;
    String MaSach;
    String TenSach;
    String MaDG;
    String MaNV;
    String NgayMuon;
    String NgayTra;

    public PhieuMuon() {
    }

    public PhieuMuon(String MaPhieuMuon, String MaSach, String TenSach, String MaDG, String MaNV, String NgayMuon, String NgayTra) {
        this.MaPhieuMuon = MaPhieuMuon;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.MaDG = MaDG;
        this.MaNV = MaNV;
        this.NgayMuon = NgayMuon;
        this.NgayTra = NgayTra;
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

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public String getMaDG() {
        return MaDG;
    }

    public void setMaDG(String MaDG) {
        this.MaDG = MaDG;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(String NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public String getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(String NgayTra) {
        this.NgayTra = NgayTra;
    }
    
    @Override
    public String toString() {
        return this.TenSach;
    }

}
        