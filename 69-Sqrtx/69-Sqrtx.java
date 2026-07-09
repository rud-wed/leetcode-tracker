// Last updated: 7/9/2026, 10:24:59 AM
class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1, right = x / 2, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid <= x) {
                ans = mid;      // possible answer
                left = mid + 1; // try bigger
            } else {
                right = mid - 1; // try smaller
            }
        }
        return ans;
    }
}
