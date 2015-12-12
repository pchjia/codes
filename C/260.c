#include<stdio.h>

unsigned put_byte(unsigned x, unsigned char b, int i){
       return (x & ~(0xff<<(i<<3))) | b << (i<<3); 
}

int get_msb(int x){
    int shift_val = (sizeof(int)-1)<<3;
    int xright = x >> shift_val;
    return xright & 0xff;
}

int main(int argc, const char *argv[]){
    unsigned x = 0x12345678;
    unsigned char b = 0xab;
    printf("%x", put_byte(x, b, 2));
    printf("\n");
    printf("%x", get_msb(0x12345678));
    return 0;
}
