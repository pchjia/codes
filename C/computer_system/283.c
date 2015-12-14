#include<stdio.h>

// convert float to unsigned
int f2u(float x);

// return 1 if x > y; 0 otherwise
int float_ge(float x, float y){
    unsigned ux = f2u(x);
    unsigned uy = f2u(y);

    // get te sign bits
    unsigned sx = ux >> 31;
    unsigned xy = uy >> 31;

    // give an expression using only ux, uy, sx, and sy
    return (ux == uy) ||(~sx & uy) || (!ux && ux > uy) || (ux && ux < uy);
}
