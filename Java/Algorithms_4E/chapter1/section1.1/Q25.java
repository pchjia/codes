public class Q25{
    /*
     * 欧几里德的算法关键在于证明等式gcd(a,b)=gcd(b,a mod b)的正确性。
     * 定理：a，b为正整数，则gcd(a,b)=gcd(b,a mod b) 
     * 证明：
     * k,r为整数，设r = a mod b,则a可以表示成a=kb+r。
     * 假设d是{a,b}的一个公约数，则d整除a,d整除b，而r=a-kb，因此d整除r，d也是b和r的公约数。 
     * 假设d是{b,r}的一个公约数，则d整除b,d整除r，而a=kb+r，因此d整除a, d也是a和b的公约数。
     * 因此{a,b}和{b,r}的公因子集合是一样的。特别地，{a,b}的最大共因子和{b,r}的最大公因子是一样的，即gcd(a,b)=gcd(b,a mod b)。
     */
}
