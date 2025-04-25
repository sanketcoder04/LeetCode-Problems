// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

// Example 1:
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [5,6]
  
// Example 2:
// Input: nums = [1,1]
// Output: [2]
 
// Constraints:
// n == nums.length
// 1 <= n <= 105
// 1 <= nums[i] <= n

class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        while(index < nums.length) {
            int correctIndex = nums[index] - 1;
            if(nums[index] != nums[correctIndex]) {
                int temp = nums[index];
                nums[index] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
            else {
                index++;
            }
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != i + 1){
                list.add(i + 1);
            }
        }
        return list;
    }
}
