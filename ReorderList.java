// You are given the head of a singly linked-list. The list can be represented as:
// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

// Example 1:
// Input: head = [1,2,3,4]
// Output: [1,4,2,3]
  
// Example 2:
// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]
 
// Constraints:
// The number of nodes in the list is in the range [1, 5 * 104].
// 1 <= Node.val <= 1000

class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode list1 = head;
        ListNode list2 = reverse(slow.next);
        slow.next = null;

        merge(list1,list2);
    }
    public ListNode reverse(ListNode head){
        ListNode presentNode = head;
        ListNode prevNode = null;
        ListNode nextNode = null;
        while(presentNode != null){
            nextNode = presentNode.next;
            presentNode.next = prevNode;
            prevNode = presentNode;
            presentNode = nextNode;
        }
        head = prevNode;
        return head;
    }
    public void merge(ListNode node1, ListNode node2){
        while(node2 != null){
            ListNode list1 = node1.next;
            ListNode list2 = node2.next;

            node1.next = node2;
            node2.next = list1;

            node1 = list1;
            node2 = list2;
        }
    }
}
