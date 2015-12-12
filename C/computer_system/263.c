#include<stdio.h>

int sra(int x, int k){
    // Perform shift logically
    int xsrl = (unsigned) x >> k;
    int w = sizeof(int) << 3;
    unsigned z = 1 << (w-k-1);
    unsigned mask = z - 1;
    unsigned right = mask & xsrl;
    // z = 0000 0100 0000, xsrl = 0000 0101 1101,       mask = 0000 0011 1111
    //                                                 ~mask = 1111 1100 0000
    // z & xsrl: sign position
    //   if x < 0
    //       0000 0100 0000, 1111 1011 1111 + 0000 0100 0000 = 1111 1111 1111
    //   else if x > 0
    //       0000 0000 0000, 1111 1111 1111 + 0000 0100 0000 = 0000 0011 1111
    unsigned left = ~mask & (~(z & xsrl) + z);
    return left | right;
}

unsigned srl(unsigned x, int k){
    // Perform shift arthmetically
    unsigned xsra = (int) x >> k;
    int w = sizeof(int) << 3;
    unsigned z = 2 << (w-k-1);
    return (z-1) & xsra;
}

int main(int argc, const char *argv[])
{
    printf("%d\n", sra(-16, 2));
    printf("%d\n", sra(16, 2));
    printf("%d\n", srl(16, 2));
    return 0;
}
