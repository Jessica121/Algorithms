
public class Reader4 {
    /*
    ptr reads from the buf. maybe another ptr1 write to the buf4.
    when ptr2 reaches the buf4.end, read again from last ptr, until either buf4 is full or it reaches to n or reached the end of the buffer.
    */
    private char[] buf4 = new char[4];
    
    public int read(char[] buf, int n) {
        int ptr = 0, ptr1 = 0;
        // condition is && not ||
        while(ptr < buf.length && ptr < n) {
            ptr1 = read4(buf4);
            // if no more was read in the buffer, break. like "", 1.
            if(ptr1 == 0) break;
            for(int i = 0; i < ptr1; i++) {
                buf[ptr++] = buf4[i];
                // break when ptr reaches either of the bound.
                if(ptr == buf.length || ptr == n) break;
            }
        }
        return ptr;
    }
    
    int read4(char[] buf);
}
