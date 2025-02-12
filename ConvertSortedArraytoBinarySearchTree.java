// Given an integer array nums where the elements are sorted in ascending order, convert it to a 
// height-balanced binary search tree.

// Example 1:
// Input: nums = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: [0,-10,5,null,-3,null,9] is also accepted:

// Example 2:
// Input: nums = [1,3]
// Output: [3,1]
// Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 
// Constraints:
// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums is sorted in a strictly increasing order.

class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return populateSorted(nums,0,nums.length-1);
    }
    private TreeNode populateSorted(int[] nums,int start,int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]); // insert mid element
        node.left = populateSorted(nums, start, mid - 1); // call for left part
        node.right = populateSorted(nums, mid + 1, end); // call for right part
        return node;
    }
}
