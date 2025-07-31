// You are given two linked lists: list1 and list2 of sizes n and m respectively.
// Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
// The blue edges and nodes in the following figure indicate the result:
// Build the result list and return its head.

// Example 1:
// Input: list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
// Output: [10,1,13,1000000,1000001,1000002,5]
// Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.
  
// Example 2:
// Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
// Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
// Explanation: The blue edges and nodes in the above figure indicate the result.
 
// Constraints:
// 3 <= list1.length <= 104
// 1 <= a <= b < list1.length - 1
// 1 <= list2.length <= 104

class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode list1_start = list1;
        ListNode list1_end = list1;

        ListNode list2_start = list2;
        ListNode list2_end = list2;
        int index = 0;

        while(index < a - 1) {
            list1_start = list1_start.next;
            index++;
        }
        list1_end = list1_start;

        while(index <= b) {
            list1_end = list1_end.next;
            index++;
        }
        while(list2_end.next != null) {
            list2_end = list2_end.next;
        }
        list1_start.next = list2_start;
        list2_end.next = list1_end;
        return list1;
    }
}
