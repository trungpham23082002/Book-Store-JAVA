/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DTO_Sach;
import DTO.DTO_ThongKeTop5;
import DTO.PersonNameComparator;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

/**
 *
 * @author pc
 */
public class DAO_ThongKe {
    public static DTO_ThongKeTop5 getTop(int top)
    {
        try {
            ArrayList<String> lstID = new ArrayList<String>();
            //Lay ds các sách bán không trùng
            String sql = "select MaSach from ChiTietHoaDonBan group by MaSach";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                lstID.add(rs.getString("MaSach").trim());
            }
            cn.close();
            //Khởi tạo 1 array các class thống kê
            ArrayList<DTO_ThongKeTop5> arraylist = new ArrayList<DTO_ThongKeTop5>();
            for(String i : lstID)
            {
                arraylist.add(new DTO_ThongKeTop5(i, getSLDaBan(i)));
            }
            //Đã có một array bao gồm mã sách + số lượng đã bán
            //Sort
            PersonNameComparator compara = new PersonNameComparator();
            Collections.sort(arraylist, compara);
            Collections.reverse(arraylist);
            return new DTO_ThongKeTop5(arraylist.get(top).masach, arraylist.get(top).soluong);
            
        } catch (Exception e) {
            return new DTO_ThongKeTop5();
            
        }
    }
    
    public static int getSLDaBan(String masach)
    {
        int dem=0;
        try {
            //Lay ds các sách bán không trùng
            String sql = "select * from ChiTietHoaDonBan where MaSach='"+masach+"'";
            DBConnection cn = new DBConnection();
            cn.getCn();
            ResultSet rs = cn.executeQuery(sql);
            while(rs.next()){
                dem+=rs.getInt("SoLuong");
            }
            
            cn.close();
            return dem;
        } catch (Exception e) {
           return dem;            
        }
    }
    
}
