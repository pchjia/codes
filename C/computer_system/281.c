/*
 * create some arbitray values
 * int x = random();
 * int y = random();
 *
 * convert to unsigned
 * unsigned ux = (unsigned) x;
 * unsigned uy = (unsigned) y;
 *
 * A. (x>y) == (-x<-y):
 *          false: x=0, y=INT_MIN;
 * B. ((x+y)<<5) + x - y == 31*y + 33*x
 *          true: 
 * C. ~x + ~y == ~(x+y):
 *          false: 0xff 0xff
 * D. (int) (ux-uy) == -(y-x):
 *          true:
 * E. ((x >> 1) << 1) <=x
 *          true:
 */
