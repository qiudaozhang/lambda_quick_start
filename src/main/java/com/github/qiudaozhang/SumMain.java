package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */

interface SumInterface{
    int sum(int x ,int y);
}

public class SumMain {

    public static void main(String[] args) {
//        SumInterface sumInterface = (x,y) -> {return x + y;};
//
        SumInterface sumInterface = (x,y) ->  x + y;
        int sum = sumInterface.sum(3, 5);
        System.out.println(sum);
    }
}
