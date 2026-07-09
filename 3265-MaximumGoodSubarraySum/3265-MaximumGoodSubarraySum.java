// Last updated: 7/9/2026, 10:23:43 AM
import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Long> map = new HashMap<>();
        long prefixSum = 0;
        long maxSum = Long.MIN_VALUE;

        for (int num : nums) {
            prefixSum += num;

            // Check for good subarray ending here
            if (map.containsKey(num - k)) {
                maxSum = Math.max(maxSum, prefixSum - map.get(num - k));
            }
            if (map.containsKey(num + k)) {
                maxSum = Math.max(maxSum, prefixSum - map.get(num + k));
            }

            // Update map with best prefix sum for this number
            map.put(num, Math.min(map.getOrDefault(num, Long.MAX_VALUE), prefixSum - num));
        }

        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }
}
