/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.DTO_ChiTietHoaDon;
import DTO.DTO_ChiTietHoaDonBan;
import DTO.DTO_Sach;
import DTO.DTO_HoaDonBan;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author ChauCuteVCL
 */
public class DAO_Sach {
    public static DTO_Sach getSach_from_MaSach(String _masach){
        DTO_Sach ds = new DTO_Sach();
        try {
            String sql = "select * from Sach where MaSach='"+_masach+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                ds = new DTO_Sach(rs.getString("MaSach").trim(), rs.getString("TenSach").trim(), rs.getString("TacGia").trim(),
                        getTenNXB(rs.getString("MaNXB").trim()),getTenTheLoaiSach(rs.getString("MaTheLoai").trim()),rs.getInt("GiaBan"),rs.getString("HinhAnh").trim(),rs.getInt("SoLuongTon"));
                return ds;
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return ds;
    }
    
    public static DTO_Sach getSach_from_TenSach(String _tensach){
        DTO_Sach ds = new DTO_Sach();
        try {
            String sql = "select * from Sach where TenSach like N'%"+_tensach+"%'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                ds = new DTO_Sach(rs.getString("MaSach").trim(), rs.getString("TenSach").trim(), rs.getString("TacGia").trim(),
                        getTenNXB(rs.getString("MaNXB").trim()),getTenTheLoaiSach(rs.getString("MaTheLoai").trim()),rs.getInt("GiaBan"),rs.getString("HinhAnh").trim(),rs.getInt("SoLuongTon"));
                return ds;
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return ds;
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
    public static String getHinhAnh_from_MaSach(String _ma)
    {
        try {
            String sql = "select * from Sach where MaSach='" + _ma + "'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                return rs.getString("HinhAnh");
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            
        }
        return "Error";
    }
    public static String getTenSach_from_MaSach(String _ma)
    {
        try {
            String sql = "select * from Sach where MaSach='" + _ma + "'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                return rs.getString("TenSach");
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            
        }
        return "Error";
    }
    public static int ThemXoaSuaSach(String sql){
        int i=0;
        try {
            DBConnection cn = new DBConnection();
            cn.getCn();
             i = cn.executeUpdate(sql);
            cn.close();
            System.out.println("Thêm/xóa/sửa thành công");
            
        } catch (Exception e) {
            System.out.println("Thêm/xóa/sửa không thành công");
           
        }
        return i;
    }

    public static ArrayList<DTO_Sach> getDS_Sach_SLT(int slt)
    {
            ArrayList<DTO_Sach> dshd = new ArrayList<DTO_Sach>();
        try {
            String sql = "select * from Sach where SoLuongTon <= "+slt+"";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO_Sach hd = new DTO_Sach(rs.getString("MaSach").trim(), rs.getString("TenSach").trim(),
                        rs.getString("TacGia").trim(),
                        (rs.getString("MaNXB").trim()),
                        (rs.getString("MaTheLoai").trim()),rs.getInt("GiaBan"),
                        rs.getString("HinhAnh").trim(),rs.getInt("SoLuongTon"));
                dshd.add(hd);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
            
        }
        return dshd;
    }
    
    public static boolean checkSLTonDu(String ma, int sl)
    {
        try {
            String sql = "select * from Sach where MaSach='"+ma+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                if(rs.getInt("SoLuongTon")>=sl)
                    return true;
            }
            cn.close();
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean addHoaDonBan(DTO_HoaDonBan x)
    {
        try{
            SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
            String sql = "insert into HoaDonBan values('"+x.ngayLap+"',"+x.tongTien+","+x.tongGiam+","+x.thanhTien+","+x.maTV+",'"+x.maGG+"','"+x.nguoiLap+"')";
            DBConnection cn = new DBConnection();
            cn.getCn();
            cn.executeUpdate(sql);
            cn.close();
            return true;
        }
        catch(Exception ex){return false;}
    }
    
    public static void addChiTietHDB(DTO_ChiTietHoaDon x, int sohd)
    {
        try{
            String sql = "insert into ChiTietHoaDonBan values("+sohd+",'"+x.masach+"',"+x.soluong+","+x.tongtien+")";
            DBConnection cn = new DBConnection();
            cn.getCn();
            cn.executeUpdate(sql);
            cn.close();
        }
        catch(Exception ex){}
    }
    
    public static void updateSoLuongTon(DTO_ChiTietHoaDon x)
    {
        try{
            String sql = "update Sach set SoLuongTon = SoLuongTon - "+x.soluong+" where MaSach = '"+x.masach+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            cn.executeUpdate(sql);
            cn.close();
        }
        catch(Exception ex){}
    }
    
    
    
    public static int getTongSachTonKho()
    {
        int i=0;
        try{
            String _sql="select * from Sach";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(_sql);
            while(rs.next()){
                i+= rs.getInt("SoLuongTon");
            }
            cn.close();
            return i;
        }
        catch(Exception ex)
        {
            return i;
        }
    }
}
