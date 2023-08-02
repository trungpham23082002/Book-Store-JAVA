/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_HoaDonBan;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ChauCuteVCL
 */
public class DAO_HoaDonBan {
   
    public static ArrayList<DTO_HoaDonBan> getDS_HDB()
    {
        ArrayList<DTO_HoaDonBan> dshd = new ArrayList<DTO_HoaDonBan>();
        try {
            String sql = "select * from HoaDonBan";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_HoaDonBan hd = new DTO_HoaDonBan(rs.getString("SoHD"),rs.getString("NgayLap"),rs.getInt("TongTien"),rs.getInt("TongGiam"),rs.getInt("ThanhTien"),rs.getString("MaTV"),rs.getString("MaGiamGia"),rs.getString("MaTaiKhoan"));
                dshd.add(hd);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            
        }
        return dshd;
    }
    
//    public static ArrayList<DTO_HoaDonBan> getDS_HDB_fromSDT_TV(String _sdt)
//    {
//        ArrayList<DTO_HoaDonBan> dshd = new ArrayList<DTO_HoaDonBan>();
//        try {
//            String _ma = DAO_ThanhVien.getMaTV_from_SDT(_sdt);
//            String sql = "select * from HoaDonBan where MaTV='"+_ma+"'";
//            DBConnection cn = new DBConnection();
//            cn.getCn();
//            ResultSet rs = cn.executeQuery(sql);
//            while(rs.next()){
//                DTO_HoaDonBan hd = new DTO_HoaDonBan(rs.getString("SoHD"),rs.getString("MaSach"),rs.getString("MaTV"),rs.getString("MaGiamGia"),rs.getDate("NgayLap").toString(),rs.getString("MaTaiKhoan"),rs.getInt("SoLuong"),rs.getInt("TongTien"),rs.getInt("TongGiam"),rs.getInt("ThanhTien"));
//                dshd.add(hd);
//            }
//            cn.close();
//        } catch (Exception e) {
//            System.out.println("Lỗi không thể lấy dữ liệu");
//            
//        }
//        return dshd;
//    }

    public DAO_HoaDonBan() {
    }
    
//    public static boolean addHoaDonBan(DTO_HoaDonBan x)
//    {
//        try {            
//            String sql = "set dateformat dmy insert into HoaDonBan values('"+x.ngayLap+"',"+x.soLuong+","+x.tongTien+","+x.tongGiam+","+x.thanhTien+",'"+x.maSach+"',"+x.maTV+","
//                    + "'"+x.maGG+"','"+x.nguoiLap+"')";
//            DBConnection cn = new DBConnection();
//            cn.getCn();
//            cn.executeUpdate(sql);
//            cn.close();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
    
