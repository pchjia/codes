#include<stdio.h>

int mul5div8(int x){
    int x0 = x & 1;
    int x2 = (x & 4) >> 2;
    int w = sizeof(int) << 3;
    int x_sign = x >> (w-1);
    int x_carry = x & 0x7;
    int ans = (x >> 3) + (x >> 1);
    ans += x0 & x2;
    ans += x_sign && x_carry;
    return ans;
}

int main(int argc, const char *argv[])
{
    printf("%d", mul5div8(8));
    printf("\n");
    printf("%d", mul5div8(-8));
    printf("\n");
    printf("%d", mul5div8(5));
    printf("\n");
    printf("%d", mul5div8(-5));
    return 0;
}
