class Solution {
    int sum = 0;
    
    public void solve(int index, int xor, int[] nums){

        if(index == nums.length){
            sum += xor;
            return;
        }
        //take
        solve(index + 1, xor ^ nums[index], nums);

        //not take
        solve(index + 1, xor, nums);
    }

    public int subsetXORSum(int[] nums) {
        solve(0, 0, nums);
        return sum;
    }
}