package com.kuang.utils;

import org.junit.Test;

import java.util.UUID;

public class IDutil {
    public static String genId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }







}
