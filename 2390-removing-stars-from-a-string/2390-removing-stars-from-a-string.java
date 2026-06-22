class Solution {
    public String removeStars(String s) {
        StringBuilder st = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                st.deleteCharAt(st.length() - 1);
            } else {
                st.append(c);
            }
        }

        return st.toString();
    }
}
//optimised solution
// class Solution {
//     public String removeStars(String s) {
//         char[] res = new char[s.length()];
//         int top = 0;

//         for (char ch : s.toCharArray()) {
//             if (ch == '*') {
//                 top--;
//             } else {
//                 res[top++] = ch;
//             }
//         }

//         return new String(res, 0, top);
//     }
// }