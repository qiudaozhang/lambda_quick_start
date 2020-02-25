package com.github.qiudaozhang;

import java.util.function.Supplier;

/**
 * 邱道长
 * 2020/2/25
 */

class User{
    String name;
    String age;


    public User() {
        System.out.println("我是构造方法哦");
    }
}

public class SupplierMain {

    public static void main(String[] args) {

//        Supplier supplier = () -> new Object();
        Supplier<User> supplier = User::new;
        supplier.get();
    }
}
