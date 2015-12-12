#include<stdio.h>

// clear all but least significant n bits of x.
int lower_bits(int x, int n){
    int mask = 1 << (n-1);
    mask = (mask << 1) - 1;
    return x&mask;
}

int main(int argc, const char *argv[])
{
    printf("%x", lower_bits(0xABCDEF00, 32));
    return 0;
}
