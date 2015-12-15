/*
 * E M f V
 * A. 5.0
 *      s = 0
 *      1 <= M < 2
 *      0 <= f < 1
 *      101 -> 1.01: M = 1.01; E = 2;
 *      E = e - Bias;  Bias = 2 ^ (k-1) - 1; e = E + Bias;
 *      f = M - 1 = 0.01
 *      V = ((-1) ^ s) * M * (2 ^ E)
 *          binary description: s-e-f: 0-1000...0001-0100...0000
 * B. maximum odds integer:
 *      M = 1.1111...1111; n
 *      f = 0.1111...1111; 
 *      E = 2 ^ (k-1) - 1; e = E + Bias; Bias = 2 ^ (k-1) - 1;
 *      e = 2 ^ k - 2;
 *      s = 0
 *      V = M * (2 ^ E); V = 2 ^ (n+1) - 1;
 *          binary description: s-e-f: 0-1111...1110-1111....1111
 * C. minimum normalized number
 *          2 ^ (1 - Bias) -> 2 ^ (-2 ^ (k-1) + 2)
 *      reverse:
 *          2 ^ (2(k-1) - 2)
 *          M = 1.0000...0000;
 *          f = 0.0000...0000;
 *          Bias = 2 ^ (k-1) - 1;
 *          e = 2 ^ (k-1) - 2 + Bias; e = 2 ^ k - 3;
 *      binary description:
 *          0-1111...1101-0000...0000
