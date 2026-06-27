package leetCode.general.arrayList.String;

public class SimplifyPathV3 {
    public String simplifyPath(String path) {
        int n=path.length();
        char[] res=new char[n];
        int top=0;
        res[top++]='/';
        for(int i=1;i<n;i++){
            char c=path.charAt(i);
            if(c=='/'){
                if(res[top-1]=='/'){
                    continue;
                }
                res[top++]=c;
            }else if(c=='.'){
                    int cnt=1;
                    int left=i;

                    for(;left<n-1;left++){
                        if(path.charAt(left)==path.charAt(left+1)){
                            cnt++;
                        }else {
                            break;
                        }
                    }

                    boolean prevIsSlash=path.charAt(i-1)=='/';
                    boolean nextIsSlash= left==n-1 || path.charAt(left+1)=='/';
                    boolean IsWhole=prevIsSlash && nextIsSlash;

                    if(cnt==1 && IsWhole){
                        i=left;
                        continue;
                    }

                    if(cnt==2 && IsWhole){
                        while(top>1 && res[top-1]=='/'){
                            top--;
                        }

                        while(top>1 && res[top-1]!='/'){
                            top--;
                        }
                        i=left;
                        continue;
                    }

                    for(int num=0;num<cnt;num++){
                        res[top++]='.';
                    }
                    i=left;
                }else {
                res[top++]=c;
            }
        }
        if(top>1 && res[top-1]=='/'){
            top--;
        }
        return new String(res,0,top);
    }
}