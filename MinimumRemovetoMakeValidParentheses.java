// Given a string s of '(' , ')' and lowercase English characters.
// Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
// Formally, a parentheses string is valid if and only if:
// It is the empty string, contains only lowercase characters, or
// It can be written as AB (A concatenated with B), where A and B are valid strings, or
// It can be written as (A), where A is a valid string.
 
// Example 1:
// Input: s = "lee(t(c)o)de)"
// Output: "lee(t(c)o)de"
// Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
  
// Example 2:
// Input: s = "a)b(c)d"
// Output: "ab(c)d"
  
// Example 3:
// Input: s = "))(("
// Output: ""
// Explanation: An empty string is also valid.
 
// Constraints:
// 1 <= s.length <= 105
// s[i] is either '(' , ')', or lowercase English letter.

class MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        char ch[] = s.toCharArray();
        int count = 0;

        //Check from Left to Right 
        //If ch == '(' count++
        //If ch == ')' check if previously a '(' occured or not if yes then count-- else replace with 0
        for(int i=0;i<ch.length;i++) {
            if(ch[i] == '(') {
                count++;
            }
            if(ch[i] == ')') {
                if(count > 0) {
                    count--;
                }
                else {
                    ch[i] = '0';
                }
            }
        }
        // Same thing do from right to left as previous
        count = 0;
        for(int i=ch.length-1;i>=0;i--) {
            if(ch[i] == ')') {
                count++;
            }
            if(ch[i] == '(') {
                if(count > 0) {
                    count--;
                }
                else {
                    ch[i] = '0';
                }
            }
        }
        //Make a StringBuilder and Traverse the array if somehow 0 occured continue the case and append to the String
        StringBuilder sb = new StringBuilder();
        for(char c : ch) {
            if(c != '0') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
