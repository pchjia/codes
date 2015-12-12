#include<stdio.h>

int int_size_is_32(){
    int set_msb = 1 << 15;
    set_msb <<= 15;
    set_msb <<= 1;
    int beyond_msb = 1 << 15;
    beyond_msb <<= 15;
    beyond_msb <<= 2;
    return set_msb && !beyond_msb;
}

int main(int argc, const char *argv[])
{
    printf("%d", int_size_is_32());
    return 0;
}
