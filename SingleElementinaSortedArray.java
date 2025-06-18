// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
// Return the single element that appears only once.
// Your solution must run in O(log n) time and O(1) space.

// Example 1:
// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2
  
// Example 2:
// Input: nums = [3,3,7,7,10,11,11]
// Output: 10
 
// Constraints:
// 1 <= nums.length <= 105
// 0 <= nums[i] <= 105

class SingleElementinaSortedArray {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int start, int end) {
        if(start == end) {
            // check forward and backward, if found same return 0 (so that it doesn't affect the real answer)
            if(start - 1 < 0 && nums[start] == nums[start + 1]) {
                return 0;
            }
            if(end + 1 == nums.length && nums[end] == nums[end - 1]) {
                return 0;
            }
            if((start > 0 && end < nums.length - 1) && (nums[start] == nums[start + 1] || nums[start] == nums[start - 1])) {
                return 0;
            }
            return nums[start];
        }
        int mid = (start + end) / 2;
        return search(nums, start, mid) + search(nums, mid + 1, end);
    }
}
