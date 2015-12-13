#include<stdio.h>
#include<limits.h>

// addition that staturates to TMin or TMax
int staturaing_add(int x, int y){
    int sum = x + y;
    int w = sizeof(int) << 3;
    
    int sum_sign = sum >> (w-1);
    int x_sign = x >> (w-1);
    int y_sign = y >> (w-1);
    
    int pos_ovf = ~x_sign & ~y_sign & sum_sign;
    int neg_ovf = x_sign & y_sign & ~sum_sign;
    int no_ovf = ~(pos_ovf | neg_ovf);

    return (no_ovf & sum) | (pos_ovf & INT_MAX) | (neg_ovf & INT_MIN);
}

int main(int argc, const char *argv[])
{
    int w = sizeof(int) << 3;
    printf("%d", staturaing_add(1<<(w-2), 1<<(w-2)));
    printf("\n");
    
    printf("%d", staturaing_add(1<<(w-1), 1<<(w-1)));
    printf("\n");
    
    printf("%d", staturaing_add(0xff, 0xff));
    printf("\n");
    
    printf("%d", INT_MAX);
    printf("\n");
   
    printf("%d", INT_MIN);
    return 0;
}
