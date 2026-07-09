// Last updated: 7/9/2026, 10:24:46 AM
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;  // adjust for 1-based indexing
            int remainder = columnNumber % 26;
            char letter = (char) ('A' + remainder);
            result.insert(0, letter);  // prepend letter
            columnNumber /= 26;
        }

        return result.toString();
    }
}
