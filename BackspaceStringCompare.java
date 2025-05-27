// Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
// Note that after backspacing an empty text, the text will continue empty.

// Example 1:
// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".
  
// Example 2:
// Input: s = "ab##", t = "c#d#"
// Output: true
// Explanation: Both s and t become "".
  
// Example 3:
// Input: s = "a#c", t = "b"
// Output: false
// Explanation: s becomes "c" while t becomes "b".
 
// Constraints:
// 1 <= s.length, t.length <= 200
// s and t only contain lowercase letters and '#' characters.

class BackspaceStringCompare {

    // First Approach

    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder tb = new StringBuilder(t);
      
        StringBuilder newS = modify(sb);
        StringBuilder newT = modify(tb);

        return newS.compareTo(newT) == 0;
    }

    private StringBuilder modify(StringBuilder str) {
        int index = 0;
        while(index < str.length()) {
            char ch = str.charAt(index);
            if(index == 0 && ch == '#') {
                str = str.deleteCharAt(index);
                index = 0;
                continue;
            }
            if(ch == '#') {
                str = str.deleteCharAt(index);
                str = str.deleteCharAt(index-1);
                System.out.println(str);
                index = 0;
            }
            else {
                index++;
            }
        }
        return str;
    }

    // Another Approach

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(stack.isEmpty() && ch == '#') {
                continue;
            }
            else if(!stack.isEmpty() && ch == '#') {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        String str1 = "";
        while(!stack.isEmpty()) {
            str1 += stack.pop();
        }

        for(char ch : t.toCharArray()) {
            if(stack.isEmpty() && ch == '#') {
                continue;
            }
            else if(!stack.isEmpty() && ch == '#') {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        String str2 = "";
        while(!stack.isEmpty()) {
            str2 += stack.pop();
        }
        return str1.equals(str2);
    }
}
