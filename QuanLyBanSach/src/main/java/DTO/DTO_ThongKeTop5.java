/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author pc
 */
public class DTO_ThongKeTop5 {
    public String masach;

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    public int soluong;

    public DTO_ThongKeTop5(String masach, int soluong) {
        this.masach = masach;
        this.soluong = soluong;
    }
    public DTO_ThongKeTop5() {
    }
}
