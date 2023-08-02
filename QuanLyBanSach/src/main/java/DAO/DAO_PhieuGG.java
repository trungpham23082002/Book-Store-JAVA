/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.DTO_PhieuGG;
import DTO.DTO_SanPham;
import DTO.DTO_ThanhVien;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author pc
 */
public class DAO_PhieuGG {
    public static boolean checkValidVouchers(String _mavc)
    {
        try{
            String _sql="select * from PhieuGiamGia where MaGiamGia='"+_mavc+"'";
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
    public static ArrayList<DTO_PhieuGG> getDS_PhieuGiamGia()
    {
            ArrayList<DTO_PhieuGG> dshd = new ArrayList<DTO_PhieuGG>();
        try {
            String sql = "select * from PhieuGiamGia";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_PhieuGG hd;
                hd = new DTO_PhieuGG(rs.getString("MaGiamGia"), rs.getString("TenGiamGia"), rs.getInt("PhanTramGiamGia"), rs.getString("NgayBD"), rs.getString("NgayKT")); 
                dshd.add(hd);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            
        }
        return dshd;
    }
    public static DTO_PhieuGG getPhieuGG_from_MaGG(String _mavc)
    {
        DTO_PhieuGG gg= new DTO_PhieuGG();
        try{
            String _sql="select * from PhieuGiamGia where MaGiamGia='"+_mavc+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                gg = new DTO_PhieuGG(rs.getString("MaGiamGia"), rs.getString("TenGiamGia"), rs.getInt("PhanTramGiamGia"), rs.getString("NgayBD"), rs.getString("NgayKT"));               
            }
            return gg;
        }
        catch(Exception ex)
        {
            return gg;
        }
    }
    public static int getMoneyOffer_from_MaGG(String _ma)
    {
        try{
            if(checkValidVouchers(_ma))
            {
                DTO_PhieuGG tv= getPhieuGG_from_MaGG(_ma);
                return tv.PhanTramGiamGia;
            }
        }
        catch(Exception ex)
        {
            return 0;
        }
        return 0;
    }
    public static boolean checkExistPrimarykey(String _ma)
    {
        try{
            String _sql="select * from PhieuGiamGia where MaGiamGia='"+_ma+"'";
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
            String _sql="select * from HoaDonBan where MaGiamGia='"+_ma+"'";
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
     
     public static boolean addSanPham(DTO_PhieuGG sp)
     {
         try{
             String _sql="insert into PhieuGiamGia values('"+sp.MaGiamGia+"',N'"+sp.TenGiamGia+"',"+String.valueOf(sp.PhanTramGiamGia)+",'"+sp.NgayBD+"','"+sp.NgayKT+"')";
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
            cn.executeUpdate("delete from PhieuGiamGia where MaGiamGia='"+sp+"'");             
             cn.close();
             return true;
         }
         catch(Exception ex)
         {
             return false;
         }
     }
     
     public static boolean updateSanPham(DTO_PhieuGG sp)
     {
         try{
             String _sql="update PhieuGiamGia set TenGiamGia=N'"+sp.TenGiamGia+"',PhanTramGiamGia="+String.valueOf(sp.PhanTramGiamGia)+",NgayBD='"+sp.NgayBD+"',NgayKT='"+sp.NgayKT+"' where MaGiamGia='"+sp.MaGiamGia+"'";
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
     
    public static boolean isDuringSale(String mgg)
    {
        try{
            LocalDate currentdate = LocalDate.now();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateBD = new Date();
            Date dateKT = new Date();
            Date dateNow = dateBD = sdf.parse(currentdate.getYear()+"-"+currentdate.getMonthValue()+"-"+currentdate.getDayOfMonth());
            String _sql="select * from PhieuGiamGia where MaGiamGia='"+mgg+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                dateBD = sdf.parse(rs.getString("NgayBD"));
                dateKT = sdf.parse(rs.getString("NgayKT"));
            }
            cn.close();
            if(dateBD.compareTo(dateNow)<0 && dateNow.compareTo(dateKT)<0)
                return true;
            return false;
        }
        catch(Exception ex)
        {
        }
        return false;
    }
}
