class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] ans = new int[m];

        // last[j] = word1 me word2[j] ka
        // last possible matching index
        int[] last = new int[m];

        Arrays.fill(last, -1);

        // Right se scan karke last positions find karo
        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        // Ek mismatch use kar sakte hain
        boolean canChange = true;

        j = 0;

        // Left se greedily smallest indices choose karo
        for (i = 0; i < n && j < m; i++) {

            // Exact match
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;

            }
            // Current character ko change karke use kar sakte hain
            else if (canChange &&
                     (j == m - 1 || i < last[j + 1])) {

                ans[j] = i;
                j++;

                canChange = false;
            }
        }

        // Pura word2 match nahi hua
        if (j < m) {
            return new int[0];
        }

        return ans;
    }
}