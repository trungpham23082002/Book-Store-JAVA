/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ChauCuteVCL
 */
public class DTO_TaiKhoan {
    public String MaTaiKhoan, TenDangNhap, MatKhau,HoTen,SDT,MaQuyen;
    public boolean BiKhoa;
    public DTO_TaiKhoan(String _matk, String _tendn, String _mk,String _hoten,String _sdt,String _maquyen, boolean _bikhoa)
    {
        this.MaTaiKhoan = _matk;
        this.TenDangNhap=_tendn;
        this.MatKhau =_mk;
        this.HoTen=_hoten;
        this.SDT=_sdt;
        this.MaQuyen=_maquyen;
        this.BiKhoa = _bikhoa;
    }
    public DTO_TaiKhoan()
    {
        
    }
}
