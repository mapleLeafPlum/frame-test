package com.test.java;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2019/1/11 cx
 */
public class test {
    public static void main(String[] args) {
        String objectIds="12323,3434343,12323,3434343";
        Set<String> ids = new HashSet<>(Arrays.asList(objectIds.split(",")));
        System.out.println(ids);
    }
}
