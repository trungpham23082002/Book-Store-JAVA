/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_TaiKhoan;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class DAO_TaiKhoan {
    public static ArrayList<DTO_TaiKhoan> getDS_TaiKhoan()
    {
            ArrayList<DTO_TaiKhoan> dshd = new ArrayList<DTO_TaiKhoan>();
        try {
            String sql = "select * from TaiKhoan";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_TaiKhoan hd;
                hd =new DTO.DTO_TaiKhoan(rs.getString("MaTaiKhoan").trim(), rs.getString("TenDangNhap").trim(), rs.getString("MatKhau").trim(), rs.getString("HoTen").trim(), rs.getString("SDT").trim(), 
                        rs.getString("MaQuyen").trim(),   rs.getBoolean("BiKhoa"));
                dshd.add(hd);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            
        }
        return dshd;
    }
    public static int getSoLuongNhanVien()
    {
        int dem =0;
        try{
                String _sql="select * from TaiKhoan";
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
public static boolean addTaiKhoan(DTO_TaiKhoan sp)
     {
         try{
             int flag = (!sp.BiKhoa)?0:1;
             String _sql="insert into TaiKhoan values('"+sp.MaTaiKhoan+"',N'"+sp.TenDangNhap+"','"+sp.MatKhau+"',N'"+sp.HoTen+"','"+sp.SDT+"','"+sp.MaQuyen+"',"+flag+")";
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
     
     public static boolean updateTaiKhoan(DTO_TaiKhoan sp)
     {
         try{
             int flag = (!sp.BiKhoa)?0:1;
             String _sql="update TaiKhoan set TenDangNhap=N'"+sp.TenDangNhap+"',MatKhau='"+sp.MatKhau+"',HoTen=N'"+sp.HoTen+"',SDT='"+sp.SDT+"',MaQuyen='"+sp.MaQuyen+"',BiKhoa="+flag+" where MaTaiKhoan='"+sp.MaTaiKhoan+"'";
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
     
  public static boolean updateTrangThai(String id, boolean _flag)
     {
         try{
             int flag = (!_flag)?1:0;
             String _sql="update TaiKhoan set BiKhoa="+flag+" where MaTaiKhoan='"+id+"'";
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
     
     
      public static boolean isExistTK(String ma)
    {
        try {
            String sql = "select * from TaiKhoan where MaTaiKhoan='"+ma+"'";
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
      
        public static String getTenDNfromMaTK(String ma)
    {
        try {
            String sql = "select * from TaiKhoan where MaTaiKhoan='"+ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                return rs.getString("TenDangNhap");
            }
            cn.close();
            return "";
        } catch (Exception e) {
           return "";
        }
    }
        
            public static String getMaQuyenfromMaTK(String ma)
    {
        try {
            String sql = "select * from TaiKhoan where MaTaiKhoan='"+ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                return rs.getString("MaQuyen");
            }
            cn.close();
            return "";
        } catch (Exception e) {
           return "";
        }
    }
      
        public static boolean isExistTenDN(String ma)
    {
        try {
            String sql = "select * from TaiKhoan where TenDangNhap='"+ma+"'";
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
    public static DTO_TaiKhoan getTaiKhoan_from_MaTKDN(String ma)
    {
        DTO_TaiKhoan tv= new DTO_TaiKhoan();
        try{
            String _sql="select * from TaiKhoan where MaTaiKhoan ='"+ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
               tv =new DTO.DTO_TaiKhoan(rs.getString("MaTaiKhoan").trim(), rs.getString("TenDangNhap").trim(), rs.getString("MatKhau").trim(), rs.getString("HoTen").trim(), rs.getString("SDT").trim(), 
                        rs.getString("MaQuyen").trim(),   rs.getBoolean("BiKhoa"));
            }
            return tv;
        }
        catch(Exception ex)
        {
            return tv;
        }
    }
  
}
