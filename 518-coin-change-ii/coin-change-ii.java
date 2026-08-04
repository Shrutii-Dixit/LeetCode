class Solution {
    public int solve(int index, int amount, int[] coins, Integer[][] dp){
        //Valid Combo
        if(amount == 0) return 1;

        //Invalid Combo
        if(index == coins.length) return 0;

        if (dp[index][amount] != null) return dp[index][amount];

        //Skip Index
        int notTake = solve(index+1, amount, coins, dp);

        //Take
        int take = 0;
        if(amount >= coins[index]){
            take = solve(index, amount-coins[index], coins, dp);
        }

        
        dp[index][amount] = take + notTake;

        return dp[index][amount];
    }
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount+1];

        return solve(0, amount, coins,dp);
    }
}