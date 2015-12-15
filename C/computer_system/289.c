#include<stdio.h>

/*
 * float: s=1; k=8; n=23;
 *      bias = 2 ^ (k-1) - 1 = 127;
 *      minimum positive denormalized number:
 *          2 ^ (1-bias-n) = 2 ^ (-149);
 *      minmum positive normalized number:
 *          2 ^ (0-bias) * 2 = 2 ^ (-126);
 *      maximum positive normalized number:
 *          2 (2 ^ k - 2 - bias) = 2 ^ 127;
 */

float fpwr2(int x){
    // result exponent and fraction
    unsigned exp, frac;
    unsigned u;
    
    if(x < -149){
        // too small. return 0.0
        exp = 0;
        frac = 0;
    }else if(x < -126){
        // denormalized result
        exp = 0;
        frac = 1 << (x + 149);
    }else if(x < 128){
        // normalized result
        exp = x + 127;
        frac = 0;
    }else{
        // too big. return +00
        exp = 255;
        frac = 0;
    }

    // pack exp and frac into 32 bits
    u = exp << 23 | frac;

    // return as float
    return u2f(u);
}

