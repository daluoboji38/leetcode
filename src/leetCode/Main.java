package leetCode;

import leetCode.twoPointer.rainTrap;

// % 是求余运算符，而 / 才是求商运算符
public class Main {
    public void main(String[] args) {
        rainTrap ex = new rainTrap();
        int res = ex.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(res);
    }
}
