class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode iteratingNode = new ListNode(-1);
        ListNode newHead = iteratingNode;

        // Iterate and compare each Node from both list
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                iteratingNode.next = list1;
                list1 = list1.next;
            } else {
                iteratingNode.next = list2;
                list2 = list2.next;
            }

            iteratingNode = iteratingNode.next;
        }

        // Append the list that hasnt being completely iterated
        iteratingNode.next = (list1 != null) ?  list1 : list2;

        // Return next as first node is always (-1)
        return newHead.next;
    }
}

//Time: O(m + n) -> m and n are size of lnked lists
//Space: O(1)