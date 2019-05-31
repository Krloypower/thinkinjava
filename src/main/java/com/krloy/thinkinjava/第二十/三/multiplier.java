package com.krloy.thinkinjava.第二十.三;

/**
 * @ClassName multiplier
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-05-31 10:57
 **/
@ExtractInterface("IMultiplier")
public class multiplier {
    public int multiply(int x, int y){
        int total = 0;
        for (int i = 0; i < x; i++){
            total = add(total,y);
        }
        return total;
    }
    private int add(int x,int y){
        return x + y;
    }

    public static void main(String[] args) {
        multiplier m = new multiplier();
        System.out.println(m.multiply(11,16));
    }
}
