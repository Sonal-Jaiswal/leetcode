class Solution {
    public int numberOfSubstrings(String s) {

int a = -1, b = -1, c = -1;
int ans = 0;

for (int i = 0; i < s.length(); i++) {
    char ch = s.charAt(i);

    if (ch == 'a')
        a = i;
    else if (ch == 'b')
        b = i;
    else
        c = i;

    int min = Math.min(a, Math.min(b, c));

    if (min != -1)
        ans += min + 1;
}

return ans;
    
}}