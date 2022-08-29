package com.xgh.doublepointer;

/**
 * @author xgh 2022/8/29
 */
public class Q680 {
    public boolean q680(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        return isPalindrome(s.toCharArray(), 0, s.length() - 1, true);
    }

    public boolean isPalindrome(char[] arr, int l, int r, boolean flag) {
        if (l >= r) {
            return true;
        }
        while (arr[l] == arr[r]) {
            if (l >= r) {
                return true;
            }
            l++;
            r--;
        }
        if (flag) {
            return isPalindrome(arr, l + 1, r, false) || isPalindrome(arr, l, r - 1, false);
        } else {
            return false;
        }
    }
}
