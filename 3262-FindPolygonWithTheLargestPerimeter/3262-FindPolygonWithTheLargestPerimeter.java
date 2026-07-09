// Last updated: 7/9/2026, 10:23:50 AM
import java.util.*;

class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Traverse from largest side backwards
        for (int i = nums.length - 1; i >= 2; i--) {
            long others = sum - nums[i];
            if (others > nums[i]) {
                return sum; // valid polygon perimeter
            }
            sum -= nums[i]; // remove largest side and continue
        }

        return -1;
    }
}
