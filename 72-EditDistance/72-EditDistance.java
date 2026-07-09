// Last updated: 7/9/2026, 10:24:55 AM
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] = minimum operations to convert first i chars of word1 to first j chars of word2
        int[][] dp = new int[m + 1][n + 1];

        // Base cases: converting empty string
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // delete all characters
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // insert all characters
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // no operation needed
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j],    // delete
                        Math.min(
                            dp[i][j - 1], // insert
                            dp[i - 1][j - 1] // replace
                        )
                    );
                }
            }
        }

        return dp[m][n];
    }
}
