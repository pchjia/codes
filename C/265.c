#include<stdio.h>

// return 1 when x contains an even number of 1s; 0 otherwise  assume w=32
int even_ones(unsigned x){
    x ^= x >> 16;
    x ^= x >> 8;
    x ^= x >> 4;
    x ^= x >> 2;
    x ^= x >> 1;
    return !(x&1);
}

int main(int argc, const char *argv[])
{
    printf("%d", even_ones(0xff));
    printf("\n");
    printf("%d", even_ones(0x7f));
    return 0;
}
