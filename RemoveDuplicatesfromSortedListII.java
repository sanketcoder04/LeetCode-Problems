// Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. 
// Return the linked list sorted as well.

// Example 1:
// Input: head = [1,2,3,3,4,4,5]
// Output: [1,2,5]
  
// Example 2:
// Input: head = [1,1,1,2,3]
// Output: [2,3]
 
// Constraints:
// The number of nodes in the list is in the range [0, 300].
// -100 <= Node.val <= 100
// The list is guaranteed to be sorted in ascending order.

class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ListNode temp = head;

        while(temp != null) {
            if(map.containsKey(temp.val)) {
                map.put(temp.val, map.get(temp.val) + 1);
            }
            else {
                map.put(temp.val, 1);
            }
            temp = temp.next;
        }

        ListNode node = new ListNode();
        temp = node;

        for(Integer key : map.keySet()) {
            if(map.get(key) == 1) {
                ListNode newNode = new ListNode(key);
                temp.next = newNode;
                temp = temp.next;       // temp = newNode
            }   
        }
        return node.next;
    }
}
