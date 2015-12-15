// create some arbitrary values
/*
int x = random();
int y = random();
int z = random();

// convert to double
double dx = (double)x;
double dy = (double)y;
double dz = (double)z;


*/
// judge
/*
 * A. (double)(float)x == dx;           false: 32(float) < 64(double) INT_MAX
 * B. dx + dy == (double)(x + y);       false: dx + dx = INT_AX;
 * C. dx + dy + dz = dz + dy + dz;      true: same accuracy
 * D. dx * dy * dz = dz * dy * dx;      false: if dx * dy > DOUBLE_MAX but dz * dy == 1;
 * E. dx / dx == dy / dy;               false: 0
 */
