/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DAO_Sach.getTenNXB;
import static DAO.DAO_Sach.getTenTheLoaiSach;
import DTO.DTO_NXB;
import DTO.DTO_Sach;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class DAO_NXB {
    
    public static ArrayList<DTO_NXB> listNXB()
    {
        ArrayList<DTO_NXB> ds = new ArrayList<DTO_NXB>();
        try {
            String sql = "select * from NhaXuatBan";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_NXB _ds = new DTO_NXB(rs.getString("MaNXB").trim(), rs.getString("TenNXB"));
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
        DTO_NXB ds = new DTO_NXB();
        try {
            String sql = "select * from NhaXuatBan where MaNXB='"+_ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                return rs.getString("TenNXB");
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return "Error";
    }
    public static ArrayList<DTO_NXB> getDS_NXB()
    {
            ArrayList<DTO_NXB> dshd = new ArrayList<DTO_NXB>();
        try {
            String sql = "select * from NhaXuatBan";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_NXB hd;
                hd =new DTO_NXB(rs.getString("MaNXB").trim(), rs.getString("TenNXB"));
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
            String _sql="select * from NhaXuatBan where MaNXB='"+_ma+"'";
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
            String _sql="select * from Sach where MaNXB='"+_ma+"'";
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
     
     public static boolean addSanPham(DTO_NXB sp)
     {
         try{
             String _sql="insert into NhaXuatBan values('"+sp.MaNXB+"',N'"+sp.TenNXB+"')";
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
            cn.executeUpdate("delete from NhaXuatBan where MaNXB='"+sp+"'");             
             cn.close();
             return true;
         }
         catch(Exception ex)
         {
             return false;
         }
     }
     
     public static boolean updateSanPham(DTO_NXB sp)
     {
         try{
             String _sql="update NhaXuatBan set TenNXB=N'"+sp.TenNXB+"' where MaNXB=N'"+sp.MaNXB+"'";
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
