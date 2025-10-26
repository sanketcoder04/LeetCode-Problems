// Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). 
// If the character ch does not exist in word, do nothing.
// For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
// Return the resulting string.

// Example 1:
// Input: word = "abcdefd", ch = "d"
// Output: "dcbaefd"
// Explanation: The first occurrence of "d" is at index 3. 
// Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
  
// Example 2:
// Input: word = "xyxzxe", ch = "z"
// Output: "zxyxxe"
// Explanation: The first and only occurrence of "z" is at index 3.
// Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
  
// Example 3:
// Input: word = "abcd", ch = "z"
// Output: "abcd"
// Explanation: "z" does not exist in word.
// You should not do any reverse operation, the resulting string is "abcd".
 
// Constraints:
// 1 <= word.length <= 250
// word consists of lowercase English letters.
// ch is a lowercase English letter.

class ReversePrefixofWord {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder(word);

        for(int i=0;i<word.length();i++){
            // If the character is at the end of the word, return the reverse word
            if(sb.charAt(i) == ch && i == sb.length()-1){
                return sb.reverse().toString();
            }
            // If the character is at the front of the word, return the word as it is
            if(sb.charAt(i) == ch && i == 0){
                return word;
            }
            // Find out the index of ch and reverse the first part append the second and return new word
            if(sb.charAt(i) == ch){
                StringBuilder first = new StringBuilder(sb.substring(0, i + 1)).reverse();
                StringBuilder second = new StringBuilder(sb.substring(i + 1));
                StringBuilder newStr = new StringBuilder(first).append(second);
                return newStr.toString();
            }
        }
        return word;
    }
}
