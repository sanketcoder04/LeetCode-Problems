// Given two string arrays words1 and words2, return the number of strings that appear exactly once in each of the two arrays.

// Example 1:
// Input: words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
// Output: 2
// Explanation:
// - "leetcode" appears exactly once in each of the two arrays. We count this string.
// - "amazing" appears exactly once in each of the two arrays. We count this string.
// - "is" appears in each of the two arrays, but there are 2 occurrences of it in words1. We do not count this string.
// - "as" appears once in words1, but does not appear in words2. We do not count this string.
// Thus, there are 2 strings that appear exactly once in each of the two arrays.
  
// Example 2:
// Input: words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
// Output: 0
// Explanation: There are no strings that appear in each of the two arrays.
  
// Example 3:
// Input: words1 = ["a","ab"], words2 = ["a","a","a","ab"]
// Output: 1
// Explanation: The only string that appears exactly once in each of the two arrays is "ab".
 
// Constraints:
// 1 <= words1.length, words2.length <= 1000
// 1 <= words1[i].length, words2[j].length <= 30
// words1[i] and words2[j] consists only of lowercase English letters.

class CountCommonWordsWithOneOccurrence {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = createTable(words1);
        HashMap<String, Integer> map2 = createTable(words2);

        Set<String> set1 = map1.keySet();
        Set<String> set2 = map2.keySet();
        set1.retainAll(set2);
        return set1.size();
    }

    private HashMap<String, Integer> modify(HashMap<String, Integer> map) {
        for(String key : map.keySet()) {
            if(map.get(key) > 1) {
                map.remove(key);
            }
        }
        return map;
    }

    private HashMap<String, Integer> createTable(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) {
            if(!map.containsKey(word)) {
                map.put(word, 1);
            }
            else {
                map.put(word, map.get(word) + 1);
            }
        }
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() > 1) {
                iterator.remove();
            }
        }
        return map;
    }
}
