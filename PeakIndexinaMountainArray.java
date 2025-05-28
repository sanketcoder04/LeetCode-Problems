// You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
// Return the index of the peak element.
// Your task is to solve it in O(log(n)) time complexity.

// Example 1:
// Input: arr = [0,1,0]
// Output: 1

// Example 2:
// Input: arr = [0,2,1,0]
// Output: 1

// Example 3:
// Input: arr = [0,10,5,2]
// Output: 1

// Constraints:
// 3 <= arr.length <= 105
// 0 <= arr[i] <= 106
// arr is guaranteed to be a mountain array.

class PeakIndexinaMountainArray {

    // For a mountain array suppose 
    // arr = [1,2,3,4,5,6,5,4,3];

    //      6      => Element need to be return which is the max element
    //     5 5
    //    4   4
    //   3     3 
    //  2
    // 1

    // Now we need to search the element which is maximum in the array 
    // As we can see that Their are two part of the Array which is sorted in decreasing order and increasing order
    // Now we calculate mid, 
    //     if(arr[mid] < arr[mid+1]) => mid lies in increasing part and their is possible answer in right side
    //     if(arr[mid] > arr[mid+1]) => mid lies in decreasing part and their is possible answer in left side
    // After that we need to find for which mid,
    //     arr[mid-1] < arr[mid] > arr[mid+1] => return mid

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {  // if(start == end) return mid;
                return mid;
            }
            if(arr[mid] < arr[mid + 1]) {  //Increasing Part of Array
                start = mid + 1;  //search from right hand side
            }
            if(arr[mid] > arr[mid + 1]) {  //Decreasing Part of Array
                end = mid;      //search from left hand side
            }
        }
        return -1;
    }
}
