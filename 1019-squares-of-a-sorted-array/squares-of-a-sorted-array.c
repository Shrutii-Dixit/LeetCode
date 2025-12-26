/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* sortedSquares(int* nums, int numsSize, int* returnSize) {
    int* result = (int*)malloc(numsSize * sizeof(int));
    int left=0, right=numsSize-1, mov=numsSize-1;
    while(left <= right){
        if(abs(nums[left]) > abs(nums[right])){
            result[mov]=nums[left]*nums[left];
            left++;
        }
        else{
            result[mov]=nums[right]*nums[right];
            right--;
        }
        mov--;
    }
    *returnSize = numsSize;
    return result;
}