#include<stdio.h>

#include"255.c"


int _2_59(int x, int y){
    return  (x & 0xff) | (y & ~0xff);
}

int main(int argc, const char *argv[])
{
    show_int( _2_59(0x89ABCDEF, 0x76543210));
    return 0;
}


