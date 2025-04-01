// You are given an integer array nums.
// You replace each element in nums with the sum of its digits.
// Return the minimum element in nums after all replacements.

// Example 1:
// Input: nums = [10,12,13,14]
// Output: 1
// Explanation:
// nums becomes [1, 3, 4, 5] after all replacements, with minimum element 1.

// Example 2:
// Input: nums = [1,2,3,4]
// Output: 1
// Explanation:
// nums becomes [1, 2, 3, 4] after all replacements, with minimum element 1.

// Example 3:
// Input: nums = [999,19,199]
// Output: 10
// Explanation:
// nums becomes [27, 10, 19] after all replacements, with minimum element 10.

// Constraints:
// 1 <= nums.length <= 100
// 1 <= nums[i] <= 104

class MinimumElementAfterReplacementWithDigitSum {
    public int minElement(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            nums[i] = elementSum(nums[i]);
        }
        int min = Integer.MAX_VALUE;

        for(int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }

    private int elementSum(int num) {
        int sum = 0;
        while(num != 0) {
            int rem = num % 10;
            sum += rem;
            num = num / 10;
        }
        return sum;
    }
}
