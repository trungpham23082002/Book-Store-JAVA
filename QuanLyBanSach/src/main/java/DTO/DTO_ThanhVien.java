/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author pc
 */
public class DTO_ThanhVien {
    public String MaTV, TenThanhVien,SDT,MaLoaiTV;
    public int TienDaMua;
    public DTO_ThanhVien(){}
    public DTO_ThanhVien(String _ma, String _ten, String _sdt, int _tienDM, String _maLTV)
    {
        MaTV = _ma;
        TenThanhVien=_ten;
        SDT =_sdt;
        TienDaMua=_tienDM;
        MaLoaiTV=_maLTV;
    }
}
