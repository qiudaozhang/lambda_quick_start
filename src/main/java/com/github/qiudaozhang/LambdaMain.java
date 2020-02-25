package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */
public class LambdaMain {

    public static void main(String[] args) {
        Greeting g = ()-> {
            System.out.println("我是lambda");
        };
        // 在这之前，它是不会执行的。
        g.greet();
    }
}
