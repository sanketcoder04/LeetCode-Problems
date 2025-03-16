// A binary tree is named Even-Odd if it meets the following conditions:
// The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
// For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
// For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
// Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.

// Example 1:
// Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
// Output: true
// Explanation: The node values on each level are:
// Level 0: [1]
// Level 1: [10,4]
// Level 2: [3,7,9]
// Level 3: [12,8,6,2]
// Since levels 0 and 2 are all odd and increasing and levels 1 and 3 are all even and decreasing, the tree is Even-Odd.
  
// Example 2:
// Input: root = [5,4,2,3,3,7]
// Output: false
// Explanation: The node values on each level are:
// Level 0: [5]
// Level 1: [4,2]
// Level 2: [3,3,7]
// Node values in level 2 must be in strictly increasing order, so the tree is not Even-Odd.
  
// Example 3:
// Input: root = [5,9,1,3,5,7]
// Output: false
// Explanation: Node values in the level 1 should be even integers.
 
// Constraints:
// The number of nodes in the tree is in the range [1, 105].
// 1 <= Node.val <= 106

class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean level = false;
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<levelSize;i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            if(level == false) {
                if(!isOdd(list) || !isStrictlyIncreasing(list)) {
                    return false;
                }
            }
            if(level == true) {
                if(!isEven(list) || !isStrictlyDecreasing(list)) {
                    return false;
                }
            }
            level = !level;
        }
        return true;
    }

    private boolean isOdd(List<Integer> list) {
        for(Integer num : list) {
            if(num % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isEven(List<Integer> list) {
        for(Integer num : list) {
            if(num % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isStrictlyIncreasing(List<Integer> list) {
        if(list.size() == 1)  return true;
        for(int i=0;i<list.size()-1;i++) {
            if(list.get(i) >= list.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isStrictlyDecreasing(List<Integer> list) {
        if(list.size() == 1)  return true;
        for(int i=0;i<list.size()-1;i++) {
            if(list.get(i) <= list.get(i+1)) {
                return false;
            }
        }
        return true;
    } 
}
