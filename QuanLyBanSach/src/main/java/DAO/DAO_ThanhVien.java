/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_SanPham;
import DTO.DTO_ThanhVien;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class DAO_ThanhVien {
    public static boolean checkMembers_SDT(String _sdt)
    {
        try{
            String _sql="select * from ThanhVien where SDT='"+_sdt+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                return true;
            }
            cn.close();
            return false;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    
    public static boolean checkMembers_MaTV(String _ma)
    {
        try{
            String _sql="select * from ThanhVien where MaTV='"+_ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                return true;
            }
            cn.close();
            return false;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    
    public static boolean checkValidMembers(String _sdt)
    {
        try{
            String _sql="select * from ThanhVien where SDT='"+_sdt+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                return true;
            }
        }
        catch(Exception ex)
        {
            return false;
        }
        return false;
    }
     
    public static ArrayList<DTO_ThanhVien> getDS_ThanhVien()
    {
            ArrayList<DTO_ThanhVien> dshd = new ArrayList<DTO_ThanhVien>();
        try {
            String sql = "select * from ThanhVien";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_ThanhVien hd;
                hd = new DTO_ThanhVien(rs.getString("MaTV"),rs.getString("TenThanhVien"),rs.getString("SDT"),rs.getInt("TienDamua"),rs.getString("MaLoaiTV"));
                dshd.add(hd);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu"); 
        }
        return dshd;
    }
    public static DTO_ThanhVien getThanhVien_from_SDT(String _sdt)
    {
        DTO_ThanhVien tv= new DTO_ThanhVien();
        try{
            String _sql="select * from ThanhVien where SDT ='"+_sdt+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                tv = new DTO_ThanhVien(rs.getString("MaTV"), rs.getString("TenThanhVien"), rs.getString("SDT"), rs.getInt("TienDaMua"), rs.getString("MaLoaiTV"));               
            }
            return tv;
        }
        catch(Exception ex)
        {
            return tv;
        }
    }
    
    
    public static String getMaTV_from_SDT(String _sdt)
    {
        try{
            String _sql="select * from ThanhVien where SDT ='"+_sdt+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                return rs.getString("MaTV").trim();
            }
            cn.close();
            return "";
        }
        catch(Exception ex)
        {
            return "";
        }
    }
    public static String getSDT_from_MaTV(String ma)
    {
        try{
            String _sql="select * from ThanhVien where MaTV ='"+ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                return rs.getString("SDT").trim();
            }
            cn.close();
            return "";
        }
        catch(Exception ex)
        {
            return "";
        }
    }
    
    public static DTO_ThanhVien getThanhVien_from_MaTV(String _matv)
    {
        DTO_ThanhVien tv= new DTO_ThanhVien();
        try{
            String _sql="select * from ThanhVien where MaTV ='"+_matv+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                tv = new DTO_ThanhVien(rs.getString("MaTV"), rs.getString("TenThanhVien"), rs.getString("SDT"), rs.getInt("TienDaMua"), rs.getString("MaLoaiTV"));               
            }
            return tv;
        }
        catch(Exception ex)
        {
            return tv;
        }
    }
    public static boolean isTV_FKofAnotherTable(String ma)
    {
        try {
            String sql = "select * from HoaDonBan where MaTV='"+ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                return true;
            }
            cn.close();
            return false;
        } catch (Exception e) {
           return false;
        }
    }
    public static int getMoneyOffer_from_SDT(String _sdt)
    {
        try{
            if(checkValidMembers(_sdt))
            {
                DTO_ThanhVien tv= getThanhVien_from_SDT(_sdt);
                String _sql="select * from LoaiThanhVien where MaLoaiTV='"+tv.MaLoaiTV+"'";
                DBConnection cn = new DBConnection();
                cn.getCn();
                ResultSet rs = cn.executeQuery(_sql);
                while(rs.next()){
                    return rs.getInt("PhanTramGiamGia");
                }
            }
        }
        catch(Exception ex)
        {
            return 0;
        }
        return 0;
    }
    public static boolean addTV(DTO_ThanhVien tv)
     {
         try{
             String _sql="insert into ThanhVien values(N'"+tv.TenThanhVien+"','"+tv.SDT+"',0,'Bronze')";
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
     
     public static boolean delTV(String ma)
     {
         try{
            DBConnection cn = new DBConnection();
            cn.getCn();
            cn.executeUpdate("delete from ThanhVien where MaTV='"+ma+"'");             
             cn.close();
             return true;
         }
         catch(Exception ex)
         {
             return false;
         }
     }
     
     public static boolean updateTV(DTO_ThanhVien tv)
     {
         try{
             String _sql="update ThanhVien set TenThanhVien=N'"+tv.TenThanhVien+"',SDT='"+tv.SDT+"',TienDaMua="+String.valueOf(tv.TienDaMua)+" where MaTV='"+tv.MaTV+"'";
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
     
     public static boolean updateTienDaMua(int matv, int tiencong)
     {
         try{
             String _sql="update ThanhVien set TienDaMua=TienDaMua+"+tiencong+" where MaTV="+matv;
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
     
     public static int getSoLuongThanhVien()
    {
        int dem =0;
        try{
                String _sql="select * from ThanhVien";
                DBConnection cn = new DBConnection();
                cn.getCn();
                ResultSet rs = cn.executeQuery(_sql);
                while(rs.next()){
                    dem+=1;
                }
                cn.close();
                return dem;
        }
        catch(Exception ex)
        {
            return dem;
        }
    }
}
