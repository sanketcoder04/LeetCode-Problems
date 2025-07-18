// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

// Example 1:
// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
  
// Example 2:
// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
// Explanation: 
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]
 
// Constraints:
// 1 <= nums.length <= 105
// -231 <= nums[i] <= 231 - 1
// 0 <= k <= 105

class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k % n == 0) {
            return;
        }
        k = k % n;
        int[] temp = new int[k];

        // Store last k elements at the Array
        for(int i=n-k,j=0;i<n && j<temp.length;i++,j++) {
            temp[j] = nums[i];
        }

        // Shift the remaining portion by k places from the last for no data loss
        for(int i=n-k-1;i>=0;i--) {
            nums[i + k] = nums[i];
        }

        // Assign the remaining part to the original array
        for(int i=0;i<temp.length;i++) {
            nums[i] = temp[i];
        }
    }

    // Another Approach
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k % n == 0) {
            return;
        }
        k = k % n;

        // reverse arr from 0 to k - 1
        reverse(nums, 0, n - k - 1);

        // reverse arr from k to n - 1
        reverse(nums, n - k, n - 1);

        // reverse whole array
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
