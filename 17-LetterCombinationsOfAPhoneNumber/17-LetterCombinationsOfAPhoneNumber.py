# Last updated: 7/20/2026, 10:15:06 AM
class Solution:
    def letterCombinations(self, digits):
        if not digits:
            return []

        phone = {
            '2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl',
            '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'
        }

        res = []

        def backtrack(index, path):
            if index == len(digits):
                res.append(path)
                return
            for char in phone[digits[index]]:
                backtrack(index + 1, path + char)

        backtrack(0, "")
        return res
        