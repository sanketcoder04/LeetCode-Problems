// A fancy string is a string where no three consecutive characters are equal.
// Given a string s, delete the minimum possible number of characters from s to make it fancy.
// Return the final string after the deletion. It can be shown that the answer will always be unique.

// Example 1:
// Input: s = "leeetcode"
// Output: "leetcode"
// Explanation:
// Remove an 'e' from the first group of 'e's to create "leetcode".
// No three consecutive characters are equal, so return "leetcode".
  
// Example 2:
// Input: s = "aaabaaaa"
// Output: "aabaa"
// Explanation:
// Remove an 'a' from the first group of 'a's to create "aabaaaa".
// Remove two 'a's from the second group of 'a's to create "aabaa".
// No three consecutive characters are equal, so return "aabaa".
  
// Example 3:
// Input: s = "aab"
// Output: "aab"
// Explanation: No three consecutive characters are equal, so return "aab".
 
// Constraints:
// 1 <= s.length <= 105
// s consists only of lowercase English letters.

class DeleteCharacterstoMakeFancyString {
    public String makeFancyString(String s) {
        if(s.length() < 3) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        int i = 1;
        while(i < sb.length() - 1) {
            char prev = sb.charAt(i - 1);
            char curr = sb.charAt(i);
            char next = sb.charAt(i + 1);

            if(prev == curr && curr == next) {
                sb.delete(i, i + 1);
            }
            else {
                i++;
            }
        }
        return sb.toString();
    }
}
