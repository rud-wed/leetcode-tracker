// Last updated: 7/20/2026, 10:12:06 AM
1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5
6        int left = 0;
7        int right = m * n - 1;
8
9        while (left <= right) {
10            int mid = left + (right - left) / 2;
11            int midValue = matrix[mid / n][mid % n]; // convert 1D index to 2D
12
13            if (midValue == target) {
14                return true;
15            } else if (midValue < target) {
16                left = mid + 1;
17            } else {
18                right = mid - 1;
19            }
20        }
21
22        return false;
23    }
24}
25