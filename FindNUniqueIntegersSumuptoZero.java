// Given an integer n, return any array containing n unique integers such that they add up to 0.

// Example 1:
// Input: n = 5
// Output: [-7,-1,1,3,4]
// Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
  
// Example 2:
// Input: n = 3
// Output: [-1,0,1]
  
// Example 3:
// Input: n = 1
// Output: [0]

// Constraints:
// 1 <= n <= 1000

class FindNUniqueIntegersSumuptoZero {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int count = 0;
        int index = 0;
        int num = 1;

        if(n % 2 == 0) {
            while(count < n) {
                ans[index] = num;
                index++;
                ans[index] = num * (-1);
                count += 2;
                num++;
                index++;
            }
        } 
        else {
            while(count < n - 1) {
                ans[index] = num;
                index++;
                ans[index] = num * (-1);
                count += 2;
                num++;
                index++;
            }
            ans[index] = 0;
        } 
        return ans;
    }
}
