package com.github.qiudaozhang;

import java.util.function.ToIntBiFunction;

/**
 * 邱道长
 * 2020/2/25
 */
public class ToIntFunctionMain {

    public static void main(String[] args) {
        ToIntBiFunction<String,String> toIntBiFunction = (x,y) -> Integer.parseInt(x) + Integer.parseInt(y);
        int i = toIntBiFunction.applyAsInt("37", "77");
        System.out.println(i);
    }
}
