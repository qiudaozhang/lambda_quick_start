package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */


public class LambdaCanAccess {

    public static void main(String[] args) {

        int a = 3;
        Greeting g = () -> {
            System.out.println(a);
        };
    }
}
