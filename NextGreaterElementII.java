// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
// The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number.
// If it doesn't exist, return -1 for this number.

// Example 1:
// Input: nums = [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number. 
// The second 1's next greater number needs to search circularly, which is also 2.
  
// Example 2:
// Input: nums = [1,2,3,4,3]
// Output: [2,3,4,-1,4]
 
// Constraints:
// 1 <= nums.length <= 104
// -109 <= nums[i] <= 109

class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            int max = search(nums, i, nums[i]);
            result[i] = max;
        }
        return result;
    }
  
    private int search(int[] nums, int index, int element) {
        int counter = -1;
        if(index == nums.length-1) {
            counter = 0;
        }
        else {
            counter = index + 1;
        }
        while(counter != index) {
            if(nums[counter] > element) {
                return nums[counter];
            }
            if(counter == nums.length-1) {
                counter = 0;
            }
            else {
                counter ++;
            }
        }
        return -1;
    }
}
