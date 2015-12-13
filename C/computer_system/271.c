#include<stdio.h>

// declarition of data where 4 bytes are packed into an unsigned
typedef unsigned packed_t;

// extract byte from word. return as signed integer
int xbyte(packed_t word, int bytenum){
    int shift = bytenum << 3;
    int w = (sizeof(int) - 1) << 3;
    int ans = word << (w - shift);
    // return (int) (word << ((3-bytenum) << 3)) >> 24;
    return ans >> w;
}

int main(int argc, const char *argv[])
{
    printf("%x", xbyte(0xa00f, 1));
    return 0;
}
