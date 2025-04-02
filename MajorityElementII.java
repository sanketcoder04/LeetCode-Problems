// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

// Example 1:
// Input: nums = [3,2,3]
// Output: [3]
  
// Example 2:
// Input: nums = [1]
// Output: [1]
  
// Example 3:
// Input: nums = [1,2]
// Output: [1,2]
 
// Constraints:
// 1 <= nums.length <= 5 * 104
// -109 <= nums[i] <= 109

class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> keys = new ArrayList<>();

        for(int i=0;i<nums.length;i++) {
            Integer key = nums[i];
            if(map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }
            else {
                map.put(key, 1);
            }
            // map.put(key, map.getOrDefault(key, 0) + 1) -> Another approach
        }
        
        for(Integer key : map.keySet()) {
            if(map.get(key) > nums.length/3) {
                keys.add(key);
            }
        }
        return keys;
    }
}
