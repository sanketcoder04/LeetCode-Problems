// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// You must solve this problem without using the library's sort function.

// Example 1:
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
  
// Example 2:
// Input: nums = [2,0,1]
// Output: [0,1,2]

// Constraints:
// n == nums.length
// 1 <= n <= 300
// nums[i] is either 0, 1, or 2.

class SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    // Another approach
  
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0) {
                count0++;
            }
            else if(nums[i] == 1) {
                count1++;
            }
            else {
                count2++;
            }
        }
        for(int i=0;i<count0;i++) {
            nums[i] = 0;
        }
        for(int i=count0;i<count0+count1;i++) {
            nums[i] = 1;
        }
        for(int i=count0+count1;i<nums.length;i++) {
            nums[i] = 2;
        }
    }
}
