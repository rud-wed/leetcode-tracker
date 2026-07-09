// Last updated: 7/9/2026, 10:25:12 AM
import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] fact = new int[n + 1];
        fact[0] = 1;

        // Step 1: Precompute factorials and fill numbers list
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            numbers.add(i);
        }

        // Step 2: Adjust k to be zero-based
        k--;

        StringBuilder sb = new StringBuilder();

        // Step 3: Build the permutation
        for (int i = n; i >= 1; i--) {
            int index = k / fact[i - 1];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k %= fact[i - 1];
        }

        return sb.toString();
    }
}
