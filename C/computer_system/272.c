#include<stdio.h>
#include<string.h>

// copy integer into buff if space is available
void copy_int(int val, void *buf, int maxbytes){
    if(maxbytes > 0 && maxbytes >= sizeof(val)){
        printf("copying... # %d  %d", maxbytes, sizeof(val));
        memcpy(buf, (void*) &val, sizeof(val));
    }
}

int main(int argc, const char *argv[])
{
    int buf;
    copy_int(1, &buf, 2);
    copy_int(1, &buf, 8);
    return 0;
}
