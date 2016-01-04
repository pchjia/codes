/*
 * TwoSum:
 *      int N = a.length;                       // A
 *      int cnt = 0;                            // A
 *      for (int i=0; i<N; i++) {               // A
 *          for (int j=i+1; j<N; j++) {         // B
 *              if (a[i] + a[j] == 0) {         // C
 *                  cnt ++;                     // D
 *              }
 *          }
 *      }
 * D    t0      x               t0*x
 * C    t1      N*(N-1)/2       t1*..
 * B    t2      N               t2*N
 * A    t3      1               t3
 *              total           t0*x + t1*N*(N-1)/2 + t2*N + t3
 *                              N*N
 */

public class Q4{}
