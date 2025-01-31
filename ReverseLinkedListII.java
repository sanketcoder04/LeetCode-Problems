// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

// Example 1:
// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]
  
// Example 2:
// Input: head = [5], left = 1, right = 1
// Output: [5]
 
// Constraints:
// The number of nodes in the list is n.
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n

class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<Integer> list = new LinkedList<>();
        ListNode temp = head;
        int index = 1;

        while(temp != null) {
            if(index >= left && index <= right) {
                list.add(temp.val);
            }
            index++;
            temp = temp.next;
        }
        Collections.reverse(list);
        temp = head;
        index = 1;
        int ind = 0;

        while(temp != null) {
            if(index >= left && index <= right) {
                temp.val = list.get(ind);
                ind++;
            }
            index++;
            temp = temp.next;
        }
        return head;
    }
}
