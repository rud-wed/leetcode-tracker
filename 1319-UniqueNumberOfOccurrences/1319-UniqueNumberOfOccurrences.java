// Last updated: 7/9/2026, 10:23:59 AM
import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count occurrences
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> seen = new HashSet<>();

        // Check uniqueness of counts
        for (int count : freqMap.values()) {
            if (!seen.add(count)) {
                return false;  // duplicate count found
            }
        }

        return true;
    }
}
