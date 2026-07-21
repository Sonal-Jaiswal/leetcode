class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        String t = "1" + s + "1";

        java.util.ArrayList<Character> type = new java.util.ArrayList<>();
        java.util.ArrayList<Integer> len = new java.util.ArrayList<>();

        int i = 0, m = t.length();
        while (i < m) {
            char c = t.charAt(i);
            int j = i;
            while (j < m && t.charAt(j) == c) j++;
            type.add(c);
            len.add(j - i);
            i = j;
        }

        int ans = ones;

        for (int k = 1; k + 1 < type.size(); k++) {
            if (type.get(k) == '1' &&
                type.get(k - 1) == '0' &&
                type.get(k + 1) == '0') {

                ans = Math.max(ans, ones + len.get(k - 1) + len.get(k + 1));
            }
        }

        return ans;
    }
}