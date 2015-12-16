#include<stdio.h>

typedef unsigned float_bits;

// compute (int)f
// if conversion causes overflow or f is NaN, return 0x80000000
int float_f2i(float_bits f){
    unsigned sign = f >> 31;
    unsigned exp = f >> 23 & 0xff;
    unsigned frac = f & 0x7fffff;
    unsigned bias = 2 ^ 7 -1;
    unsigned E = exp - bias;

    if(exp == 0xff){
        return 0x80000000;
    }

    if(E >= 31u){
        return 0x80000000;
    }

    int shift;
    if(E > 23){
        shift = E - 23;
        frac = (1 << E) + (frac << shift);
    }else{
        shift = 23 - E;
        frac = (1 << E) + (frac >> shift);
    }

    if(sign){
        frac = ~frac + 1;
    }

    return frac
}
