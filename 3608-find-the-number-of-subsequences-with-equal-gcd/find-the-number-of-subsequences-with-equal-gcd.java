class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][][] dp;
    private int[] nums;
    private int n;

    public int subsequencePairCount(int[] nums) {
        this.nums = nums;
        this.n = nums.length;

        dp = new int[n][201][201];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 200; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return dfs(0, 0, 0);
    }

    private int dfs(int idx, int g1, int g2) {
        if (idx == n) {
            return (g1 == g2 && g1 != 0) ? 1 : 0;
        }

        if (dp[idx][g1][g2] != -1) {
            return dp[idx][g1][g2];
        }

        long ans = dfs(idx + 1, g1, g2);

        ans += dfs(idx + 1,
                g1 == 0 ? nums[idx] : gcd(g1, nums[idx]),
                g2);

        ans += dfs(idx + 1,
                g1,
                g2 == 0 ? nums[idx] : gcd(g2, nums[idx]));

        ans %= MOD;

        return dp[idx][g1][g2] = (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}