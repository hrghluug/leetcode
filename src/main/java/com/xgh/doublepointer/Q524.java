package com.xgh.doublepointer;

import java.util.List;

/**
 * @author xgh 2022/8/29
 */
public class Q524 {
    public String q524(String s, List<String> dictionary) {
        String bestAns = "";
        mark:
        for (String str : dictionary) {
            int start = 0;
            for (char c : str.toCharArray()) {
                int idx = s.indexOf(c, start);
                if (idx != -1) {
                    start = idx + 1;
                } else {
                    continue mark;
                }
            }
            if (bestAns.length() == str.length()) {
                bestAns = dictionaryOrder(bestAns, str);
            } else if (bestAns.length() < str.length()) {
                bestAns = str;
            }
        }
        return bestAns;
    }

    public String dictionaryOrder(String str, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (str.charAt(i) < s.charAt(i)) {
                return str;
            } else if (str.charAt(i) > s.charAt(i)) {
                return s;
            }
        }
        return s;
    }
}
