#include<stdio.h>

int int_shifts_are_logical(){
    int x = -1;
    return !((x >> (sizeof(int)<<3)-1) + 1);
}

int main(int argc, const char *argv[])
{
    printf("%d", int_shifts_are_logical());
    return 0;
}
