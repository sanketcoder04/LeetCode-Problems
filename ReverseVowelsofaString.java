// Given a string s, reverse only all the vowels in the string and return it.
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

// Example 1:
// Input: s = "IceCreAm"
// Output: "AceCreIm"
// Explanation:
// The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

// Example 2:
// Input: s = "leetcode"
// Output: "leotcede"

// Constraints:
// 1 <= s.length <= 3 * 105
// s consist of printable ASCII characters.

class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        String vowels = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                vowels += ch;
            }
        }
        StringBuilder sb = new StringBuilder(vowels);
        String str = sb.reverse().toString();
        StringBuilder original = new StringBuilder(s);
        int index = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = original.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                original.replace(i, i+1, String.valueOf(str.charAt(index)));
                index++;
            }
        }
        return original.toString();
    }
}
