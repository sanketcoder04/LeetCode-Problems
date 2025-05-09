// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
  
// Implement the MinStack class:
// MinStack() initializes the stack object.
// void push(int val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.
// You must implement a solution with O(1) time complexity for each function.

// Example 1:
// Input
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]
// Output
// [null,null,null,null,-3,null,0,-2]
// Explanation
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top();    // return 0
// minStack.getMin(); // return -2
 
// Constraints:
// -231 <= val <= 231 - 1
// Methods pop, top and getMin operations will always be called on non-empty stacks.
// At most 3 * 104 calls will be made to push, pop, top, and getMin.

class MinStack {
    private Node head;
    private class Node{
        int data;
        int min;
        Node next;

        Node(int data, int min, Node next){
            this.data = data;
            this.min = min;
            this.next = next;
        }
    }

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(head == null) {
            head = new Node(val,val,null);
        }
        else {
            head = new Node(val, Math.min(val,head.min), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return head.min;
    }
}

// Here head of the Linked List treated as the top item and when push & pop operation does head changes
// min value stored at head, whenever push operation does it updates with current min value with new one
