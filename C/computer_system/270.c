#include<stdio.h>

// return 1 when x can be represented as an n-bit, 2's complement number; 0 otherwise  assume 1 <= n <= w
int fits_bits(int x, int n){
    x = x >> (n-1);
    // return (x==0) || (x==-1);
    return !x || !(~x);
}

int main(int argc, const char *argv[])
{
    printf("%d", fits_bits(0xffffffff, 8));
    return 0;
}
