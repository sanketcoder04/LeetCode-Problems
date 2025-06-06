// In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
// Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.

// Example 1:
// Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
// Output: true
// Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
  
// Example 2:
// Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
// Output: false
// Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
  
// Example 3:
// Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
// Output: false
// Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 
// Constraints:
// 1 <= words.length <= 100
// 1 <= words[i].length <= 20
// order.length == 26
// All characters in words[i] and order are English lowercase letters.

class VerifyinganAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            // If any adjacent pair is out of order return false
            if (!checking(words[i], words[i + 1], order)) {
                return false;
            }
        }
        return true;
    }

    private boolean checking(String first, String second, String order) {
        int minLength = Math.min(first.length(), second.length());

        for (int i=0;i<minLength;i++) {
            char ch1 = first.charAt(i);
            char ch2 = second.charAt(i);

            if (ch1 != ch2) {
                // Compare order index
                if (order.indexOf(ch1) < order.indexOf(ch2)) {
                    return true; 
                } 
                else {
                    return false; 
                }
            }
        }
        // Handle the case where words are of different lengths
        return first.length() <= second.length();
    }
}
