package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */

interface  OneParam{

    void show(int i);
}

public class OneParamDemo {

    public static void main(String[] args) {
        // lambda它能够类型推断，知道你这里面是一个int 类型的数据。
//        OneParam oneParam = (i) -> {
//            System.out.println(i * 2);
//        };

//        OneParam oneParam = (i) -> System.out.println(i*2);

        OneParam oneParam = i -> System.out.println(i*2);
        oneParam.show(3);
    }
}
