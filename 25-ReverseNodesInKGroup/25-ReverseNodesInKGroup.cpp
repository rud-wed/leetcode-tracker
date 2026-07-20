// Last updated: 7/20/2026, 10:14:47 AM
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if (!head || k == 1) return head;

        // Dummy node to simplify edge cases
        ListNode dummy(0);
        dummy.next = head;
        ListNode* prevGroupEnd = &dummy;

        while (true) {
            // Check if there are at least k nodes left to reverse
            ListNode* kth = prevGroupEnd;
            for (int i = 0; i < k && kth; ++i) {
                kth = kth->next;
            }
            if (!kth) break;

            // Reverse k nodes
            ListNode* groupStart = prevGroupEnd->next;
            ListNode* curr = groupStart->next;
            for (int i = 1; i < k; ++i) {
                groupStart->next = curr->next;
                curr->next = prevGroupEnd->next;
                prevGroupEnd->next = curr;
                curr = groupStart->next;
            }

            // Move prevGroupEnd to the end of the reversed group
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }
};