class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[Math.min(nums1.length, nums2.length)];

        for(int i=0; i<nums1.length; i++){

            if(!map.containsKey(nums1[i])) map.put(nums1[i], 1);

            else{
                int freq = map.get(nums1[i]);
                map.put(nums1[i], freq+1);
            }
        }

        int j = 0;
        for(int i=0; i<nums2.length; i++){

            if(map.containsKey(nums2[i])){

                int freq = map.get(nums2[i]);

                if(freq > 0){
                     ans[j++] = nums2[i];
                     map.put(nums2[i], freq-1);
                }  
            } 
        }
        return Arrays.copyOf(ans, j);
    }
}