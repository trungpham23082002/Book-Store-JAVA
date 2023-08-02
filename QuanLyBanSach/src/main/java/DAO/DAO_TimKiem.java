/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_SanPham;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class DAO_TimKiem {
    public static ArrayList<DTO_SanPham> getDS_fromTacGia(String tg)
    {
            ArrayList<DTO_SanPham> dshd = new ArrayList<DTO_SanPham>();
        try {
            String sql = "select * from Sach where TacGia like N'%"+tg+"%'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_SanPham hd;
                hd = new DTO_SanPham(rs.getString("MaSach"),rs.getString("TenSach"),rs.getString("TacGia"),rs.getString("MaTheLoai"),rs.getString("MaNXB"),rs.getString("MaTang"),rs.getString("MaKe"),rs.getString("HinhAnh"),rs.getInt("SoTrang"),rs.getInt("GiaBan"),rs.getInt("SoLuongTon"));
                dshd.add(hd);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            
        }
        return dshd;
    }
    
    public static ArrayList<DTO_SanPham> getDS_fromTheLoai(String mtl)
    {
            ArrayList<DTO_SanPham> dshd = new ArrayList<DTO_SanPham>();
        try {
            String sql = "select * from Sach where MaTheLoai='"+mtl+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_SanPham hd;
                hd = new DTO_SanPham(rs.getString("MaSach"),rs.getString("TenSach"),rs.getString("TacGia"),rs.getString("MaTheLoai"),rs.getString("MaNXB"),rs.getString("MaTang"),rs.getString("MaKe"),rs.getString("HinhAnh"),rs.getInt("SoTrang"),rs.getInt("GiaBan"),rs.getInt("SoLuongTon"));
                dshd.add(hd);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            
        }
        return dshd;
    }
    
    
}
