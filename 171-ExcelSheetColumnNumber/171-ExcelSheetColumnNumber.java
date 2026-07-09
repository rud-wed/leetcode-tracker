// Last updated: 7/9/2026, 10:24:43 AM
class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            int value = c - 'A' + 1;   // convert letter to number (A=1, B=2, … Z=26)

            result = result * 26 + value;  // shift left in base-26 and add current value
        }

        return result;
    }
}
