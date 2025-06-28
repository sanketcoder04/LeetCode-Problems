// Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target.
// If there is no such subarray, return 0 instead.

// Example 1:
// Input: target = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: The subarray [4,3] has the minimal length under the problem constraint.
  
// Example 2:
// Input: target = 4, nums = [1,4,4]
// Output: 1
  
// Example 3:
// Input: target = 11, nums = [1,1,1,1,1,1,1,1]
// Output: 0
 
// Constraints:
// 1 <= target <= 109
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 104

class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        while(end < nums.length) {
            // Add the end index item in the sum
            sum += nums[end];
                
            // Check if the sum >= target, then
            // Store the min length then remove the start elemnet from sum and increment start
            while(sum >= target) {
                min = Math.min(end - start + 1, min);
                sum -= nums[start];
                start++;
            }
            // Increase end at every iteration
            end++;
        }
        return min != Integer.MAX_VALUE ? min : 0;
    }
}