    public static boolean checkExist_SoHD(String _shd)
    {
        try{
            String _sql="select * from HoaDonBan where SoHD='"+_shd+"'";
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
    
    public static boolean checkExist_NgayLap(String nl)
    {
        try{
            String _sql="select * from HoaDonBan where NgayLap='"+nl+"'";
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
    
    public static boolean checkExist_SDT_TV(String _sdt)
    {
        try{
            String _ma = DAO_ThanhVien.getMaTV_from_SDT(_sdt);
            String sql = "select * from HoaDonBan where MaTV='"+_ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
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
    
    public static boolean checkExist_MaSach(String ms)
    {
        try{
            String _sql="select * from HoaDonBan where MaSach='"+ms+"'";
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
    
    public static int getHoaDonBanMoiNhat()
    {
        int i=0;
        try{
            String _sql="select * from HoaDonBan";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                i = rs.getInt("SoHD");
            }
            cn.close();
            return i;
        }
        catch(Exception ex)
        {
            return i;
        }
    }
    
    public static int getTongSachBan_from_HoaDonBan()
    {
        int i=0;
        try{
            String _sql="select * from ChiTietHoaDonBan";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                i+= rs.getInt("SoLuong");
            }
            cn.close();
            return i;
        }
        catch(Exception ex)
        {
            return i;
        }
    }
    
    public static int getTongSachBanTrongThang_from_HoaDonBan()
    {
        int i=0;
        try{            
            DBConnection cn = new DBConnection();
            cn.getCn();
            ArrayList<String> lst = getListHDBTrongThang();
            for(String x : lst)
            {
                String _sql="select * from ChiTietHoaDonBan where SoHD="+x;
                ResultSet rs = cn.executeQuery(_sql);
                while(rs.next()){
                    i+= rs.getInt("SoLuong");
                }
            }       
            
            cn.close();
            return i;
        }
        catch(Exception ex)
        {
            return i;
        }
    }
    
    public static int getTongTienBanSach()
    {
        int i=0;
        try{
            String _sql="select * from HoaDonBan";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                i+= rs.getInt("ThanhTien");
            }
            cn.close();
            return i;
        }
        catch(Exception ex)
        {
            return i;
        }
    }
    
    public static int getTongTienBanSachTrongThang()
    {
        int i=0;
        try{
            LocalDate currentdate = LocalDate.now();
            String dateBD= currentdate.getMonthValue()+"/1/"+currentdate.getYear();
            String dateKT= currentdate.getMonthValue()+"/31/"+currentdate.getYear();
            String _sql="select * from HoaDonBan where NgayLap > '"+dateBD+"' and NgayLap < '"+dateKT+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                i+= rs.getInt("ThanhTien");
            }
            cn.close();
            return i;
        }
        catch(Exception ex)
        {
            return i;
        }
    }
    
    public static ArrayList<String> getListHDBTrongThang()
    {
        LocalDate currentdate = LocalDate.now();
        String dateBD= currentdate.getMonthValue()+"/1/"+currentdate.getYear();
        String dateKT= currentdate.getMonthValue()+"/31/"+currentdate.getYear();
        ArrayList<String> lst = new ArrayList<String>();
        DTO_HoaDonBan hd = new DTO_HoaDonBan();
        try {
            String sql = "select * from HoaDonBan where NgayLap > '"+dateBD+"' and NgayLap < '"+dateKT+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                lst.add(rs.getString("SoHD"));
            }
             cn.close();
            return lst;
           
        } catch (Exception e) {
            return lst;
        }     
    }
    
    public static DTO_HoaDonBan getDS_fromSoHD(String shd)
    {
        DTO_HoaDonBan hd = new DTO_HoaDonBan();
        try {
            String sql = "select * from HoaDonBan where SoHD='"+shd+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                hd = new DTO_HoaDonBan(rs.getString("SoHD"),rs.getString("NgayLap"),rs.getInt("TongTien"),rs.getInt("TongGiam"),rs.getInt("ThanhTien"),rs.getString("MaTV"),rs.getString("MaGiamGia"),rs.getString("MaTaiKhoan"));
            }
             cn.close();
            return hd;
           
        } catch (Exception e) {
            return hd;
        }        
    }
    
    public static ArrayList<DTO_HoaDonBan> getDS_fromNgayLap(String nl)
    {
        ArrayList<DTO_HoaDonBan> hd = new ArrayList<DTO_HoaDonBan>();
        try {
            String sql = "select * from HoaDonBan where NgayLap='"+nl+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
              hd.add(new DTO_HoaDonBan(rs.getString("SoHD"),rs.getString("NgayLap"),rs.getInt("TongTien"),rs.getInt("TongGiam"),rs.getInt("ThanhTien"),rs.getString("MaTV"),rs.getString("MaGiamGia"),rs.getString("MaTaiKhoan")));

            }
             cn.close();
            return hd;
           
        } catch (Exception e) {
            return hd;
        }        
    }
    
    public static ArrayList<DTO_HoaDonBan> getDS_fromSDT(String sdt)
    {
        ArrayList<DTO_HoaDonBan> hd = new ArrayList<DTO_HoaDonBan>();
        try {
            String sql = "select * from HoaDonBan where MaTV="+DAO_ThanhVien.getMaTV_from_SDT(sdt);
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
              hd.add(new DTO_HoaDonBan(rs.getString("SoHD"),rs.getString("NgayLap"),rs.getInt("TongTien"),rs.getInt("TongGiam"),rs.getInt("ThanhTien"),rs.getString("MaTV"),rs.getString("MaGiamGia"),rs.getString("MaTaiKhoan")));

            }
             cn.close();
            return hd;
           
        } catch (Exception e) {
            return hd;
        }        
    }
   
}
