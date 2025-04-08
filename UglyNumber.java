// An ugly number is a positive integer which does not have a prime factor other than 2, 3, and 5.
// Given an integer n, return true if n is an ugly number.

// Example 1:
// Input: n = 6
// Output: true
// Explanation: 6 = 2 × 3
  
// Example 2:
// Input: n = 1
// Output: true
// Explanation: 1 has no prime factors.
  
// Example 3:
// Input: n = 14
// Output: false
// Explanation: 14 is not ugly since it includes the prime factor 7.
 
// Constraints:
// -231 <= n <= 231 - 1

class UglyNumber {
    // To check if an Number is Ugly or not,
    // 1. If the number is less than or equal to 0, it's not considered an ugly number.
    // 2. Divide the number by 2 as long as it is divisible by 2.
    // 3. Divide the number by 3 as long as it is divisible by 3.
    // 4. Divide the number by 5 as long as it is divisible by 5.
    // 5. If the resulting number is 1, then the original number is an ugly number because its prime factors are limited to 2, 3, and 5. Otherwise, it's not an ugly number.
    
    public boolean isUgly(int n) {
        if(n <= 0){
            return false;
        }
        while(n % 2 == 0){
            n /= 2;
        }
        while(n % 3 == 0){
            n /= 3;
        }
        while(n % 5 == 0){
            n /= 5;
        }
        return n == 1;
    }
}
