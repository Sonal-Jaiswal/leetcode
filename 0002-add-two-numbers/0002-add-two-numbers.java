class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize a dummy node to help build the result linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy; // Pointer to build the result list
        int carry = 0; // To hold the carry-over value

        // Loop until both l1 and l2 are null and there is no carry left
        while (l1 != null || l2 != null || carry != 0) {
            // Get the values from l1 and l2 nodes, defaulting to 0 if a list is exhausted
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Calculate the sum of the digits plus any carry from the previous operation
            int sum = x + y + carry;

            // Update the carry for the next addition
            carry = sum / 10;

            // Create a new node for the current digit (sum % 10)
            current.next = new ListNode(sum % 10);

            // Move the pointer to the next node in the result list
            current = current.next;

            // Move to the next nodes in l1 and l2 if they exist
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the result list, starting from the first real node (skipping the dummy node)
        return dummy.next;
    }
}
