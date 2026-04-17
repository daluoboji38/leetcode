package leetCode.general.TDArray;

// use for loop instead of intstream function
public class numberOfBeamsV3 {
    public int numberOfBeams(String[] bank) {
        int ans=0,index=0,curOne=0;
        while (index<bank.length && (curOne=calculate(bank[index]))==0) index++;

        index++;
        for(int nextOne=0;index<bank.length;){
            while (index<bank.length && (nextOne=calculate(bank[index]))==0) index++;
            if(index==bank.length) break;
            ans+=curOne*nextOne;
            curOne=nextOne;
            index++;
        }
        return ans;
    }

    private int calculate(String bank) {
        int ans=0;
        for (int i = 0; i < bank.length(); i++) {
            ans+=bank.charAt(i)-'0';
        }
        return ans;
    }
}
