// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
  
// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]
  
// Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]
 
// Constraints:
// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.

class TwoSum {

    // Iteration Method

    public int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        int result = 0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                result = nums[i]+nums[j];
                if(result == target){
                    arr[0] = i;
                    arr[1] = j; 
                    break;
                }
            }
        }
        return arr;
    }

    // Using HashMap

    public int[] twoSum(int[] nums, int target) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for(int i=0;i<nums.length;i++) {
            int num = nums[i]; 
            if(!map.isEmpty() && map.containsKey(target - num)) {
                return new int[]{map.get(target - num), i};
            }
            else {
                map.put(num, i);
            }
        }
        return new int[]{};
    }
}
