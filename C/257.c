#include<stdio.h>

typedef unsigned char * byte_pointer;

void show_bytes(byte_pointer start, int len){
    int i;
    for(i=0; i<len; i++){
        printf("  %.2x", start[i]);
    }
    printf("\n");
}

void show_int(int x){
    show_bytes((byte_pointer)&x, sizeof(int));
}

void show_float(float x){
    show_bytes((byte_pointer)&x, sizeof(float));
}

void show_pointer(void* x){
    show_bytes((byte_pointer)&x, sizeof(void*));
}

void show_short(short x){
    show_bytes((byte_pointer)&x, sizeof(short));
}

void show_long(long x){
    show_bytes((byte_pointer)&x, sizeof(long));
}

void show_double(double x){
    show_bytes((byte_pointer)&x, sizeof(double));
}


int main(int argc, const char *argv[])
{
    short s = 12345;
    long l = 12345;
    double d = 12345;
    show_short(s);
    show_long(l);
    show_double(d);
    return 0;
}
