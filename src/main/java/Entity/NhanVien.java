package Entity;

public class NhanVien {
    String MaNV;
    String MatKhau;
    String TenNV;
    boolean ChucVu;
    
    public NhanVien() {
    }

    public NhanVien(String MaNV, String MatKhau, String TenNV, boolean ChucVu) {
        this.MaNV = MaNV;
        this.MatKhau = MatKhau;
        this.TenNV = TenNV;
        this.ChucVu = ChucVu;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public boolean isChucVu() {
        return ChucVu;
    }

    public void setChucVu(boolean ChucVu) {
        this.ChucVu = ChucVu;
    }
    
}