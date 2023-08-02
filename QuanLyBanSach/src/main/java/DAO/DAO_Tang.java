/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.DTO_Tang;
/**
 *
 * @author pc
 */
public class DAO_Tang {
    public static ArrayList<DTO.DTO_Tang> listTang()
    {
        ArrayList<DTO.DTO_Tang> ds = new ArrayList<DTO.DTO_Tang>();
        try {
            String sql = "select * from Tang";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO.DTO_Tang _ds = new DTO.DTO_Tang(rs.getString("MaTang").trim(), rs.getString("TenTang"));
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
        DTO.DTO_Tang ds = new DTO.DTO_Tang();
        try {
            String sql = "select * from Tang where MaTang='"+_ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                return rs.getString("TenTang");
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return "Error";
    }
    public static ArrayList<DTO_Tang> getDS_Tang()
    {
            ArrayList<DTO_Tang> dshd = new ArrayList<DTO_Tang>();
        try {
            String sql = "select * from Tang";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_Tang hd;
                hd =new DTO.DTO_Tang(rs.getString("MaTang").trim(), rs.getString("TenTang"));
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
            String _sql="select * from Tang where MaTang='"+_ma+"'";
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
            String _sql="select * from Sach where MaTang='"+_ma+"'";
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
     
     public static boolean addSanPham(DTO_Tang sp)
     {
         try{
             String _sql="insert into Tang values('"+sp.MaTang+"',N'"+sp.TenTang+"')";
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
            cn.executeUpdate("delete from Tang where MaTang='"+sp+"'");             
             cn.close();
             return true;
         }
         catch(Exception ex)
         {
             return false;
         }
     }
     
     public static boolean updateSanPham(DTO_Tang sp)
     {
         try{
             String _sql="update Tang set TenTang=N'"+sp.TenTang+"' where MaTang=N'"+sp.MaTang+"'";
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



