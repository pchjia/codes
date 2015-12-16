#include<stdio.h>

typedef unsigned float_bits;

// compite 0.5 * f. if f is NaN, then return f.
float_bits float_half(float_bits f){
    unsigned sign = f >> 31;
    unsigned exp = f >> 23 & 0xff;
    unsigned frac = f & 0x7fffff;
    unsigned bias = 2 ^ 7 - 1;
    unsigned E;

    if(exp == 0xff && frac == 0){
        // f is NaN
        return f;
    }

    if(exp == 0){
        return (sign << 31) | (exp << 23) | (frac >> 1);
    }else{
        E = exp - 1;
        return (sign << 31) | (exp << 23) | (frac >> 1);
    }
}

int main(int argc, const char *argv[])
{
    printf("%d", float_half(0x00000002));
    printf("\n");
    return 0;
}
