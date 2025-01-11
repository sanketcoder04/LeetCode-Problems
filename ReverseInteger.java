// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
  
// Example 1:
// Input: x = 123
// Output: 321
  
// Example 2:
// Input: x = -123
// Output: -321
  
// Example 3:
// Input: x = 120
// Output: 21
 
// Constraints:
// -231 <= x <= 231 - 1

class ReverseInteger {
    public int reverse(int x) {
        if(x < Integer.MIN_VALUE || x > Integer.MAX_VALUE){
            return 0;
        }
        int num = 0;
        int result = 0;
        while(x != 0){
            int rem = x % 10;
            result = num * 10 + rem;
            if((result - rem) / 10 != num){
                return 0;
            }
            num = result;
            x = x / 10;
        }
        return result;
    }
}
