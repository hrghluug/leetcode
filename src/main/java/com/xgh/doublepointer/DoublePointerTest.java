package com.xgh.doublepointer;

import com.xgh.doublepointer.Entity.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DoublePointerTest {
    @Test
    public void test() {
        System.out.println(q680("ccccbebaeeabebccca"));
    }

    public static int[] q167(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (r > l) {
            if (arr[l] + arr[r] > target) {
                r--;
            }
            if (arr[l] + arr[r] < target) {
                l++;
            }
            if (arr[l] + arr[r] == target) {
                return new int[]{l + 1, r + 1};
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



    public void q88(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public void quickSort(int[] arr, int l, int r) {
        if (r - l < 1) {
            return;
        }
        int temp;
        int l1 = l, r1 = r;
        int mid = arr[l];
        while (r != l) {
            if (arr[l + 1] >= mid) {
                temp = arr[l + 1];
                arr[l + 1] = arr[r];
                arr[r] = temp;
                r--;
            } else {
                temp = arr[l];
                arr[l] = arr[l + 1];
                arr[l + 1] = temp;
                l++;
            }
        }
        quickSort(arr, l1, l);
        quickSort(arr, l + 1, r1);
    }



    public boolean q141(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next.next, low = head.next;
        while (fast != low) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            low = low.next;
        }
        return true;
    }

    @Test
    public void  adsaas(){
        System.out.println(q524("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
    }
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
