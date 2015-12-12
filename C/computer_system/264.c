#include<stdio.h>

// return 1 when any even bit of x equals 1; 0 otherwise  assume w=32
int any_even_one(unsigned x){
    // get w = 32
    // int w = sizeof(int) << 3;
    // 0xaa left shift
    // unsigned y = 0xaa;
    // do "y = (y << 8) | y" sizeof(int) times
    return (0xaaaaaaaa & x) != 0 ;
}

int main(int argc, const char *argv[])
{
    printf("%d", any_even_one(1u));
    printf("\n");
    printf("%d", any_even_one(2u));
    return 0;
}
