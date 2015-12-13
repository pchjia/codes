#include<stdio.h>

// determine whether substraction arguments will cause overflow
int tsun_ovf(int x, int y){
    int ans = x - y;
    int w = sizeof(int) << 3;

    int ans_sign = ans >> (w-1);
    int x_sign = x >> (w-1);
    int y_sign = y >> (w-1);

    int ovf = (x_sign ^ y_sign) & (ans_sign ^ x_sign);

    return ovf & 1;
}

int main(int argc, const char *argv[])
{
    int w = sizeof(int) << 3;
    printf("%d", tsun_ovf(1<<(w-1), 1));
    printf("\n");
    printf("%d", tsun_ovf(0xff, 0xff));
    return 0;
}
