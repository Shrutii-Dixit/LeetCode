class Solution {
    public int getLucky(String s, int k) {
        int n = s.length();
        int sum = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            int value = ch - 'a' + 1;
            if(value < 10) sum += value;
            else {
                sum += (value % 10) + (value/10);
            }
        }
        int finall = sum;
        if(k>1){
            int temp = sum;
            for(int j=1; j<k; j++){
                finall = 0;
                while(temp>0){
                    finall += temp % 10;
                    temp /= 10;
                }
                temp = finall;
            }
        }
        return finall;
    }
}