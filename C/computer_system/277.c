#include<stdio.h>

// divide by power of two. assume 0 <= k <= w-1
int divide_power2(int x, int k){
    int w = sizeof(int) << 3;
    int x_sign = x >> (w-1);
    int x_carry = x & ((1<<k) - 1);
    x >>= k;
    x += x_sign && x_carry;
    return x;
}

int main(int argc, const char *argv[])
{
    printf("%d", divide_power2(3, 1));
    printf("\n");
    printf("%d", divide_power2(-3, 1));
    printf("\n");
    printf("%d", divide_power2(4, 1));
    printf("\n");
    printf("%d", divide_power2(-4, 1));
    return 0;
}
