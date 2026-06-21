class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n];

        long curr = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                curr++;
            } else if (c == '*') {
                curr = Math.max(0, curr - 1);
            } else if (c == '#') {
                curr = Math.min((long) 1e18, curr * 2);
            }

            len[i] = curr;
        }

        if (k >= curr) return '.';

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            long before = (i == 0) ? 0 : len[i - 1];

            if (c >= 'a' && c <= 'z') {
                if (k == before) {
                    return c;
                }
            } else if (c == '*') {
                // backward: length increased by 1
            } else if (c == '#') {
                long oldLen = before;

                if (k >= oldLen) {
                    k -= oldLen;
                }
            } else if (c == '%') {
                long L = before;
                if (L > 0) {
                    k = L - 1 - k;
                }
            }
        }

        return '.';
    }
}



// class Solution {
//     public char processStr(String s, long k) {
        
//         StringBuilder st = new StringBuilder();

//         for(char c: s.toCharArray()){
//             if(c>='a' && c<='z')
//                 st.append(c);
//             else if(c=='*'){
//                 if(st.length()>0)
//                     st.deleteCharAt(st.length()-1);
//             }else if(c=='#')
//                 st.append(st.toString());
//             else if(c=='%')
//                 st.reverse();
//         }

//         return st.charAt((int) k);
//         // char ans[] =st.toString().toCharArray();
//         // return ans[(int) k];
//     }
// }