package com.github.qiudaozhang;

import java.util.function.Consumer;

/**
 * 邱道长
 * 2020/2/25
 */
public class ParamTypeNeed {

    public static void main(String[] args) {
        show("ss",(String t) -> {
            System.out.println(t);
        });
    }


    public static void show(CharSequence s , Consumer<CharSequence> consumer) {
        System.out.println(1);
        consumer.accept(s);
    }

    public static void show(String s , Consumer<String> consumer) {
        System.out.println(2);
        consumer.accept(s);
    }

}
