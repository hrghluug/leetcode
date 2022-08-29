package com.xgh.doublepointer;

/**
 * @author xgh 2022/8/29
 */
public class Q345 {
    public String q345(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] cList = {'a', 'u', 'i', 'o', 'e', 'A', 'U', 'I', 'O', 'E'};
        int l = -1, r = s.length();
        char[] chars = s.toCharArray();
        while (r >= l) {
            while (l < s.length() - 1 && !isVowels(chars[++l], cList)) ;
            while (r > 0 && !isVowels(chars[--r], cList)) ;
            if (r >= l && r >= 0 && l < s.length()) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
            }

        }
        return new String(chars);
    }
    private boolean isVowels(char c, char[] cList) {
        for (char c1 : cList) {
            if (c1 == c) {
                return true;
            }
        }
        return false;
    }
}
