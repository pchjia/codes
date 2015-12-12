#include<stdio.h>

int is_little_endian(){
    int x = 1;
    return (int)(*(char*)&x);
}

int main(int argc, const char *argv[])
{
    printf("%d", is_little_endian());
    return 0;
}
