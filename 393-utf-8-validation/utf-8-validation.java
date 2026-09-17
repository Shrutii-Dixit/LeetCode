class Solution {
    public boolean validUtf8(int[] data) {

        int bytes = 0;

        for (int num : data) {

            // If this is a continuation byte, we must be inside a multi-byte character
            if (bytes == 0) {

                if ((num & 0x80) == 0) {
                    // 0xxxxxxx → 1 byte
                    bytes = 0;
                } 
                else if ((num & 0xE0) == 0xC0) {
                    // 110xxxxx → 2 bytes
                    bytes = 1;
                } 
                else if ((num & 0xF0) == 0xE0) {
                    // 1110xxxx → 3 bytes
                    bytes = 2;
                } 
                else if ((num & 0xF8) == 0xF0) {
                    // 11110xxx → 4 bytes
                    bytes = 3;
                } 
                else {
                    return false;
                }

            } else {

                // Continuation byte must be 10xxxxxx
                if ((num & 0xC0) != 0x80) {
                    return false;
                }

                bytes--;
            }
        }

        return bytes == 0;
    }
}