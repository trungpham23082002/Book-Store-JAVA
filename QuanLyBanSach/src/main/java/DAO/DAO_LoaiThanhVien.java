/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.DTO_LoaiThanhVien;
import DTO.DTO_ThanhVien;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author pc
 */
public class DAO_LoaiThanhVien {
     public static ArrayList<DTO_LoaiThanhVien> listLTV()
    {
        ArrayList<DTO_LoaiThanhVien> ds = new ArrayList<DTO_LoaiThanhVien>();
        try {
            String sql = "select * from LoaiThanhVien";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_LoaiThanhVien _ds = new DTO_LoaiThanhVien(rs.getString("MaLoaiTV").trim(), rs.getString("TenLoaiTV"),rs.getInt("TienCanDat"),rs.getInt("PhanTramGiamGia"));
                ds.add(_ds);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return ds;
    }
      public static ArrayList<DTO_LoaiThanhVien> getDS_LoaiThanhVien()
    {
            ArrayList<DTO_LoaiThanhVien> dshd = new ArrayList<DTO_LoaiThanhVien>();
        try {
            String sql = "select * from LoaiThanhVien";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_LoaiThanhVien hd;
                hd = new DTO_LoaiThanhVien(rs.getString("MaLoaiTV"),rs.getString("TenLoaiTV"),rs.getInt("TienCanDat"),rs.getInt("PhanTramGiamGia"));
                dshd.add(hd);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu"); 
        }
        return dshd;
    }
      
    public static String getTenLTV_fromMaLTV(String ma)
    {
        try {
            String sql = "select * from LoaiThanhVien where MaLoaiTV='"+ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                return rs.getString("TenLoaiTV");
            }
            cn.close();
            return "";
        } catch (Exception e) {
           return "";
        }
    }
    
    public static boolean isExistLTV(String ma)
    {
        try {
            String sql = "select * from LoaiThanhVien where MaLoaiTV='"+ma+"'";
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
    
    public static boolean isLTV_FKofAnotherTable(String ma)
    {
        try {
            String sql = "select * from ThanhVien where MaLoaiTV='"+ma+"'";
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
    
    public static String getMaLTV_fromTenLTV(String ten)
    {
        try {
            String sql = "select * from LoaiThanhVien where TenLoaiTV='"+ten+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                return rs.getString("MaLoaiTV");
            }
            cn.close();
            return "";
        } catch (Exception e) {
           return "";
        }
    }
    
    public static boolean addLTV(DTO_LoaiThanhVien tv)
     {
         try{
             String _sql="insert into LoaiThanhVien values('"+tv.MaLoaiTV+"',N'"+tv.TenLoaiTV+"',"+String.valueOf(tv.TienCanDat)+","+String.valueOf(tv.PhanTramGiamGia)+")";
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
     
     public static boolean delLTV(String ma)
     {
         try{
            DBConnection cn = new DBConnection();
            cn.getCn();
            cn.executeUpdate("delete from LoaiThanhVien where MaLoaiTV='"+ma+"'");             
             cn.close();
             return true;
         }
         catch(Exception ex)
         {
             return false;
         }
     }
     
     public static boolean updateLTV(DTO_LoaiThanhVien tv)
     {
         try{
             String _sql="update LoaiThanhVien set TenLoaiTV=N'"+tv.TenLoaiTV+"',TienCanDat="+String.valueOf(tv.TienCanDat)+",PhanTramGiamGia="+String.valueOf(tv.PhanTramGiamGia)+" where MaLoaiTV='"+tv.MaLoaiTV+"'";
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
