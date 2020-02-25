package com.github.qiudaozhang;

/**
 * 邱道长
 * 2020/2/25
 */

interface  StaticRef{
    void show();
}
public class StaticRefMain {


    public static void main(String[] args) {
        StaticRef staticRef = StaticRefMain::myShow;
        staticRef.show();
    }

    public static void myShow() {
        System.out.println("爱老婆很好");
    }
}
