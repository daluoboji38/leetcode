package leetCode.binarySearch;

/** Discussion on the Properties of the Pythagorean Theorem
 * a,b and c are coprime with each other, or they are multiples of a set of coprime Pythagorean triples.
 * Both u and v are odd numbers and coprime with each other.
 * a=u*v,b=(u^2-v^2)/2,c=(u^2+v^2)/2,c+b=u^2,c-b=v^2;
 */
public class pythagoreanTheoremV3 {
    public int countTriples(int n) {
        int ans = 0;
        for (int u = 3; u * u <= 2 * n; u += 2) {
            for (int v = 1; v < u && u * u + v * v <= 2 * n; v += 2) {
                if (gcd(u, v) == 1) {
                    ans+=n*2/(u*u+v*v);// amount of base multiples
                }
            }
        }
        return ans*2;
    }

    private int gcd(int a, int b) {
        while (a!=0){
            int tmp=a;
            a=b%a;
            b=tmp;
        }
        return b;
    }

}
