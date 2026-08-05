class Solution {
    public int myAtoi(String s) {

        int n = s.length();
        int i = 0;
        int sign = 1;

        //skip space
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Check sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-')
                sign = -1;
            i++;
        }

        long num = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            num = num * 10 + digit;

            if (sign == 1 && num > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (sign == -1 && -num < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        return (int) (sign * num);
    }
}