package Entity;


public class Sach {
    String MaSach;
    String TenSach;
    String TacGia;
    int Soluong;
    String GiaTien;
    int SoLuongChuaThue;
    String Anh;

    public Sach() {
    }

    public Sach(String MaSach, String TenSach, String TacGia, int Soluong, String GiaTien, int SoLuongChuaThue, String Anh) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TacGia = TacGia;
        this.Soluong = Soluong;
        this.GiaTien = GiaTien;
        this.SoLuongChuaThue = SoLuongChuaThue;
        this.Anh = Anh;
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

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public String getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(String GiaTien) {
        this.GiaTien = GiaTien;
    }

    public int getSoLuongChuaThue() {
        return SoLuongChuaThue;
    }

    public void setSoLuongChuaThue(int SoLuongChuaThue) {
        this.SoLuongChuaThue = SoLuongChuaThue;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }
  
}