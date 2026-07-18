import java.util.Arrays;

class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int x = nums[0];
        int y = nums[nums.length - 1];
        return gcd(x,y);
    }

    public int gcd(int a, int b){
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}