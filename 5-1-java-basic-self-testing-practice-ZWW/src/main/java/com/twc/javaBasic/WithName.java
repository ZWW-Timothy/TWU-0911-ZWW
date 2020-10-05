package com.twc.javaBasic;

public interface WithName {
    default String getName() {
        return "WithName";
    }
}