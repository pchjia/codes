/*
 * a. int sum = 0;
 *    for (int n=N; n>0; n/=2) {
 *        for (int i=0; i<n; i++) {
 *            sum ++;
 *        }
 *    }
 *    //    Nlg(N)
 * b. int sum = 0;
 *    for (int i=1; i<N; i*=2) {
 *        for (int j=0; j<i; i++) {
 *            sum ++;
 *        }
 *    }
 *    //    lg(N)*lg(N)
 * c. int sum = 0;
 *    for (int i=1; i<N; i*=2) {
 *        for (int j=0; i<n; i++) {
 *            sum ++;
 *        }
 *    }
 *    //    Nlg(N)
 */

public class Q6 {}
