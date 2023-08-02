/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.DTO_KeDat;
/**
 *
 * @author pc
 */
public class DAO_KeDat {
    public static ArrayList<DTO.DTO_KeDat> listKeDat()
    {
        ArrayList<DTO.DTO_KeDat> ds = new ArrayList<DTO.DTO_KeDat>();
        try {
            String sql = "select * from KeDat";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO.DTO_KeDat _ds = new DTO.DTO_KeDat(rs.getString("MaKe").trim(), rs.getString("TenKe"));
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
        DTO.DTO_KeDat ds = new DTO.DTO_KeDat();
        try {
            String sql = "select * from KeDat where MaKe='"+_ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                return rs.getString("TenKe");
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return "Error";
    }
    public static ArrayList<DTO_KeDat> getDS_KeDat()
    {
            ArrayList<DTO_KeDat> dshd = new ArrayList<DTO_KeDat>();
        try {
            String sql = "select * from KeDat";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_KeDat hd;
                hd =new DTO.DTO_KeDat(rs.getString("MaKe").trim(), rs.getString("TenKe"));
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
            String _sql="select * from KeDat where MaKe='"+_ma+"'";
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
            String _sql="select * from Sach where MaKe='"+_ma+"'";
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
     
     public static boolean addSanPham(DTO_KeDat sp)
     {
         try{
             String _sql="insert into KeDat values('"+sp.MaKe+"',N'"+sp.TenKe+"')";
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
            cn.executeUpdate("delete from KeDat where MaKe='"+sp+"'");             
             cn.close();
             return true;
         }
         catch(Exception ex)
         {
             return false;
         }
     }
     
     public static boolean updateSanPham(DTO_KeDat sp)
     {
         try{
             String _sql="update KeDat set TenKe=N'"+sp.TenKe+"' where MaKe=N'"+sp.MaKe+"'";
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
