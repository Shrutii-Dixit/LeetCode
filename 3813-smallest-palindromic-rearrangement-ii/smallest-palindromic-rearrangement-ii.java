class Solution {
    private static final long LIMIT = 1_000_001L;

    public String smallestPalindrome(String s, int k) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;

        int[] half = new int[26];
        String mid = "";
        for (int i = 0; i < 26; i++) {
            half[i] = cnt[i] / 2;
            if ((cnt[i] & 1) == 1) {
                mid = String.valueOf((char) ('a' + i));
            }
        }

        if (countWays(half) < k) return "";

        StringBuilder left = new StringBuilder();

        while (true) {
            int rem = 0;
            for (int x : half) rem += x;
            if (rem == 0) break;

            for (int i = 0; i < 26; i++) {
                if (half[i] == 0) continue;

                half[i]--;
                long ways = countWays(half);

                if (ways >= k) {
                    left.append((char) ('a' + i));
                    break;
                } else {
                    k -= ways;
                    half[i]++;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);
        ans.append(mid);
        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    private long countWays(int[] half) {
        int total = 0;
        for (int x : half) total += x;

        long res = 1;

        for (int x : half) {
            if (x == 0) continue;
            res *= nCr(total, x);
            if (res >= LIMIT) return LIMIT;
            total -= x;
        }

        return Math.min(res, LIMIT);
    }

    private long nCr(int n, int r) {
        if (r > n) return 0;
        r = Math.min(r, n - r);

        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - i + 1) / i;
            if (res >= LIMIT) return LIMIT;
        }

        return res;
    }
}
