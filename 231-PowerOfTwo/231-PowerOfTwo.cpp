// Last updated: 7/9/2026, 10:24:16 AM
class Solution {
public:
    bool isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
};
