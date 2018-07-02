
public class Read4II {
    /*
    
    read 4 save in the buffer. keep a ptr indicating where the array was read.
    if reach the end, read again, reset the pointer.
    if ptr reach n or the end of array, stop. return. if ptr4 reach end, read again, reset ptr4 to 0.
    if i == 0 read. else pick up where it left from last time. if i == 4, reset to 0.
    
    */
    private char[] buf4 = new char[4];
    // buf4Len needs to be put outside as if the next call pick up from where it left, buf4Len will be 0 wont be transfered.
    // only changeis when ptr4 reaches the end. so need to be global too.
    private int ptr4 = 0, buf4Len = 0;
    
    public int read(char[] buf, int n) {
        int ptr = 0;
        while(ptr < buf.length && ptr < n) {
            if(ptr4 == 0) {
                buf4Len = read4(buf4);
                if(buf4Len == 0) break;
            }
            while(ptr4 < buf4Len && ptr < buf.length && ptr < n) {
                buf[ptr++] = buf4[ptr4++];
            }
            if(ptr4 == buf4Len) ptr4 = 0;
        }
        return ptr;
    }
    
    int read4(char[] buf);
}
