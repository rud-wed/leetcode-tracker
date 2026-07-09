// Last updated: 7/9/2026, 10:23:54 AM
import java.util.*;

class Solution {
    public int missingInteger(int[] nums) {
        // Step 1: find longest sequential prefix
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Step 2: put all nums in a set for quick lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Step 3: find smallest missing integer >= sum
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}
