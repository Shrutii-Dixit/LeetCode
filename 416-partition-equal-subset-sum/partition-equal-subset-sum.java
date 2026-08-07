class Solution {
    public boolean solve(int i, int target, int[] nums, Boolean[][]dp){
        if(target == 0) return true;

        if(i == nums.length) return false;

        //already calculated
        if(dp[i][target] != null) return dp[i][target];

        // not take
        boolean notTake = solve(i+1, target, nums, dp);

        // take
        boolean take = false;
        if(nums[i] <= target) take = solve(i+1, target-nums[i], nums, dp);

        dp[i][target] =  take || notTake;

        return dp[i][target];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int x : nums) sum += x;

        if(sum % 2 != 0) return false;

        int target  = sum / 2;

        Boolean[][] dp = new Boolean[nums.length][target+1];

        return solve(0, target, nums, dp);
    }
}