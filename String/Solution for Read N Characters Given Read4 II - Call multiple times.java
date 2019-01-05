/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    char[] pre = new char[4];
    int front = 0, rear = -1;
    
//     public int read(char[] buf, int n) {
//         boolean flag = true;
//         int total = 0;
//         char[] tmp = new char[4];
        
//         while (front <= rear && n > total) {
//             buf[total++] = pre[front++];
//         }
//         if (front > rear) {
//             front = 0;
//             rear = -1;
//         }
//         if (n == total) return n;
        
//         while (flag) {
//             int count = read4(tmp);
//             int used = Math.min(count, n - total);
//             if (used < 4) flag = false;
//             for (int i = 0; i < used; i++) {
//                 buf[total++] = tmp[i];
//             }
//             for (int i = used; i < count; i++) {
//                 pre[++rear] = tmp[i];
//             }
//         }
//         return total;
//     }

    
    char[] tmp = new char[4];
    int size = -1, index = 0;
    
    public int read(char[] buf, int n) {
        int count = 0;
        while (count < n && size != 0) {
            if (index < size) {
                buf[count++] = tmp[index++];
            } else {
                size = read4(tmp);
                index = 0;
            }
        }
        return count;
    }
    
    
}