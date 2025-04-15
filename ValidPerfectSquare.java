// Given a positive integer num, return true if num is a perfect square or false otherwise.
// A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.
// You must not use any built-in library function, such as sqrt.

// Example 1:
// Input: num = 16
// Output: true
// Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
  
// Example 2:
// Input: num = 14
// Output: false
// Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
 
// Constraints:
// 1 <= num <= 231 - 1

class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num == 1) {
            return true;
        }
        return check(1, num / 2, num);
    }

    public boolean check(long start, long end, long square) {
        if (start > end) {
            return false;
        }
        long mid = start + (end - start) / 2;
        long midSquared = mid * mid;
        if (midSquared == square) {
            return true;
        } 
        else if (midSquared > square) {
            return check(start, mid - 1, square);
        } 
        else {
            return check(mid + 1, end, square); 
        }
    }
}
