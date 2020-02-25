package com.github.qiudaozhang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 邱道长
 * 2020/2/25
 */
public class OldStyleNonEle {

    public static void main(String[] args) {
        List<String> l = Arrays.asList("james",null,"bosh",null,"wade");
        List<String> strings = nonNull(l);
        System.out.println(strings);
    }
    public static List<String> nonNull (List<String> l) {
        List<String> result = new ArrayList<>();

        for(String s:l) {
            if(s != null) {
                result.add(s);
            }
        }

        return result;
    }
}
