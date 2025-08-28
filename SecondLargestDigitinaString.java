// Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
// An alphanumeric string is a string consisting of lowercase English letters and digits.

// Example 1:
// Input: s = "dfa12321afd"
// Output: 2
// Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
  
// Example 2:
// Input: s = "abc1111"
// Output: -1
// Explanation: The digits that appear in s are [1]. There is no second largest digit. 
 
// Constraints:
// 1 <= s.length <= 500
// s consists of only lowercase English letters and digits.

class SecondLargestDigitinaString {
    public int secondHighest(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                int digit = ch - '0'; // Convert character to digit
                if (!list.contains(digit)) { // Avoid duplicates
                    list.add(digit);
                }
            }
        }
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        if(list.size() < 2) {
            return -1;
        }
        for(int i=0;i<list.size();i++) {
            int digit = list.get(i);
            if(digit > firstMax) {
                secondMax = firstMax;
                firstMax = digit;
            }
            else if(digit > secondMax && digit != firstMax) {
                secondMax = digit;
            }
        }
        if(secondMax == Integer.MIN_VALUE) {
            return -1;
        }
        else {
            return secondMax;
        }
    }
}
