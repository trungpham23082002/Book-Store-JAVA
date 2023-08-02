/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author pc
 */
public class DTO_PhieuGG {
    public String MaGiamGia, TenGiamGia, NgayBD,NgayKT;
    public int PhanTramGiamGia;
    public DTO_PhieuGG(){}
    public DTO_PhieuGG(String _ma, String _ten, int _phantram, String _bd, String _kt)
    {
        MaGiamGia = _ma;
        TenGiamGia=_ten;
        PhanTramGiamGia=_phantram;
        NgayBD =_bd;
        NgayKT=_kt;
        
    }
}
