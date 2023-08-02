/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author ChauCuteVCL
 */
public class DBConnection {
    public static void main(String[] args) {
        DBConnection _cnn = new DBConnection();
        Connection con = _cnn.getCn();
    }
    private Connection cn;

    public Connection getCn() {
        try {
            String url = "jdbc:sqlserver://TRUNGDEPTRAI:1433;databaseName=QLBanSach_DoAnJava";
            String user = "sa";
            String pass = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            
            cn = DriverManager.getConnection(url, user, pass);
            System.out.println("Kết nối csdl thành công");
        } catch (Exception e) {
            System.out.println("Kết nối csdl không thành công");
        }
        return cn;
    }
    
    public void close(){
        try {
            this.cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet executeQuery(String sql){
        ResultSet rs = null;
        try {
            Statement stm = cn.createStatement();
            rs = stm.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public int executeUpdate(String sql){
        int i = -1;
        try {
            Statement stm = cn.createStatement();
            i = stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    
    
}
