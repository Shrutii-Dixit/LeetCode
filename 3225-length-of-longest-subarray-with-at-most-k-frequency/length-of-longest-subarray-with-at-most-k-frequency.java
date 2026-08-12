class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            int x = nums[right];

            map.put(x, map.getOrDefault(x, 0) + 1);

            while (map.get(x) > k) {
                int leftElement = nums[left];

                map.put(leftElement, map.get(leftElement) - 1);

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}