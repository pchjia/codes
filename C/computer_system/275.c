#include<stdio.h>

int signed_high_prod(int x, int y){}

// already exits "int signed_high_prod(int x, int y)";
unsigned unsigned_high_prod(unsigned x, unsigned y){
    int w = sizeof(int) << 3;
    int x_sign = (int)x >> (w-1);
    int y_sign = (int)y >> (w-1);
    return signed_high_prod(x, y) + x & y_sign + y & x_sign;
}
