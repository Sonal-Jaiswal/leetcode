class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            // Move left pointer until it finds a vowel
            while (left < right && !"aeiouAEIOU".contains(arr[left] + "")) {
                left++;
            }

            // Move right pointer until it finds a vowel
            while (left < right && !"aeiouAEIOU".contains(arr[right] + "")) {
                right--;
            }

            // Swap vowels
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }
}
