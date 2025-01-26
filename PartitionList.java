// Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
// You should preserve the original relative order of the nodes in each of the two partitions.

// Example 1:
// Input: head = [1,4,3,2,5,2], x = 3
// Output: [1,2,2,4,3,5]
  
// Example 2:
// Input: head = [2,1], x = 2
// Output: [1,2]
 
// Constraints:
// The number of nodes in the list is in the range [0, 200].
// -100 <= Node.val <= 100
// -200 <= x <= 200

class PartitionList {
    public ListNode partition(ListNode head, int x) {
        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();

        ListNode temp = head;
        while(temp != null) {
            if(temp.val < x) {
                small.add(temp.val);
            }
            else {
                large.add(temp.val);
            }
            temp = temp.next;
        }
        temp = head;
        int index = 0;
        while(index != small.size()) {
            temp.val = small.get(index);
            temp = temp.next;
            index++;
        }
        index = 0;
        while(index != large.size()) {
            temp.val = large.get(index);
            temp = temp.next;
            index++;
        }
        return head;
    }
}
