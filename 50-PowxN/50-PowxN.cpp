// Last updated: 7/9/2026, 10:25:26 AM
class Solution {
public:
    double myPow(double x, int n) {
        long long N = n;  // Convert to long long to handle INT_MIN
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    double fastPow(double x, long long n) {
        if (n == 0) return 1.0;
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
};
