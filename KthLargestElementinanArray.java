// Given an integer array nums and an integer k, return the kth largest element in the array.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Example 1:
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5
  
// Example 2:
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4
 
// Constraints:
// 1 <= k <= nums.length <= 105
// -104 <= nums[i] <= 104

class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int item = -1;
        int count = 0;

        for(int i=n-1;i>=0;i--) {
            if(count == k) {
                break;
            }
            item = nums[i];
            count++;
        }
        return item;
    }
}
