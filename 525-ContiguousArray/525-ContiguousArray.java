// Last updated: 7/9/2026, 10:24:10 AM
import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // base case: sum=0 at index -1

        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1 ? 1 : -1);

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
