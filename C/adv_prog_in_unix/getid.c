#include "apue.h"

int main(int argc, const char *argv[])
{
    printf("uid = %d, gid = %d\n", getuid(), getpid());
    return 0;
}
