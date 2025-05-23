// Given two integer arrays nums1 and nums2, return an array of their intersection. 
// Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]
  
// Example 2:
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]
// Explanation: [9,4] is also accepted.
 
// Constraints:
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000

class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] > nums2[j]) {
                j++;
            }
            else {
                i++;
            }
        }
        return changeToArray(list);
    }

    private int[] changeToArray(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];
        for(int i=0;i<arr.length;i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
