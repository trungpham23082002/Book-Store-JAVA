/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author pc
 */
public class DTO_ChiTietHoaDon {

    public DTO_ChiTietHoaDon(String maSach, String tenSach, String ngayLap, String nguoiLap, int giaban, int soluong, int tongtien) {
        this.masach = maSach;
        this.tensach = tenSach;
        this.ngaylap = ngayLap;
        this.nguoilap = nguoiLap;
        this.giaban = giaban;
        this.soluong = soluong;
        this.tongtien = tongtien;
    }
    public String masach, tensach, ngaylap, nguoilap;
    public int giaban, soluong, tongtien;
}
