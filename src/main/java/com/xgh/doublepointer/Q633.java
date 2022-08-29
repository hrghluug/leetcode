package com.xgh.doublepointer;

/**
 * @author xgh 2022/8/29
 */
public class Q633 {
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
}
