class Solution:
    def majorityElement(self, nums: List[int]) -> int:
       dic = {}
       length = len(nums)
       for n in nums:
        if n in dic:
            dic[n] = dic[n] + 1
        else:
            dic[n] = 1
        


        for item in dic.keys():
            if dic[item] > length//2:
                return item
        