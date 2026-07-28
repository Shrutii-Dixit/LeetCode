class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            int temp = nums[i];
            if(!map.containsKey(temp)) map.put(temp,i);
            else{
                int val = map.get(temp);
                if((i - val) <= k) return true;
                else map.put(temp,i);
            }
        }
        return false;
    }
}