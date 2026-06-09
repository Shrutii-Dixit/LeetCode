class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        int n = ransomNote.length();
        for(int i=0; i<n; i++){
            freq[ransomNote.charAt(i) - 'a']++;
        }
        int m = magazine.length();
        for(int i=0; i<m; i++){
            freq[magazine.charAt(i) - 'a']--;
        }
        for(int i : freq){
            if(i > 0) return false;
        }
        return true;
    }
}