// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

// Example 1:
// Input: nums = [1,2,3,1], k = 3
// Output: true
  
// Example 2:
// Input: nums = [1,0,1,1], k = 1
// Output: true
  
// Example 3:
// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false
 
// Constraints:
// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109
// 0 <= k <= 105

class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            } 
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        for(int key : map.keySet()) {
            List<Integer> values = map.get(key);
            if(values.size() > 1 && checkDuplicate(values, k)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDuplicate(List<Integer> list, int k) {
        for(int i=0;i<list.size()-1;i++) {
            int a = list.get(i);
            for(int j=i+1;j<list.size();j++) {
                int b = list.get(j);
                if(Math.abs(a - b) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
