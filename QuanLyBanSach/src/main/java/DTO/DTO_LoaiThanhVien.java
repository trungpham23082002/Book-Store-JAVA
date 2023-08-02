/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author pc
 */
public class DTO_LoaiThanhVien {
    public String MaLoaiTV,TenLoaiTV;
    public int TienCanDat,PhanTramGiamGia;
    
    
    public DTO_LoaiThanhVien()
    {
        
    }
    public DTO_LoaiThanhVien(String _ma, String _ten,int _tien,int _giamgia)      
    {
        MaLoaiTV=_ma;
        TenLoaiTV=_ten;
        TienCanDat=_tien;
        PhanTramGiamGia=_giamgia;
    }
}
