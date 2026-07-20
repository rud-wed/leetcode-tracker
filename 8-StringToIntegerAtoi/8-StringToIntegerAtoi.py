# Last updated: 7/20/2026, 10:15:25 AM
class Solution:
    def myAtoi(self, s):
        s = s.lstrip()  # Step 1: Remove leading whitespace
        if not s:
            return 0

        sign = 1
        i = 0

        # Step 2: Check for sign
        if s[0] == '-':
            sign = -1
            i += 1
        elif s[0] == '+':
            i += 1

        # Step 3: Read digits
        num = 0
        while i < len(s) and s[i].isdigit():
            num = num * 10 + int(s[i])
            i += 1

        # Step 4: Apply sign
        num *= sign

        # Step 5: Clamp to 32-bit range
        INT_MIN, INT_MAX = -2**31, 2**31 - 1
        if num < INT_MIN:
            return INT_MIN
        if num > INT_MAX:
            return INT_MAX

        return num