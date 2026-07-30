class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        int i = (int)Math.pow(2, n-1);
        if(k <= i/2){
            return kthGrammar(n-1, k);
        }
        else{
            return (kthGrammar(n-1, (k - i/2)) ^ 1);
        }
    }
}