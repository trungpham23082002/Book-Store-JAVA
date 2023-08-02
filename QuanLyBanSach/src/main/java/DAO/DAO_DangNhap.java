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
 * @author ChauCuteVCL
 */
public class DAO_DangNhap {
    public static ArrayList<DTO.DTO_TaiKhoan> getDSTaiKhoan(){
        ArrayList<DTO_TaiKhoan> dstk = new ArrayList<DTO_TaiKhoan>();
        try {
            String sql = "select * from TaiKhoan";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                DTO.DTO_TaiKhoan b = new DTO.DTO_TaiKhoan(rs.getString("MaTaiKhoan").trim(), rs.getString("TenDangNhap").trim(), rs.getString("MatKhau").trim(), rs.getString("HoTen").trim(), rs.getString("SDT").trim(),  rs.getString("MaQuyen").trim(),   rs.getBoolean("BiKhoa"));
                dstk.add(b);
            }
            cn.close();
        } catch (Exception e) {
            System.out.println("Lỗi không thể lấy dữ liệu");
        }
        return dstk;
    }
    
}
