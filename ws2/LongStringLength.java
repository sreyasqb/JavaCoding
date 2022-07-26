/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20pt33
 */
public class LongStringLength {

    public List<Integer> columnMax(List<List<String>> array) {
        List<Integer> l = new ArrayList<Integer>();
        for (List<String> arr : array) {
            int i = 0;
            for (String s : arr) {
                if (s.length() > i) {
                    i = s.length();
                }
            }
            l.add(i);
        }
        return l;
    }

    public static void main(String[] args) {
        LongStringLength l = new LongStringLength();
        List<List<String>> data = new ArrayList<List<String>>();
        data.add(new ArrayList<String>());
        data.add(new ArrayList<String>());
        data.get(0).add("String");
        data.get(0).add("Sindhu");
        data.get(1).add("Krishnashree");
        data.get(1).add("Agilan");
        System.out.println(l.columnMax(data));
    }
}
