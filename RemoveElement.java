// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. 
// Then return the number of elements in nums which are not equal to val.
// Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
// Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
// The remaining elements of nums are not important as well as the size of nums.
// Return k.
// Custom Judge:
// The judge will test your solution with the following code:
// int[] nums = [...]; 
// int val = ...; 
// int[] expectedNums = [...]; 
// int k = removeElement(nums, val); 
// assert k == expectedNums.length;
// sort(nums, 0, k); 
// for (int i = 0; i < actualLength; i++) {
//     assert nums[i] == expectedNums[i];
// }
// If all assertions pass, then your solution will be accepted.

// Example 1:
// Input: nums = [3,2,2,3], val = 3
// Output: 2, nums = [2,2,_,_]
// Explanation: Your function should return k = 2, with the first two elements of nums being 2.
// It does not matter what you leave beyond the returned k (hence they are underscores).
  
// Example 2:
// Input: nums = [0,1,2,2,3,0,4,2], val = 2
// Output: 5, nums = [0,1,4,0,3,_,_,_]
// Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
// Note that the five elements can be returned in any order.
// It does not matter what you leave beyond the returned k (hence they are underscores).

// Constraints:
// 0 <= nums.length <= 100
// 0 <= nums[i] <= 50
// 0 <= val <= 100

class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int occurance = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == val){
                occurance++;
            }
        }
        int lastIndex = getLastIndex(nums,val);

        for(int i=0;i<=nums.length-occurance-1;i++){
            if(nums[i] == val){
                int temp = nums[i];
                nums[i] = nums[lastIndex];
                nums[lastIndex] = temp;
                while(nums[lastIndex] == val){
                    lastIndex--;
                }
                // lastIndex--;
            }
        }
        return nums.length-occurance;
    }
    public int getLastIndex(int[] nums,int val){
        int lastIndex = nums.length-1;
        while(lastIndex > 0){
            if(nums[lastIndex] != val){
                break;
            }
            lastIndex--;
        }
        return lastIndex;
    }
}
