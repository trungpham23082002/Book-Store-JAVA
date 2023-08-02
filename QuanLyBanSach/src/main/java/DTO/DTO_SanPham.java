/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author pc
 */
public class DTO_SanPham {

    public DTO_SanPham(String _MaSach, String _TenSach, String _TacGia, String _MaTheLoai, String _MaNXB, String _MaTang, String _MaKe, String _HinhAnh, int _SoTrang, int _GiaBan, int _SoLuongTon) {
        this.MaSach = _MaSach;
        this.TenSach = _TenSach;
        this.TacGia = _TacGia;
        this.MaNXB = _MaNXB;
        this.MaTheLoai = _MaTheLoai;
        this.MaTang = _MaTang;
        this.MaKe = _MaKe;
        this.HinhAnh = _HinhAnh;
        this.SoTrang = _SoTrang;
        this.GiaBan = _GiaBan;
        this.SoLuongTon = _SoLuongTon;
    }
    public DTO_SanPham(){}
  
    public String MaSach , TenSach , TacGia , MaNXB , MaTheLoai , MaTang , MaKe , HinhAnh;
    public int SoTrang , GiaBan , SoLuongTon;


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

    public String getMaNXB() {
        return MaNXB;
    }

    public void setMaNXB(String MaNXB) {
        this.MaNXB = MaNXB;
    }

    public String getMaTheLoai() {
        return MaTheLoai;
    }

    public void setMaTheLoai(String MaTheLoai) {
        this.MaTheLoai = MaTheLoai;
    }

    public String getMaTang() {
        return MaTang;
    }

    public void setMaTang(String MaTang) {
        this.MaTang = MaTang;
    }

    public String getMaKe() {
        return MaKe;
    }

    public void setMaKe(String MaKe) {
        this.MaKe = MaKe;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public int getSoTrang() {
        return SoTrang;
    }

    public void setSoTrang(int SoTrang) {
        this.SoTrang = SoTrang;
    }

    public int getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(int GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(int SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }
    
  

}
