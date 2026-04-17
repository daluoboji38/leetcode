package leetCode.binarySearch;
// 统计平方和三元组的数目

public class pythagoreanTheorem {
    public int countTriples(int n) {
        int ans = 0;
        for(int a =1; a<=n-2; a++){
            for(int b = a+1; b<=n-1; b++) {
                int sum = a*a + b*b;
                if(sum <= n*n) {
                    int left =b+1;
                    int right = n;
                    while(left<=right) {
                        int mid = (left+right)/2;
                        if(mid*mid==sum){
                            ans++;
                            break;
                        }else if(mid*mid<sum){
                            left = mid+1;
                        }else{
                            right = mid-1;
                        }
                        }
                }
            }
        }
        return 2*ans;
    }
}
