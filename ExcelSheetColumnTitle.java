// Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
// For example:
// A -> 1
// B -> 2
// C -> 3
// ...
// Z -> 26
// AA -> 27
// AB -> 28 
// ...
 
// Example 1:
// Input: columnNumber = 1
// Output: "A"
  
// Example 2:
// Input: columnNumber = 28
// Output: "AB"
  
// Example 3:
// Input: columnNumber = 701
// Output: "ZY"
 
// Constraints:
// 1 <= columnNumber <= 231 - 1

class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            int rem = columnNumber % 26;
            if (rem == 0) {
                sb.insert(0, 'Z');
                columnNumber = (columnNumber / 26) - 1;
            } else {
                char c = (char) ((rem - 1) + 'A');
                sb.insert(0, c);
                columnNumber = columnNumber / 26;
            }
        }
        return sb.toString();
    }
}
