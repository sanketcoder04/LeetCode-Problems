// Given an array of integers nums, sort the array in ascending order and return it.
// You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

// Example 1:
// Input: nums = [5,2,3,1]
// Output: [1,2,3,5]
// Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
  
// Example 2:
// Input: nums = [5,1,1,2,0,0]
// Output: [0,0,1,1,2,5]
// Explanation: Note that the values of nums are not necessairly unique.
 
// Constraints:
// 1 <= nums.length <= 5 * 104
// -5 * 104 <= nums[i] <= 5 * 104

class SortanArray {
    public int[] sortArray(int[] arr) {
        if (arr.length == 1) {
            return arr; // We will return the arr when it has single element in it
        }
        int mid = arr.length / 2;
        int left[] = sortArray(Arrays.copyOfRange(arr, 0, mid));
        int right[] = sortArray(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }
    
    private static int[] merge(int first[], int second[]) {
        int mix[] = new int[first.length + second.length]; // we will return this array as merged and sorted
        int i = 0;
        int j = 0;
        int k = 0;

        // We will compare the elements of both the arrays and add the smaller element
        // to the mix array to make the mix sorted
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        // It may be possible that one of the array is not completely traversed
        // Hence we will add the remaining elements
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
}
