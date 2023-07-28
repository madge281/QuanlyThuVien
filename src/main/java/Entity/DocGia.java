package Entity;

public class DocGia {
    String MaDG;
    String HoTen;
    boolean GioiTinh;
    String SDT;
    String CCCD;
    String SoLanMuon;
    String SoLanTraMuon;

    public DocGia() {
    }

    public DocGia(String MaDG, String HoTen, boolean GioiTinh, String SDT, String CCCD, String SoLanMuon, String SoLanTraMuon) {
        this.MaDG = MaDG;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.CCCD = CCCD;
        this.SoLanMuon = SoLanMuon;
        this.SoLanTraMuon = SoLanTraMuon;
    }

    public String getMaDG() {
        return MaDG;
    }

    public void setMaDG(String MaDG) {
        this.MaDG = MaDG;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSoLanMuon() {
        return SoLanMuon;
    }

    public void setSoLanMuon(String SoLanMuon) {
        this.SoLanMuon = SoLanMuon;
    }

    public String getSoLanTraMuon() {
        return SoLanTraMuon;
    }

    public void setSoLanTraMuon(String SoLanTraMuon) {
        this.SoLanTraMuon = SoLanTraMuon;
    }

    
    
    @Override
    public String toString() {
        return this.HoTen;
    }
}