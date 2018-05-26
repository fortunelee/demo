package com.jpa.demo;

import com.jpa.demo.utils.AESUtil;

public class Demo {


    public static void main(String[] args) {


        String root = AESUtil.encrypt("root", null);
        System.out.println(root);
    }


}
