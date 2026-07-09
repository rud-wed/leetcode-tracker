// Last updated: 7/9/2026, 10:25:19 AM
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        
        // Step 2: Iterate and merge
        int[] current = intervals[0];
        merged.add(current);
        
        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                // Overlap → merge
                current[1] = Math.max(current[1], interval[1]);
            } else {
                // No overlap → add new interval
                current = interval;
                merged.add(current);
            }
        }
        
        // Step 3: Convert list to array
        return merged.toArray(new int[merged.size()][]);
    }
}
