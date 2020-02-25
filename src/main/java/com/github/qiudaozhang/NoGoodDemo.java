package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */
@FunctionalInterface
interface  NoGood{
    void good(int x);

    String toString();

}

public class NoGoodDemo {

    public static void main(String[] args) {
        NoGood n = (x) -> {};
    }
}
