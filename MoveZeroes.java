// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Note that you must do this in-place without making a copy of the array.

// Example 1:
// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
  
// Example 2:
// Input: nums = [0]
// Output: [0]
 
// Constraints:
// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        List<Integer> nonZero = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != 0) {
                nonZero.add(nums[i]);
            }
        }
        for(int i=0;i<nonZero.size();i++) {
            nums[i] = nonZero.get(i);
        }
        for(int i=nonZero.size();i<nums.length;i++) {
            nums[i] = 0;
        }
    }

    // Another Approach
    public void moveZeroes(int[] nums) {
        int index = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != 0) {
                nums[index] = nums[i];
                index++;
                count++;
            }
        }
        for(int i=count;i<nums.length;i++) {
            nums[i] = 0;
        }
    }
}
