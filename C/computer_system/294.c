#include<stdio.h>

typedef unsigned float_bits;

// compute 2*f. if f is NaN, then return f.
float_bits float_twice(float_bits f){
    unsigned sign = f >> 31;
    unsigned exp = f >> 23 & 0xff;
    unsigned frac = f & 0x7fffff;

    if(exp == 0xff && frac == 0){
        // f is NaN
        return f;
    }

    if(exp != 0xff && exp != 0){
        exp += 1;
    }else if(exp == 0xff){
        exp = 0xff;
        frac = 0;
    }else if(exp == 0 && (frac >> 22) == 0){
        frac =<< 1;
    }else if(exp == 0 && (frac >> 22) == 1){
        exp += 1;
    }

    return (sign << 31) | (exp << 23) | frac;
}
