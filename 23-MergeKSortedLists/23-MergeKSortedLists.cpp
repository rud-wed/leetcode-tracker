// Last updated: 7/20/2026, 10:14:51 AM
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        // Custom comparator for the priority queue
        auto cmp = [](ListNode* a, ListNode* b) {
            return a->val > b->val;
        };

        // Min-heap to store the current heads of each list
        priority_queue<ListNode*, vector<ListNode*>, decltype(cmp)> pq(cmp);

        // Initialize the heap with the head of each list
        for (auto node : lists) {
            if (node) pq.push(node);
        }

        // Dummy node to simplify result list construction
        ListNode dummy;
        ListNode* tail = &dummy;

        // Extract the smallest node and push its next into the heap
        while (!pq.empty()) {
            ListNode* curr = pq.top();
            pq.pop();
            tail->next = curr;
            tail = tail->next;
            if (curr->next) pq.push(curr->next);
        }

        return dummy.next;
    }
};