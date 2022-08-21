package com.xgh.doublepointer;

import org.junit.Test;

public class DoublePointerTest {
    @Test
    public void test() {
        System.out.println(q680("eeccccbebaeeabebccceea"));
    }

    public static int[] q167(int[] arr,int target){
        int l=0;
        int r=arr.length-1;
        while (r>l){
            if (arr[l]+arr[r]>target){
                r--;
            }
            if (arr[l]+arr[r]<target){
                l++;
            }
            if (arr[l]+arr[r]==target){
                return new int[]{l+1,r+1};
            }
        }
        return null;
    }
    public boolean q633(int c) {
        int l = 0;
        int r = (int) Math.sqrt(c);
        while (r >= l) {
//            l*l+r*r<c 当数值在接近临界是可能导致越界
            if (l * l < c - r * r) {
                l++;
            } else if (l * l > c - r * r) {
                r--;
            } else {
                return true;
            }
        }
        return false;
    }

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

    public boolean q680(String s) {
        int l = 0, r = s.length() - 1;
        int[] arr = {-1, -1,-1};
        while (r >= l) {
            while (s.charAt(l) == s.charAt(r)) {
                if (r <= l) {
                    return true;
                }
                l++;
                r--;
            }
            if (arr[0] == -1||arr[1]==-1) {
                if (s.charAt(l + 1) == s.charAt(r) && arr[2]==-1) {
                    arr[0] = l;
                    arr[1] = r;
                    arr[2]=0;
                    l++;
                } else if (s.charAt(l) == s.charAt(r - 1)&&arr[2]!=-1) {
                    arr[0] = l;
                    arr[1] = r;
                    r--;
                } else {
                    return false;
                }
            } else {
                if (arr[1] != -1) {
                    l = arr[0];
                    r = arr[1];
                    arr[1] = -1;
                } else {
                    return false;
                }
            }
        }
        return false;
    }


}
