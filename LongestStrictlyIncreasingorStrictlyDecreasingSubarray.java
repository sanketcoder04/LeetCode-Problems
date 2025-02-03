// You are given an array of integers nums. Return the length of the longest subarray of nums which is either strictly increasing or strictly decreasing.

// Example 1:
// Input: nums = [1,4,3,3,2]
// Output: 2
// Explanation:
// The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].
// The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].
// Hence, we return 2.

// Example 2:
// Input: nums = [3,3,3,3]
// Output: 1
// Explanation:
// The strictly increasing subarrays of nums are [3], [3], [3], and [3].
// The strictly decreasing subarrays of nums are [3], [3], [3], and [3].
// Hence, we return 1.

// Example 3:
// Input: nums = [3,2,1]
// Output: 3
// Explanation:
// The strictly increasing subarrays of nums are [3], [2], and [1].
// The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1], and [3,2,1].
// Hence, we return 3.

// Constraints:
// 1 <= nums.length <= 50
// 1 <= nums[i] <= 50

class LongestStrictlyIncreasingorStrictlyDecreasingSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int size = nums.length;
        int index = 0;
        int longest = 1;
        int increase = 1;
        int decrease = 1;

        while(index < size-1) {
            if(nums[index] < nums[index+1]) {
                longest++;
            }
            else {
                increase = Math.max(increase, longest);
                longest = 1;
            }
            if(index == size-2) {
                increase = Math.max(increase, longest);
            }
            index++;
        }
        index = 0;
        longest = 1;

        while(index < size-1) {
            if(nums[index] > nums[index+1]) {
                longest++;
            }
            else {
                decrease = Math.max(decrease, longest);
                longest = 1;
            }
            if(index == size-2) {
                decrease = Math.max(decrease, longest);
            }
            index++;
        }
        return Math.max(increase, decrease);
    }
}
