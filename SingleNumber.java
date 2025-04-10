// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example 1:
// Input: nums = [2,2,1]
// Output: 1

// Example 2:
// Input: nums = [4,1,2,1,2]
// Output: 4

// Example 3:
// Input: nums = [1]
// Output: 1

// Constraints:
// 1 <= nums.length <= 3 * 104
// -3 * 104 <= nums[i] <= 3 * 104
// Each element in the array appears twice except for one element which appears only once.

class SingleNumber {

    // Using Sorting
    
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int number = 0;
        if(nums.length == 1) {
            return nums[0];
        }
        for(int i=1;i<nums.length-1;i++) {
            if((nums[i] != nums[i+1]) && (nums[i-1] != nums[i])) {
                number = nums[i];
            }
        }
        if(nums[nums.length-1] != nums[nums.length-2] && nums.length>1) {
            number = nums[nums.length-1];
        }
        if(nums[0] != nums[1] && nums.length>1) {
            number = nums[0];
        }
        return number;
    }

    // Using XOR Operation

    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0;i<nums.length;i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }
}
