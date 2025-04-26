// You are given a license key represented as a string s that consists of only alphanumeric characters and dashes. The string is separated into n + 1 groups by n dashes. You are also given an integer k.
// We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. 
// Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.
// Return the reformatted license key.

// Example 1:
// Input: s = "5F3Z-2e-9-w", k = 4
// Output: "5F3Z-2E9W"
// Explanation: The string s has been split into two parts, each part has 4 characters.
// Note that the two extra dashes are not needed and can be removed.
  
// Example 2:
// Input: s = "2-5g-3-J", k = 2
// Output: "2-5G-3J"
// Explanation: The string s has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
 
// Constraints:
// 1 <= s.length <= 105
// s consists of English letters, digits, and dashes '-'.
// 1 <= k <= 104

class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        String[] arr = s.split("-");
        String str = "";

        for(int i=0;i<arr.length;i++) {
            str += arr[i].toUpperCase();
        }
        char[] strings = str.toCharArray();
        int groups = strings.length / k;
        int first = strings.length % k;
        ArrayList<String> list = new ArrayList<>();
        int check = 1;
        int start = 0;

        if(first != 0) {
            String fs = "";
            for(int i=0;i<first;i++) {
                fs += strings[i];
            }
            list.add(fs);
            start = first;
        }
        while(check <= groups) {
            String elem = "";
            for(int i=start;i<start+k;i++) {
                elem += strings[i];
            }
            list.add(elem);
            start += k;
            check++;
        }
        String result = "";
        for(int i=0;i<list.size();i++) {
            result += list.get(i);
            if(i != list.size()-1) {
                result += "-";
            }
        }
        return result;
    }
}
