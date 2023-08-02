/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_NXB;
import DTO.DTO_TheLoai;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class DAO_TheLoai {
    public static ArrayList<DTO_TheLoai> listTheLoai()
    {
        ArrayList<DTO_TheLoai> ds = new ArrayList<DTO_TheLoai>();
        try {
            String sql = "select * from TheLoaiSach";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_TheLoai _ds = new DTO_TheLoai(rs.getString("MaTheLoai").trim(), rs.getString("TenTheLoai"));
                ds.add(_ds);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return ds;
    }
    public static String getTen_from_Ma(String _ma)
    {
        DTO_TheLoai ds = new DTO_TheLoai();
        try {
            String sql = "select * from TheLoaiSach where MaTheLoai ='"+_ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                
                return rs.getString("TenTheLoai");
            }
            cn.close();
            
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return "Error";
    }
    public static ArrayList<DTO_TheLoai> getDS_TheLoai()
    {
            ArrayList<DTO_TheLoai> dshd = new ArrayList<DTO_TheLoai>();
        try {
            String sql = "select * from TheLoaiSach";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_TheLoai hd;
                hd =new DTO_TheLoai(rs.getString("MaTheLoai").trim(), rs.getString("TenTheLoai"));
                dshd.add(hd);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            
        }
        return dshd;
    }
    public static boolean checkExistPrimarykey(String _ma)
    {
        try{
            String _sql="select * from TheLoaiSach where MaTheLoai='"+_ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                return true;
            }
            cn.close();
        }
        catch(Exception ex)
        {
        }
        return false;
    }
     
     public static boolean checkExistForeignkey(String _ma)
    {
        try{
            String _sql="select * from Sach where MaTheLoai='"+_ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                return true;
            }
            
            
            cn.close();
        }
        catch(Exception ex)
        {
        }
        return false;
    }
     
     public static boolean addSanPham(DTO_TheLoai sp)
     {
         try{
             String _sql="insert into TheLoaiSach values('"+sp.MaTheLoai+"',N'"+sp.TenTheLoai+"')";
            DBConnection cn = new DBConnection();
            cn.getCn();
            cn.executeUpdate(_sql);             
             cn.close();
             return true;
         }
         catch(Exception ex)
         {
             return false;
         }
     }
     
     public static boolean delSanPham(String sp)
     {
         try{
            DBConnection cn = new DBConnection();
            cn.getCn();
            cn.executeUpdate("delete from TheLoaiSach where MaTheLoai='"+sp+"'");             
             cn.close();
             return true;
         }
         catch(Exception ex)
         {
             return false;
         }
     }
     
     public static boolean updateSanPham(DTO_TheLoai sp)
     {
         try{
             String _sql="update TheLoaiSach set TenTheLoai=N'"+sp.TenTheLoai+"' where MaTheLoai=N'"+sp.MaTheLoai+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            cn.executeUpdate(_sql);             
             cn.close();
             return true;
         }
         catch(Exception ex)
         {
             return false;
         }
     }

}
