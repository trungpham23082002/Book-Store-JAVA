/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_ChiTietHoaDon;
import DTO.DTO_HoaDonBan;
import DTO.DTO_HoaDonNhap;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class DAO_HoaDonKho {

    public DAO_HoaDonKho() {
    }
    public static int getTienNhapKho()
    {
        int i=0;
        try{
            String _sql="select * from HoaDonKho where MaLoaiHD='HDNhapKho'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                i+= rs.getInt("TongTien");
            }
            cn.close();
            return i;
        }
        catch(Exception ex)
        {
            return i;
        }
    }
    
    public static int getTienXuatKho()
    {
        int i=0;
        try{
            String _sql="select * from HoaDonKho where MaLoaiHD='HDXuatKho'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                i+= rs.getInt("TongTien");
            }
            cn.close();
            return i;
        }
        catch(Exception ex)
        {
            return i;
        }
    }
    
    public static int getTienNhapKhoTrongThang()
    {
        int i=0;
        try{
            LocalDate currentdate = LocalDate.now();
            String dateBD= currentdate.getMonthValue()+"/1/"+currentdate.getYear();
            String dateKT= currentdate.getMonthValue()+"/31/"+currentdate.getYear();
            String _sql="select * from HoaDonKho where MaLoaiHD='HDNhapKho' and NgayLap > '"+dateBD+"' and NgayLap < '"+dateKT+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                i+= rs.getInt("TongTien");
            }
            cn.close();
            return i;
        }
        catch(Exception ex)
        {
            return i;
        }
    }
    
    public static int getTienXuatKhoTrongThang()
    {
        int i=0;
        try{
            
            LocalDate currentdate = LocalDate.now();
            String dateBD= currentdate.getMonthValue()+"/1/"+currentdate.getYear();
            String dateKT= currentdate.getMonthValue()+"/31/"+currentdate.getYear();
            String _sql="select * from HoaDonKho where MaLoaiHD='HDXuatKho' and NgayLap > '"+dateBD+"' and NgayLap < '"+dateKT+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                i+= rs.getInt("TongTien");
            }
            cn.close();
            return i;
        }
        catch(Exception ex)
        {
            return i;
        }
    }
    public static ArrayList<DTO_HoaDonNhap> getDS_from_MaLoaiHD(String _ma)
    {
        ArrayList<DTO_HoaDonNhap> gg= new ArrayList<DTO_HoaDonNhap>();
        try{
            String _sql="select * from HoaDonKho where MaLoaiHD='"+_ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                gg.add(new DTO_HoaDonNhap(rs.getString("SoHDK"), rs.getInt("SoLuong"), rs.getInt("TongTien"), rs.getString("NgayLap"), rs.getString("GhiChu"),rs.getString("MaSach"),rs.getString("MaTaiKhoan"),rs.getString("MaLoaiHD")));               
            }
            return gg;
        }
        catch(Exception ex)
        {
            return gg;
        }
    }
    
    public static ArrayList<DTO_HoaDonNhap> getDS_HDKho()
    {
        ArrayList<DTO_HoaDonNhap> dshd = new ArrayList<DTO_HoaDonNhap>();
        try {
            String sql = "select * from HoaDonKho";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_HoaDonNhap hd = new DTO_HoaDonNhap(rs.getString("SoHDK"),rs.getInt("SoLuong"),rs.getInt("TongTien"),rs.getString("NgayLap"),rs.getString("GhiChu"),rs.getString("MaSach"),rs.getString("MaTaiKhoan"),rs.getString("MaLoaiHD"));
                dshd.add(hd);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            
        }
        return dshd;
    }
    
    public static boolean addHoaDonKho(DTO_HoaDonNhap x)
    {
        try{
            String sql = "insert into HoaDonKho (SoLuong,TongTien,NgayLap,GhiChu,MaSach,MaTaiKhoan,MaLoaiHD) values("+x.soluong+","+x.tongtien+",'"+x.ngaylap+"','"+x.ghichu+"','"+x.masach+"','"+x.mataikhoan+"','"+x.maloaihd+"')";
            DBConnection cn = new DBConnection();
            cn.getCn();
            cn.executeUpdate(sql);
            cn.close();
            return true;
        }
        catch(Exception ex){return false;}
    }
    
    public static void updateSoLuongTon(String ma, int sl)
    {
        try{
            String sql = "update Sach set SoLuongTon = SoLuongTon + "+sl+" where MaSach = '"+ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            cn.executeUpdate(sql);
            cn.close();
        }
        catch(Exception ex){}
    }
    
    public static void updateSoLuongTon_XuatKho(String ma, int sl)
    {
        try{
            String sql = "update Sach set SoLuongTon = SoLuongTon - "+sl+" where MaSach = '"+ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            cn.executeUpdate(sql);
            cn.close();
        }
        catch(Exception ex){}
    }
}
