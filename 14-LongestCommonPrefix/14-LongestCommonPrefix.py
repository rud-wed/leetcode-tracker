# Last updated: 7/20/2026, 10:15:12 AM
class Solution:
    def longestCommonPrefix(self, strs):
        if not strs:
            return ""

        for i in range(len(strs[0])):
            char = strs[0][i]
            for word in strs[1:]:
                if i >= len(word) or word[i] != char:
                    return strs[0][:i]

        return strs[0]