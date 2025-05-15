// Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
// The following rules define a valid string:
// Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// Any right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
// '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 
// Example 1:
// Input: s = "()"
// Output: true

// Example 2:
// Input: s = "(*)"
// Output: true

// Example 3:
// Input: s = "(*))"
// Output: true
 
// Constraints:
// 1 <= s.length <= 100
// s[i] is '(', ')' or '*'.

class ValidParenthesisString {
    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stars = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            }
            else if(c == '*') {
                stars.push(i);
            }
            else{
                if(!stack.empty()){
                    stack.pop();
                }
                else if(!stars.empty()){
                    stars.pop();
                }
                else{
                    return false;
                }
            }
        }
        while(!stack.empty() && !stars.empty()){
            if(stack.pop() > stars.pop()){
                return false;
            }
        }
        return stack.empty();
    }
}
