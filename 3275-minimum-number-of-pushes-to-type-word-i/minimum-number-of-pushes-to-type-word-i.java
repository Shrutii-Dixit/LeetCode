class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        if(n <= 8) return n;
        int count = 8;
        if(n > 24){
             count += (n - 24)*4;
             n = 24;
        }
        if(n > 16){
            count += (n - 16)*3;
            n = 16;
        }
        if(n > 8){
            count += (n - 8)*2;
            n = 8;
        }
        return count;

    }
}