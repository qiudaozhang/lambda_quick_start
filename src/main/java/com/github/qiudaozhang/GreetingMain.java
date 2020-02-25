package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */
public class GreetingMain {
    public static void main(String[] args) {
        Greeting g = new HelloWorldGreeting();
        g.greet();
        Greeting g2 = new HelloBabyGreeting();
        g2.greet();
        // 如果一个逻辑，它只使用一次。
        Greeting g3 = new Greeting() {
            @Override
            public void greet() {
                System.out.println("你是不是有毛病啊");
            }
        };
        // 使用这种方式有大量的样板代码。
        // lambda必须能够赋值。
//        Greeting g3 = lambda;
        g3.greet();


        Greeting g4 = () -> {
            System.out.println("我是lambda");
        };



    }


}
