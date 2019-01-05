/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int total = 0;
        boolean flag = true;
        while (flag) {
            int count = read4(tmp);
            count = Math.min(count, n - total);
            if (count < 4) flag = false;
            for (int i = 0; i < count; i++) {
                buf[total++] = tmp[i];
            }
        }
        return total;
    }
}