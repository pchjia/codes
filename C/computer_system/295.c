#include<limits.h>

typedef unsigned float_bits;

float_bits float_i2f(int i)
{
    unsigned sign, exp, frac;
    unsigned leftmost, rightmost, t;
    int w = sizeof(int) << 3;

    if (i == 0)
        return i;

    sign = i > 0 ? 0 : 1;
    if (sign)
        i = ~i + 1;
    for (rightmost = 1, t = 1 < (w-1); (t & i) != t; t >>= 1)
        rightmost++;
    leftmost = w - rightmost;
    exp = leftmost + 127;

    int shift;
    if (leftmost > 23) {
        shift = leftmost - 23;
        int mask = ((1 << shift) - 1) & i;
        int half = 1 << (shift - 1);
        int hide = 1 << shift;
        int round = mask>half || (mask==half && (i&hide)==hide);
        frac = (i >> shift) & 0x7FFFFF;
            if (frac == 0x7FFFFF && round == 1)
                frac = 0, exp++;
            else
                frac += round;
    } else {
        shift = 23 - leftmost;
        frac = (i << shift) & 0x7FFFFF;
    }
    return (sign << 31) | (exp << 23) | frac;
}
