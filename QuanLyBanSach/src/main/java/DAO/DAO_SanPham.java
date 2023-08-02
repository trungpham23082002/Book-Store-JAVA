/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import static DAO.DAO_Sach.getTenNXB;
import static DAO.DAO_Sach.getTenTheLoaiSach;
import DTO.DTO_Sach;
import DTO.DTO_SanPham;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author pc
 */
public class DAO_SanPham {
    public static ArrayList<DTO_SanPham> getDS_Sach()
    {
            ArrayList<DTO_SanPham> dshd = new ArrayList<DTO_SanPham>();
        try {
            String sql = "select * from Sach";
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
    
    public static DTO_SanPham getSachfromMa(String ma)
    {
            DTO_SanPham sach = new DTO_SanPham();
        try {
            String sql = "select * from Sach where MaSach='"+ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                sach = new DTO_SanPham(rs.getString("MaSach"),rs.getString("TenSach"),rs.getString("TacGia"),rs.getString("MaTheLoai"),rs.getString("MaNXB"),rs.getString("MaTang"),rs.getString("MaKe"),rs.getString("HinhAnh"),rs.getInt("SoTrang"),rs.getInt("GiaBan"),rs.getInt("SoLuongTon"));
         
            }
            cn.close();
            return sach;
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
             return sach;
        }
    }
    
    public static DTO_SanPham getSach_from_TenSach(String _tensach){
        DTO_SanPham sach = new DTO_SanPham();
        try {
            String sql = "select * from Sach where TenSach like N'%"+_tensach+"%'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                sach = new DTO_SanPham(rs.getString("MaSach"),rs.getString("TenSach"),rs.getString("TacGia"),rs.getString("MaTheLoai"),rs.getString("MaNXB"),rs.getString("MaTang"),rs.getString("MaKe"),rs.getString("HinhAnh"),rs.getInt("SoTrang"),rs.getInt("GiaBan"),rs.getInt("SoLuongTon"));
            }
            cn.close();
            return sach;
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            return sach;
        }
        
    }
    
    public static String getTenNXB(String _manxb)
    {
        try {
            String sql = "select * from NhaXuatBan where MaNXB='" + _manxb + "'";
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
    
    public static String getTenTheLoaiSach(String _matl)
    {
        try {
            String sql = "select * from TheLoaiSach where MaTheLoai='" + _matl + "'";
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
    
    public static String getTenTang(String _ma)
    {
        try {
            String sql = "select * from Tang where MaTang='" + _ma + "'";
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
        return "";
    }
    
     public static String getTenKe(String _ma)
    {
        try {
            String sql = "select * from KeDat where MaKe='" + _ma + "'";
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
        return "";
    }
     
    public static String getMaTang(String _ten)
    {
        try {
            String sql = "select * from Tang where TenTang=N'" + _ten + "'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                return rs.getString("MaTang").trim();
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            
        }
        return "";
    }
    
    public static String getMaKe(String _ten)
    {
        try {
            String sql = "select * from KeDat where TenKe=N'" + _ten + "'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                return rs.getString("MaKe").trim();
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            
        }
        return "";
    }
    
    public static String getMaTheLoai(String _ten)
    {
        try {
            String sql = "select * from TheLoaiSach where TenTheLoai=N'" + _ten + "'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                return rs.getString("MaTheLoai").trim();
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            
        }
        return "";
    }
    
    public static String getMaNXB(String _ten)
    {
        try {
            String sql = "select * from NhaXuatBan where TenNXB=N'" + _ten + "'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                return rs.getString("MaNXB").trim();
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            
        }
        return "";
    }
     public static boolean checkExistPrimarykey(String _ma)
    {
        try{
            String _sql="select * from Sach where MaSach='"+_ma+"'";
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
            String _sql="select * from HoaDonBan where MaSach='"+_ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                return true;
            }
            
            _sql="select * from HoaDonKho where MaSach='"+_ma+"'";
            cn = new DBConnection();
            cn.getCn();
            rs = cn.executeQuery(_sql);
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
     
     public static boolean addSanPham(DTO_SanPham sp)
     {
         try{
             String _sql="insert into Sach values('"+sp.MaSach+"',N'"+sp.TenSach+"',N'"+sp.TacGia+"',"+String.valueOf(sp.SoTrang)+","+String.valueOf(sp.GiaBan)+","+String.valueOf(sp.SoLuongTon)+",'"+sp.MaTheLoai+"','"+sp.MaNXB+"','"+sp.MaTang+"','"+sp.MaKe+"',N'"+sp.HinhAnh+"')";
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
            cn.executeUpdate("delete from Sach where MaSach='"+sp+"'");             
             cn.close();
             return true;
         }
         catch(Exception ex)
         {
             return false;
         }
     }
     
     public static boolean updateSanPham(DTO_SanPham sp)
     {
         try{
             String _sql="update Sach set TenSach=N'"+sp.TenSach+"',TacGia=N'"+sp.TacGia+"',SoTrang="+String.valueOf(sp.SoTrang)+",GiaBan="+String.valueOf(sp.GiaBan)+",SoLuongTon="+String.valueOf(sp.SoLuongTon)+",MaTheLoai='"+sp.MaTheLoai+"',MaNXB='"+sp.MaNXB+"',MaTang='"+sp.MaTang+"',MaKe='"+sp.MaKe+"',HinhAnh=N'"+sp.HinhAnh+"' where MaSach='"+sp.MaSach+"'";
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
