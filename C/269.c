#include<stdio.h>

// do rotate right shift. assume 0 <= n < w
unsigned rotate_right(unsigned x, int n){
    int w = sizeof(int) << 3;
/*
 * unsigned mask = 1 << n;
    mask = (mask << 1) - 1;
    unsigned right = x & mask;
    unsigned left = x >> n;
    right <<= w - n - 1;
    right <<= 1;
    return left | right;
 */
    return (x >> n) | (x << (w-n-1) << 1);
}

int main(int argc, const char *argv[])
{
    printf("%x", rotate_right(0x12345678, 0));
    printf("\n");
    printf("%x", rotate_right(0x12345678, 20));
    return 0;
}
