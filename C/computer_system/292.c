#include<stdio.h>

typedef unsigned float_bits;

// compute -f. if f is Nan, them return f;

float_bits float_absval(float_bits f){
    unsigned sign = f >> 31;
    unsigned exp = f >> 23 & 0xff;
    unsigned frac = f & 0x7fffff;

    if(exp == 0xff && frac != 0){
        // f is NaN
        return f;
    }

    return ((~sign)<<31) | (exp << 23) | frac;
}

int main(int argc, const char *argv[])
{
    printf("%d", float_absval(0x80000001));
    return 0;
}
