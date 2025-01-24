// Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

// Example 1:
// Input: head = [1,1,2]
// Output: [1,2]
  
// Example 2:
// Input: head = [1,1,2,3,3]
// Output: [1,2,3]
 
// Constraints:
// The number of nodes in the list is in the range [0, 300].
// -100 <= Node.val <= 100
// The list is guaranteed to be sorted in ascending order.

class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        while(temp != null) {
            if(!map.containsKey(temp.val)) {
                map.put(temp.val, 1);
            }
            temp = temp.next;
        }
        ListNode node = new ListNode();
        temp = node;

        for(Integer key : map.keySet()) {
            ListNode newNode = new ListNode(key);
            temp.next = newNode;
            temp = temp.next;
        }
        return node.next;
    }
}
