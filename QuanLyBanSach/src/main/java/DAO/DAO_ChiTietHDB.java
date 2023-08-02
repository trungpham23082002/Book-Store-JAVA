/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_ChiTietHoaDonBan;
import DTO.DTO_HoaDonBan;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class DAO_ChiTietHDB {
    public static ArrayList<DTO_ChiTietHoaDonBan> getDS_CTHDB(String sohd)
    {
        ArrayList<DTO_ChiTietHoaDonBan> dshd = new ArrayList<DTO_ChiTietHoaDonBan>();
        try {
            String sql = "select * from ChiTietHoaDonBan where SoHD="+sohd;
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_ChiTietHoaDonBan hd = new DTO_ChiTietHoaDonBan(rs.getString("MaSach"),rs.getString("SoHD"),rs.getInt("SoLuong"),rs.getInt("TongTien"));
                dshd.add(hd);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            
        }
        return dshd;
    }
}
