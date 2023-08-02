/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author pc
 */
public class DTO_HoaDonNhap {
    public String soHD, ngaylap, ghichu, masach, mataikhoan,maloaihd;
    public int soluong , tongtien;
    public DTO_HoaDonNhap(String _sohoadon,int _sl,int _tongtien,String _ngaylap,String _ghichu,String _masach,String _matk,String _maloaihd) {
        this.soHD=_sohoadon;
        this.soluong=_sl;
        this.tongtien=_tongtien;
        this.ngaylap=_ngaylap;
        this.ghichu=_ghichu;
        this.masach=_masach;
        this.mataikhoan=_matk;
        this.maloaihd=_maloaihd;
    }

    public DTO_HoaDonNhap(){} 
}
