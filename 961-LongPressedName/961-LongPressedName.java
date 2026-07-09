// Last updated: 7/9/2026, 10:24:04 AM
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;

        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                // characters match
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                // long press case
                j++;
            } else {
                return false;
            }
        }

        // all characters in name must be matched
        return i == name.length();
    }
}
