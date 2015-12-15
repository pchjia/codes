/*
 * w = 80; k = 15; n = 63;
 * positive minimum non-normalized number:
 *      binary description:
 *          s-e-1-f: 0-0000...0000-0-0000...0001
 *      V: (2 ^ (-63)) * (2 ^ (-2^14 + 2))
 *      decimal description:
 *          3.6452e-4951
 * positive minumun normalized number:
 *      binary description:
 *          s-e-1-f: 0-0000...0001-1-0000...0000
 *      V = 2 ^ (-2 ^ 14 + 2)
 *      decimal description:
 *          1.1897e+4932
 * maximun normalized mmber:
 *      binary description:
 *          s-e-1-f: 0-1111...1111-1-1111...1111
 *      V = (2 ^ 64 - 1) * (2 ^ (2 ^ 14 - 1))
 *      decimal description:
 *          1.1897e+4932
 */
