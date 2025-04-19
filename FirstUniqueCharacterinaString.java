// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

// Example 1:
// Input: s = "leetcode"
// Output: 0
// Explanation:
// The character 'l' at index 0 is the first character that does not occur at any other index.

// Example 2:
// Input: s = "loveleetcode"
// Output: 2

// Example 3:
// Input: s = "aabb"
// Output: -1

// Constraints:
// 1 <= s.length <= 105
// s consists of only lowercase English letters.

class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(Character ch : s.toCharArray()) {
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
            else {
                map.put(ch, 1);
            }
        }
        Character item = null;
        for(Character key : map.keySet()) {
            if(item != null) {
                break;
            }
            if(map.get(key) == 1) {
                item = key;
            }
        }
        if(item == null) {
            return -1;
        }
        for(int i=0;i<s.length();i++) {
            if(item != null && s.charAt(i) == item) {
                return i;
            }
        }
        return -1;
    }
}
