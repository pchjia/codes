#include<stdio.h>
// [1 ^ (w-n)] [0 ^ n]:
//      ((((1 << (m-1)) - 1) << 1) + 1) & (~0 << n);
// [0 ^ (w-n-m)] [1 ^ n] [0 ^ m]
//      ((((1 << (m + n-1)) - 1) << 1) + 1) & (~0 << n);

int main(int argc, const char *argv[])
{
    int m = 8;
    int n = 4;
    int test1 = ((((1 << (m-1)) - 1) << 1) + 1) & (~0 << n);
    int test2 = ((((1 << (m + n-1)) - 1) << 1) + 1) & (~0 << n);
    printf("%x", test1);
    printf("\n");
    printf("%x", test2);
    return 0;
}
