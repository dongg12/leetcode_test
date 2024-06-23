package com.wd;

import java.util.HashMap;

public class Test25 {


    public static void main(String[] args) {

    }
    private static HashMap<Character, Integer> map;

    static {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'I' && i + 1 < s.length() && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                if (s.charAt(i + 1) == 'V') {
                    num += 4;
                }
                if (s.charAt(i + 1) == 'X') {
                    num += 9;
                }
                i++;
            } else if (c == 'C' && i + 1 < s.length() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                if (s.charAt(i + 1) == 'D') {
                    num += 400;
                }
                if (s.charAt(i + 1) == 'M') {
                    num += 900;
                }
                i++;
            } else if (c == 'X' && i + 1 < s.length() && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                if (s.charAt(i + 1) == 'L') {
                    num += 40;
                }
                if (s.charAt(i + 1) == 'C') {
                    num += 90;
                }
                i++;
            } else {
                num += map.get(c);
            }
        }
        return num;
    }
}
