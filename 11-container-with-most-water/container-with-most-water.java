class Solution {
    public int maxArea(int[] height) {
       int currArea = 0;
       int maxiArea = 0;
       int left = 0;
       int right = height.length - 1;
       while(left<right){
        int indexDiff = right - left;
        int minHeight = Math.min(height[left],height[right]);
        currArea = indexDiff * minHeight;
        maxiArea = Math.max(maxiArea,currArea);
        if(height[left]<height[right]) left++;
        else right--;
       }
       return maxiArea;
    }
}