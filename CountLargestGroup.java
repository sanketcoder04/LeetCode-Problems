// You are given an integer n.
// Each number from 1 to n is grouped according to the sum of its digits.
// Return the number of groups that have the largest size.

// Example 1:
// Input: n = 13
// Output: 4
// Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
// [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9].
// There are 4 groups with largest size.
  
// Example 2:
// Input: n = 2
// Output: 2
// Explanation: There are 2 groups [1], [2] of size 1.
 
// Constraints:
// 1 <= n <= 104

class CountLargestGroup {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int max = -1;

        for(int i=1;i<=n;i++) {
            int sum = getDigitSum(i);
            if(map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            }
            else {
                map.put(sum, 1);
            }
        }
        for(Integer key : map.keySet()) {
            int value = map.get(key);
            max = Math.max(value, max);
        }
        for(Integer key : map.keySet()) {
            int value = map.get(key);
            if(value == max) {
                count++;
            }
        }
        return count;
    }

    private int getDigitSum(int n) {
        int sum = 0;
        while(n != 0) {
            int rem = n % 10;
            sum += rem;
            n /= 10;
        }
        return sum;
    }
}
