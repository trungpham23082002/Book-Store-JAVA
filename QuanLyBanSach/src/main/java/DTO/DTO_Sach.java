/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ChauCuteVCL
 */
public class DTO_Sach {
    public String masach, tensach, tacgia, nxb, theloai, hinhanh;
    public int giaban, soluongton;
    public DTO_Sach(){}
    public DTO_Sach(String _masach,String _tensach,String _tacgia,String _nxb,String _theloai,int _giaban ,String _hinhanh,int _slt)
    {
        this.masach = _masach;
        this.tensach = _tensach;
        this.tacgia = _tacgia;
        this.nxb = _nxb;
        this.theloai = _theloai;
        this.hinhanh = _hinhanh;
        this.giaban = _giaban;
        this.soluongton=_slt;
    }
}
