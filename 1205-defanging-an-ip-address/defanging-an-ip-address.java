class Solution {
    public String defangIPaddr(String address) {
        int n = address.length();
        StringBuilder finall = new StringBuilder();
        for(int i=0; i<n; i++){
            char ch = address.charAt(i);
            if(ch != '.') finall.append(ch);
            else finall.append("[.]");
        }
        return finall.toString();
    }
}