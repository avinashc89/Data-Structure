package com.tool.java.leetcode;

public class FirstBadVersion
{
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int badVersion = -1;

        while (low <= high) {
            int mid = ((low + high) / 2);
            if (isBadVersion(mid)) {
                badVersion = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return badVersion;
    }

    private boolean isBadVersion (int mid)
    {
         if(mid >30) return true;
         return false;
    }

}
