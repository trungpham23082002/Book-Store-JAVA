/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author ChauCuteVCL
 */
public class DTO_HoaDonBan {

    public DTO_HoaDonBan(String soHD, String ngayLap, int tongTien, int tongGiam, int thanhTien, String maTV, String maGG, String nguoiLap) {
        this.soHD = soHD;
        this.maTV = maTV;
        this.maGG = maGG;
        this.ngayLap = ngayLap;
        this.nguoiLap = nguoiLap;
        this.tongTien = tongTien;
        this.tongGiam = tongGiam;
        this.thanhTien = thanhTien;
    }
    public String soHD, maTV, maGG, ngayLap, nguoiLap;
    public int tongTien, tongGiam, thanhTien;
    public DTO_HoaDonBan(){}
}
