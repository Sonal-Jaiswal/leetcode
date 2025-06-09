import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-heap to keep track of the smallest node
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each non-null list to the heap
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        // Dummy head to simplify result list construction
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll(); // Get node with smallest value
            current.next = node;       // Append to result
            current = current.next;    // Move pointer

            if (node.next != null) {
                pq.offer(node.next);   // Push the next node in list into heap
            }
        }

        return dummy.next;
    }
}
