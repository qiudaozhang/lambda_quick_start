package com.github.qiudaozhang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 邱道长
 * 2020/2/25
 */
public class LambdaStyleNonEle {

    public static void main(String[] args) {
        List<String> l = Arrays.asList("james",null,"bosh",null,"wade");
        List<String> strings = nonNull(l);
        System.out.println(strings);
    }

    public static  List<String> nonNull(List<String> l) {
        List<String> result = new ArrayList<>(l);
        result.removeIf(it -> it == null);// 最终以布尔类型取决
        // 传入一个谓词，是不是。
        return result;
    }
}
