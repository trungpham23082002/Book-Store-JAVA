/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import java.util.Comparator;

/**
 *
 * @author pc
 */
public class PersonNameComparator implements Comparator<DTO_ThongKeTop5> {
    @Override
    public int compare(DTO_ThongKeTop5 person1, DTO_ThongKeTop5 person2) {
        return Integer.compare(person1.getSoluong(), person2.getSoluong());
    }
}