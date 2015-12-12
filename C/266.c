#include<stdio.h>

// generate mask indicating leftmost 1 in x.
int leftmost_one(unsigned x){
    x |= x >> 1;
    x |= x >> 2;
    x |= x >> 4;
    x |= x >> 8;
    x |= x >> 16;
    return (int)((x+1)>>1);
}

int main(int argc, const char *argv[])
{
    printf("%x", leftmost_one(0x1011010));
    return 0;
}
