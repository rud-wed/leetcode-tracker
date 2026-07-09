// Last updated: 7/9/2026, 10:24:31 AM
import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert numbers to strings
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Sort using custom comparator
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", return "0"
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build the result
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}
