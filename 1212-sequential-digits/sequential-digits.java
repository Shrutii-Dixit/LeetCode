class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> result = new ArrayList<>();

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();

        for(int len = lowLen; len<= highLen; len++){
            int i = 0;
            int j = len;
            while(j<=9){
                int num = Integer.parseInt(digits.substring(i,j));
                if(num>=low && num<=high) result.add(num);

                i++;
                j++;
            }
        }
        return result;
    }
}
