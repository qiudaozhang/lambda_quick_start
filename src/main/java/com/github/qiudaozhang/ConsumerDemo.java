package com.github.qiudaozhang;

import java.util.function.Consumer;

/**
 * 邱道长
 * 2020/2/25
 */
public class ConsumerDemo {

    public static void main(String[] args) {
//
//        Consumer consumer = (it) -> {
//            System.out.println(it);
//        };
//        consumer.accept("love");
        Consumer consumer = System.out::println;
        consumer.accept("love");

    }
}
