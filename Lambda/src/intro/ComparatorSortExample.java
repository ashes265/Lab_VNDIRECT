/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author phung
 */
public class ComparatorSortExample {

    public static void main(String[] args) {
        Integer[] values = {12, 345, 34, 7, 9, 12, 9};
//        Arrays.sort(values, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
        //cach 2
        Arrays.sort(values,(Integer o1, Integer o2)->{
            return o2-o1;
        });
        for(Integer ele:values){
            System.out.print(ele+", ");
        }
    }
}
